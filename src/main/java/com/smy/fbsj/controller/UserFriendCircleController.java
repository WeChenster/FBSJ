package com.smy.fbsj.controller;

import com.smy.fbsj.model.UserComments;
import com.smy.fbsj.model.UserDyn_msg;
import com.smy.fbsj.service.friendscircle.UserFriendsCircleBiz;
import com.smy.fbsj.service.global.GlobalBaseUsersBiz;
import com.smy.fbsj.service.global.GlobalUserCommentsBiz;
import com.smy.fbsj.service.global.GlobalUserDynMsgBiz;
import com.zhuoan.dto.Dto;
import com.zhuoan.util.DateUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 * @Description: 用户朋友圈
 * @Author: lwt
 * @CreateDate: 2018/9/18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/socialmode")
public class UserFriendCircleController {
    @Autowired
    GlobalBaseUsersBiz base_user;
    @Autowired
    UserFriendsCircleBiz userFriendCircleBiz;
    @Autowired
    GlobalUserDynMsgBiz userDynMsgBiz;
    @Autowired
    GlobalUserCommentsBiz user_commentBiz;



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
            if(insert_msg_id != null){
                obj.element("code", Dto.ALL_TRUE).element("msg", "操作成功");
            }else{
                obj.element("code",Dto.ALL_FALSE).element("msg","操作失败");
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
    public String getDynamic(@RequestParam("chain_add") String chain_add,//区块地址
                           @RequestParam(value = "now_page",defaultValue = "0") String now_page) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")){
            JSONObject User=base_user.getUserByIdOrChainAdd(chain_add);
            if(!User.isNullObject()&&!User.getString("id").equals("null")){
                JSONObject object=userFriendCircleBiz.getMyDynamicMessage(User.getLong("id"),Integer.valueOf(now_page));
                obj.put("code",Dto.ALL_TRUE);
                obj.put("msg","获取成功");
                obj.put("data",object);
            }else{
                obj.put("code",Dto.ALL_FALSE);
                obj.put("msg","用户不存在");
            }
        }else{
            obj.put("code",Dto.ALL_FALSE);
            obj.put("msg","用户区块不能为空");
        }
        return  obj.toString();
    }

    /**
      * @Description:  转发动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/forwarddynamic",method = RequestMethod.POST)
    public String forwardDynamic(@RequestParam("chain_add") String chain_add,
                               @RequestParam("fdmsg_id") String fdmsg_id,//转发消息id
                               @RequestParam("fd_reason") String fd_reason,//转发理由
                               @RequestParam(value = "is_strange",defaultValue = "1") String is_strange) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")&&
                fdmsg_id!=null&&!fdmsg_id.equals("")&&
                fd_reason!=null&&!fd_reason.equals("")){

            JSONObject User=base_user.getUserByIdOrChainAdd(chain_add);
            if(!User.isNullObject()&&!User.getString("id").equals("null")){
                UserDyn_msg user_dyn_msg= userDynMsgBiz.getUserDynMsgById(Long.valueOf(fdmsg_id));
                if(user_dyn_msg!=null&&user_dyn_msg.getId()!=null){
                    UserDyn_msg userDyn_msg=new UserDyn_msg();
                    userDyn_msg.setUserId(User.getLong("id"));
                    userDyn_msg.setRecUser(user_dyn_msg.getUserId());
                    userDyn_msg.setContent(user_dyn_msg.getContent());
                    userDyn_msg.setImg(user_dyn_msg.getImg());
                    userDyn_msg.setType(user_dyn_msg.getType());
                    userDyn_msg.setCreateTime(DateUtils.gettimestamp());
                    userDyn_msg.setGoodNum(0);
                    userDyn_msg.setCommNum(0);
                    userDyn_msg.setForwardNum(0);
                    userDyn_msg.setIdDel(Dto.ALL_FALSE);
                    userDyn_msg.setMemo("");
                    userDyn_msg.setIsStrange(Integer.valueOf(is_strange));
                    userDyn_msg.setIsForward(Dto.ALL_TRUE);
                    userDyn_msg.setForwardRes(fd_reason);
                    userDyn_msg.setMsgId(user_dyn_msg.getId());
                    boolean effo= userFriendCircleBiz.forwardUserDynamicMessage(userDyn_msg);
                    if(effo){
                        obj.put("code",Dto.ALL_FALSE);
                        obj.put("msg","转发成功");
                    }else{
                        obj.put("code",Dto.ALL_FALSE);
                        obj.put("msg","转发失败");
                    }
                }else{
                    obj.put("code",Dto.ALL_FALSE);
                    obj.put("msg","动态不存在");
                }
            }else{
                obj.put("code",Dto.ALL_FALSE);
                obj.put("msg","用户不存在");
            }
        }else{
            obj.element("code",Dto.ALL_FALSE).element("msg","请将参数填写完整");
        }
        return obj.toString();
    }

    /**
      * @Description:  点赞动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/praiseddynamic",method = RequestMethod.POST)
    public String praisedDynamic(@RequestParam("chain_add") String chain_add,@RequestParam("msg_id") String msg_id) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")&&msg_id!=null&&!msg_id.equals("")){
            JSONObject User=base_user.getUserByIdOrChainAdd(chain_add);
            if(!User.isNullObject()&&!User.getString("id").equals("null")){
                UserComments userComments=new UserComments();
                userComments.setImg(Long.valueOf(msg_id));
                userComments.setUserId(User.getLong("id"));
                userComments.setType(Dto.USER_COMMENT_TYPE_PRAISE);
                userComments.setRecUser(-1L);
                userComments.setContent("");
                userComments.setCreateTime(DateUtils.gettimestamp());
                userComments.setIdDel(Dto.ALL_FALSE);
                userComments.setMemo("");
                boolean effo=userFriendCircleBiz.praiseUserDynamicMessage(userComments);
                if(effo){
                    obj.element("code",Dto.ALL_TRUE).element("msg","点赞成功");
                }else{
                    obj.element("code",Dto.ALL_FALSE).element("msg","点赞失败");
                }
            }else{
                obj.element("code",Dto.ALL_FALSE).element("msg","用户不存在");
            }
        }else{
            obj.element("code",Dto.ALL_FALSE).element("msg","请将参数填写完整");
        }
        return obj.toString();
    }

    /**
      * @Description:  获取评论列表
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/getcommentlist",method = RequestMethod.GET)
    public String getCommentlist(@RequestParam("msg_id") String msg_id,
                               @RequestParam(value = "now_page",defaultValue = "0") String now_page) throws IOException {
        return "";
    }

    /**
      * @Description:  评论动态/评论回复
      * @Pramers:      传入参数
      * @return:       返回类型 评论表记录的ID
     */
    @RequestMapping(value = "/commentdynamic",method = RequestMethod.POST)
    public String commentDynamic(@RequestParam("chain_add") String chain_add,
                               @RequestParam("msg_id") String msg_id,
                               @RequestParam("content") String content,
                                 @RequestParam(value = "reply_chain",defaultValue = "") String reply_chain) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")&&msg_id!=null&&!msg_id.equals("")&&content!=null&&!content.equals("")){
            JSONObject User=base_user.getUserByIdOrChainAdd(chain_add);
            if(!User.isNullObject()&&!User.getString("id").equals("null")){
                UserComments userComments=new UserComments();
                userComments.setUserId(User.getLong("id"));
                userComments.setImg(Long.valueOf(msg_id));
                userComments.setType(Dto.USER_COMMENT_TYPE_COM);
                userComments.setContent(content);
                userComments.setCreateTime(DateUtils.gettimestamp());
                userComments.setIdDel(Dto.ALL_FALSE);
                userComments.setMemo("");
                if(reply_chain!=null&&!reply_chain.equals("")){//如户果有关联用就 是有回复用户
                    JSONObject rec_User=base_user.getUserByIdOrChainAdd(reply_chain);
                    userComments.setRecUser(rec_User.getLong("id"));
                }else{
                    userComments.setRecUser(-1L);
                }

                Long com_id = userFriendCircleBiz.commentUserDynamicMessage(userComments);
                if(com_id!=null){
                    JSONObject data=new JSONObject();
                    data.put("com_id",com_id);
                    obj.element("code",Dto.ALL_TRUE).element("data",data).element("msg","评论成功");
                }else{
                    obj.element("code",Dto.ALL_FALSE).element("msg","评论失败");
                }
            }else{
                obj.element("code",Dto.ALL_FALSE).element("msg","用户不存在");
            }
        }else{
            obj.element("code",Dto.ALL_FALSE).element("msg","请将参数填写完整");
        }
        return obj.toString();
    }

    /**
      * @Description:  删除评论/删除评论回复
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/deletecomment",method = RequestMethod.DELETE)
    public String deleteComment(@RequestParam("chain_add") String chain_add,@RequestParam("com_id") String com_id) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")&&com_id!=null&&!com_id.equals("")){
            boolean effo=user_commentBiz.deleteById(Long.valueOf(com_id));
            if(effo){
                obj.element("code",Dto.ALL_TRUE).element("msg","删除成功");
            }else{
                obj.element("code",Dto.ALL_FALSE).element("msg","删除失败");
            }
        }else{
            obj.element("code",Dto.ALL_FALSE).element("msg","请将参数填写完整");
        }
        return obj.toString();
    }

    /**
      * @Description:  删除动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/deletedynamic",method = RequestMethod.DELETE)
    public String deleteDynamic(@RequestParam("chain_add") String chain_add,@RequestParam("msg_id") String msg_id) throws IOException {
        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")&&msg_id!=null&&!msg_id.equals("")){
            boolean effo=userFriendCircleBiz.deleteUserDynamicMessage(Long.valueOf(msg_id));
            if(effo){
                obj.element("code",Dto.ALL_TRUE).element("msg","删除失败");
            }else{
                obj.element("code",Dto.ALL_FALSE).element("msg","删除成功");
            }
        }else{
            obj.element("code",Dto.ALL_FALSE).element("msg","请将参数填写完整");
        }
        return obj.toString();
    }

}
