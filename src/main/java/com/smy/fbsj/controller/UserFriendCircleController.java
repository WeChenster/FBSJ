package com.smy.fbsj.controller;

import com.smy.fbsj.model.UserDyn_msg;
import com.smy.fbsj.service.friendscircle.UserFriendsCircleBiz;
import com.smy.fbsj.service.global.GlobalBaseUsersBiz;
import com.zhuoan.dto.Dto;
import com.zhuoan.util.DateUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @Description: 用户朋友圈
 * @Author: lwt
 * @CreateDate: 2018/9/18
 * @Version: 1.0
 */
@Controller
@RequestMapping("/socialmode")
public class UserFriendCircleController {
    @Autowired
    GlobalBaseUsersBiz base_user;
    @Autowired
    UserFriendsCircleBiz userFriendCircleBiz;



    /**发布动态
      * @Description:  发布一条动态到我的朋友圈，并同步到好友的朋友圈。
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/insertdynamic",method = RequestMethod.POST)
    public String insertDynamic(@RequestParam("chain_add") String chain_add,//区块地址
                                @RequestParam("content") String content,//内容
                                @RequestParam("img") String img,//图片路径
                                @RequestParam("is_strange") String is_strange) throws IOException {//是否陌生人可见
        JSONObject obj=new JSONObject();

        if(chain_add!=null&&!chain_add.equals("")&&
                content!=null&&!content.equals("")&&
                img!=null&&!img.equals("")&&
                is_strange!=null&&!is_strange.equals("")){
            JSONObject us=base_user.getUserByIdOrChainAdd(chain_add);

            UserDyn_msg userDyn_msg=new UserDyn_msg();
            userDyn_msg.setUserId(us.getLong("id"));
            userDyn_msg.setRecUser(-1L);
            userDyn_msg.setContent(content);
            userDyn_msg.setImg(img);
            userDyn_msg.setType(Dto.ALL_FALSE);
            userDyn_msg.setCreateTime(DateUtils.gettimestamp());
            userDyn_msg.setGoodNum(0);
            userDyn_msg.setCommNum(0);
            userDyn_msg.setForwardNum(0);
            userDyn_msg.setIdDel(Dto.ALL_FALSE);
            userDyn_msg.setMemo("");
            userDyn_msg.setIsStrange(Integer.valueOf(is_strange));
            userDyn_msg.setIsForward(Dto.ALL_FALSE);
            userDyn_msg.setForwardRes("");
            userDyn_msg.setMsgId(-1L);

            Long insert_msg_id=userFriendCircleBiz.insertUserDynamicMessage(userDyn_msg);
            if(insert_msg_id!=null){
                obj.put("code", Dto.ALL_TRUE);
                obj.put("msg", "操作成功");
            }else{
                obj.put("code",Dto.ALL_FALSE);
                obj.put("msg","操作失败");
            }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "请参数填写完整");
        }
        return obj.toString();
    }

    /**
      * @Description:  获取朋友圈动态列表
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/getdynamic",method = RequestMethod.GET)
    public void getDynamic(@RequestParam("chain_add") String chain_add,//区块地址
                           @RequestParam(value = "now_page",defaultValue = "0") String now_page) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")){
            JSONObject User=base_user.getUserByIdOrChainAdd(chain_add);
            if(!User.isNullObject()&&!User.getString("id").equals("null")){
                JSONObject object=userFriendCircleBiz.getMyDynamicMessage(User.getLong("id"),Integer.valueOf(now_page));
            }else{

            }
        }else{

        }
    }

    /**
      * @Description:  转发动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping("/forwarddynamic.html")
    public void forwardDynamic(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    /**
      * @Description:  点赞动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping("/praiseddynamic.html")
    public void praisedDynamic(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    /**
      * @Description:  获取评论列表
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping("/getcommentlist.html")
    public void getCommentlist(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    /**
      * @Description:  评论动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping("/commentdynamic.html")
    public void commentDynamic(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    /**
      * @Description:  评论回复
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping("/replycommentdynamic.html")
    public void replyCommentDynamic(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    /**
      * @Description:  删除评论/删除评论回复
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping("/deletecomment.html")
    public void deleteComment(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    /**
      * @Description:  删除动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping("/deletedynamic.html")
    public void deleteDynamic(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

}
