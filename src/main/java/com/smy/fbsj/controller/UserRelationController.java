package com.smy.fbsj.controller;


import com.smy.fbsj.model.UserAgree;
import com.smy.fbsj.service.friendopt.UserFriendMagBiz;
import com.smy.fbsj.service.global.GlobalBaseUsersBiz;
import com.smy.fbsj.service.global.GlobalUserAgreeBiz;
import com.smy.fbsj.service.global.GlobalUserFriendsBiz;
import com.zhuoan.dto.Dto;
import com.zhuoan.util.CheckTypeUtil;
import com.zhuoan.util.DateUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 用户关系体系
 * @Author: lwt
 * @CreateDate: 2018/9/18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/socialmode")
public class UserRelationController {
    @Autowired
    GlobalBaseUsersBiz base_user;
    @Autowired
    GlobalUserAgreeBiz user_agree;
    @Autowired
    UserFriendMagBiz user_friend_mag;
    @Autowired
    GlobalUserFriendsBiz user_friend;


    /**获取好友申请记录
      * @Description:  传入用户区块获取该用户的好友申请记录，进行操作
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/getfriendagree",method = RequestMethod.GET)
    public String getFriendAgree(@RequestParam("chain_add") String chain_add,
                                 @RequestParam(value = "now_page",defaultValue = "1") String now_page) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")){
            JSONObject user=base_user.getUserByIdOrChainAdd(chain_add);
            if(user!=null&&user.containsKey("id")&&!user.getString("id").equals("null")){
                JSONObject data=user_agree.getUserApplyList(user.getLong("id"),Integer.valueOf(now_page));
                obj.put("code", Dto.ALL_TRUE);
                obj.put("msg", "获取成功");
                obj.put("data", data);
            }else{
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "用户不存在");
            }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "用户区块不能为空");
        }
        return obj.toString();
    }


    /**发送好友申请
      * @Description:  查找好友后，需要发送好友申请，等待对方同意。
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/addfriendagree",method = RequestMethod.POST)
    public String addFriendAgree(@RequestParam("chain_add") String chain_add,//用户区块
                                 @RequestParam("rec_chain") String rec_chain,//来源用户区块
                                 @RequestParam("friend_from") String friend_from,//来源类型  0：通讯录  1：查找
                                 @RequestParam(value = "reason",defaultValue = "") String reason) throws IOException {
        JSONObject obj=new JSONObject();

        if(chain_add!=null&&!chain_add.equals("")&&
                rec_chain!=null&&!rec_chain.equals("")&&
                friend_from!=null&&!friend_from.equals("")){
            if(!CheckTypeUtil.isNumber(friend_from)){
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "来源类型必须是数字");
                return obj.toString();
            }
             JSONObject user =base_user.getUserByIdOrChainAdd(chain_add);
             JSONObject rec_user =base_user.getUserByIdOrChainAdd(rec_chain);
             if(!user.isNullObject()&&user.containsKey("id")&&!user.getString("id").equals("null")){
                if(!rec_user.isNullObject()&&rec_user.containsKey("id")&&!rec_user.getString("id").equals("null")){
                    //组织好友申请对象
                    UserAgree usera=new UserAgree();
                    usera.setUserId(user.getLong("id"));
                    usera.setSrcId(rec_user.getLong("id"));
                    usera.setReason(reason!=null?reason:"");
                    usera.setCreateTime(DateUtils.gettimestamp());
                    usera.setFriendFrom(friend_from);
                    usera.setType(Dto.FRIENDS_APPLE_TYPE_ACCEPT);
                    usera.setIdDel(Dto.ALL_FALSE);

                    Long apply_msg=user_friend_mag.addNewFriends(usera);
                    if(apply_msg!=null){
                        obj.put("code", Dto.ALL_TRUE);
                        obj.put("msg", "操作成功");
                    }else{
                        obj.put("code", Dto.ALL_FALSE);
                        obj.put("msg", "操作失败");
                    }
                }else{
                    obj.put("code", Dto.ALL_FALSE);
                    obj.put("msg", "来源用户不存在");
                }
             }else{
                 obj.put("code", Dto.ALL_FALSE);
                 obj.put("msg", "用户不存在");
             }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "请将输入必填字段");
        }
        return obj.toString();
    }


    /**
      * @Description:  接受好友申请
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/acceptfriendagree",method = RequestMethod.PUT)
    public String acceptFriendAgree(@RequestParam("agree_id") String agree_id,
                                    @RequestParam("chain_add") String chain_add) throws IOException {
        JSONObject obj=new JSONObject();

        if(agree_id!=null&&!agree_id.equals("")&&chain_add!=null&&!chain_add.equals("")){
            if(!CheckTypeUtil.isNumber(agree_id)){
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "好友记录必须是整数");
                return obj.toString();
            }
            boolean effo=user_friend_mag.addFriendRequestProcess(Long.valueOf(agree_id), Dto.FRIENDS_APPLE_TYPE_ACCEPT);
            if(effo){
                obj.put("code", Dto.ALL_TRUE);
                obj.put("msg", "操作成功");
            }else{
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "操作失败");
            }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "请将输入必填字段");
        }
        return obj.toString();
    }

    /**
      * @Description:  获取好友列表
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/getuserfriends",method = RequestMethod.GET)
    public String getUserFriends(@RequestParam("chain_add") String chain_add,
                               @RequestParam(value = "now_page",defaultValue = "1") String now_page) throws IOException {
        JSONObject obj=new JSONObject();

        if(chain_add!=null&&!chain_add.equals("")){
            JSONObject us=base_user.getUserByIdOrChainAdd(chain_add);
            if(!us.isNullObject()&&us.containsKey("id")&&!us.getString("id").equals("null")){

                JSONObject result=user_friend.getUserFriendsByUserId(us.getLong("id"),Integer.valueOf(now_page));


                obj.put("code", Dto.ALL_TRUE);
                obj.put("msg", "获取成功");
                obj.put("data",result);
            }else{
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "用户不存在");
            }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "请将输入必填字段");
        }
        return obj.toString();
    }

    /**
      * @Description:  获取好友设置信息
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/getuserfriendsetting",method = RequestMethod.GET)
    public String getUserFriendSetting(@RequestParam("chain_add") String chain_add,
                                       @RequestParam("ufd_id") String ufd_id) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")&&ufd_id!=null&&!ufd_id.equals("")){
            if(CheckTypeUtil.isNumber(ufd_id)){
                JSONObject uf=user_friend.getUserFriendsById(Long.valueOf(ufd_id));
                obj.put("code", Dto.ALL_TRUE);
                obj.put("msg", "获取成功");
                obj.put("data", uf);
            }else{
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "好友记录必须是整数");
            }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "请将输入必填字段");
        }
        return obj.toString();
    }


    /**
     * @Description:  修改好友设置信息
     * @Pramers:      传入参数
     * @return:       返回类型
     */
    @RequestMapping(value = "/updateuserfriendsetting",method = RequestMethod.PUT)
    public void updateUserFriendSetting(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    /**删除好友
      * @Description:  删除好友申请记录以及好友关系，并且在朋友圈中也删除该好友的所有动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/deleteuserfriend",method = RequestMethod.DELETE)
    public String deleteUserFriend(@RequestParam("chain_add") String chain_add,
                                   @RequestParam("rec_chain") String rec_chain) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")&&rec_chain!=null&&!rec_chain.equals("")){
            JSONObject User=base_user.getUserByIdOrChainAdd(chain_add);
            if(!User.isNullObject()&&User.containsKey("id")&&!User.getString("id").equals("null")){
                JSONObject recUser=base_user.getUserByIdOrChainAdd(rec_chain);
                if(!recUser.isNullObject()&&recUser.containsKey("id")&&!recUser.getString("id").equals("null")){
                    boolean effo=user_friend_mag.deleteFriend(User.getLong("id"),recUser.getLong("id"));
                    if(effo){
                        obj.put("code", Dto.ALL_TRUE);
                        obj.put("msg", "删除成功");
                    }else{
                        obj.put("code", Dto.ALL_FALSE);
                        obj.put("msg", "删除失败");
                    }
                }else{
                    obj.put("code", Dto.ALL_FALSE);
                    obj.put("msg", "删除的好友不存在");
                }
            }else{
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "传入的用户不存在");
            }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "请将输入必填字段");
        }
        return obj.toString();
    }
}
