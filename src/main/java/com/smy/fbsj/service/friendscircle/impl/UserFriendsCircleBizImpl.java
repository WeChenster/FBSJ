package com.smy.fbsj.service.friendscircle.impl;



import com.smy.fbsj.model.UserComments;
import com.smy.fbsj.model.UserDyn_msg;
import com.smy.fbsj.model.UserTimeStamp;
import com.smy.fbsj.service.friendscircle.UserFriendsCircleBiz;
import com.smy.fbsj.service.global.*;
import com.zhuoan.dto.Dto;

import com.zhuoan.util.DateUtils;
import com.zhuoan.util.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


/**
 * @Description: 用户动态操作
 * @Author: lwt
 * @CreateDate: 2018/9/10
 * @Version: 1.0
 */
@Service
@Primary
@Transactional
public class UserFriendsCircleBizImpl implements UserFriendsCircleBiz {

    @Autowired
    GlobalBaseUsersBiz base_users;
    @Autowired
    GlobalUserDynMsgBiz user_dyn_msg;
    @Autowired
    GlobalUserTimeStampBiz user_time_stamp;
    @Autowired
    GlobalUserFriendsBiz user_friends;
    @Autowired
    GlobalUserCommentsBiz user_comments;

    @Override
    public Long insertUserDynamicMessage(UserDyn_msg userDynMsg) {
        //1、插入广场消息表
        Long msg_id=user_dyn_msg.insertUserDynMsg(userDynMsg);

        if(msg_id!=null){
            //2、在当前用户的时间轴上插入一条记录（is_main=1）
            UserTimeStamp userTimeStamp=new UserTimeStamp();
            userTimeStamp.setUserId(userDynMsg.getUserId());
            userTimeStamp.setUdmsgId(msg_id);
            userTimeStamp.setCreateTime(DateUtils.gettimestamp());
            userTimeStamp.setIsMine(Dto.ALL_TRUE);
            userTimeStamp.setIdDel(Dto.ALL_FALSE);
            Long uts_id=user_time_stamp.insertLine(userTimeStamp);

            if(uts_id!=null){
                //3、判断是否陌生人可见，触发时间轴（用户ID，消息ID, 是否陌生人可见）
                JSONArray array;
                if(userDynMsg.getIsStrange()== Dto.ALL_TRUE){
                    //陌生人可见  系统所有用户
                    array= base_users.getAllUsers();
                }else{
                    //只 好友可见
                    JSONObject ob=user_friends.getUserFriendsByUserId(userDynMsg.getUserId(),null);
                    array=JSONArray.fromObject(ob.get("list"));
                }
                //遍历列表为该列表下的用户朋友圈时间轴中添加一条记录
                for (int i = 0; i < array.size(); i++) {
                    JSONObject ob=array.getJSONObject(i);
                    long uid=ob.getLong("id");
                    UserTimeStamp uts=new UserTimeStamp();
                    uts.setUserId(uid);
                    uts.setUdmsgId(msg_id);
                    uts.setCreateTime(DateUtils.gettimestamp());
                    uts.setIsMine(Dto.ALL_FALSE);
                    uts.setIdDel(Dto.ALL_FALSE);
                    Long uts_id2=user_time_stamp.insertLine(uts);
                    Dto.writeLog("第"+i+"位用户时间轴插入结果："+uts_id2);
                    if(uts_id2==null){
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return msg_id;
                    }
                }
                return null;
            }else{
                Dto.writeLog("插入朋友圈时间轴结果："+uts_id);
                return null;
            }
        }else{
            Dto.writeLog("插入动态表结果："+msg_id);
            return null;
        }
    }

    @Override
    public JSONObject getMyDynamicMessage(long user_id,Integer now_page) {

        JSONArray array=new JSONArray();

        JSONObject utsObj = user_time_stamp.getUserTimeStampListByUserId(user_id,now_page);
        JSONArray arr=JSONArray.fromObject(utsObj.get("list"));
        for (int i = 0; i < arr.size(); i++) {
            JSONObject ob = arr.getJSONObject(i);
            long msg_id = ob.getLong("udmsg_id");//动态消息id

            JSONObject udm = JSONObject.fromObject(user_dyn_msg.getUserDynMsgById(msg_id));
            udm= TimeUtil.transTimeStamp(udm,"yyyy-MM-dd HH:mm:ss","createTime");
            array.add(i, udm);
        }
        utsObj.element("list",array);
        return utsObj;
    }

    @Override
    public boolean forwardUserDynamicMessage(UserDyn_msg userDynMsg) {
        //插入一条广场消息表
        Long msg_id= insertUserDynamicMessage(userDynMsg);

        //更新转发动态数
        boolean effo1=user_dyn_msg.updateColumnValue(" forward_num = forward_num + 1 ",userDynMsg.getMsgId());

        //插入一条转发类型记录
        UserComments uc=new UserComments();
        uc.setImg(msg_id);
        uc.setUserId(userDynMsg.getUserId());
        uc.setRecUser(0L);
        uc.setType(Dto.USER_COMMENT_TYPE_FORWRAD);
        uc.setIdDel(Dto.ALL_FALSE);
        uc.setCreateTime(DateUtils.gettimestamp());

        Long uc_id=user_comments.insertLines(uc);

        if(msg_id!=null&&effo1&&uc_id!=null){
            return true;
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public boolean praiseUserDynamicMessage(UserComments userComments) {
        //查询 用户是否点赞消息  如果有就删除 如果没有就添加一条记录
        UserDyn_msg userDynMsg= user_dyn_msg.getUserDynMsgById(userComments.getImg());

        JSONObject uc=user_comments.isPraise(userDynMsg.getId(),userDynMsg.getUserId(), Dto.USER_COMMENT_TYPE_PRAISE);
        if(!uc.isNullObject()&&uc.containsKey("id")&&!uc.getString("id").equals("null")){ //取消点赞
            //更新消息点赞数
            boolean effo1=user_dyn_msg.updateColumnValue(" good_num = good_num - 1 ",userDynMsg.getMsgId());

            //删除点赞记录
            boolean effo2=user_comments.deleteById(uc.getLong("id"));

            if(effo1&&effo2){
                return true;
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }else{//点赞操作
            //更新消息点赞数
            boolean effo_1=user_dyn_msg.updateColumnValue(" good_num = good_num + 1 ",userDynMsg.getMsgId());

            Long effo_2=user_comments.insertLines(userComments);

            if(effo_1&&effo_2!=null){
                return true;
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
    }

    @Override
    public Long commentUserDynamicMessage(UserComments userComments) {
        //更新消息表中的评论数
        boolean effo1=user_dyn_msg.updateColumnValue(" comm_num = comm_num + 1 ",userComments.getImg());

        //添加评论记录
        Long effo_2=user_comments.insertLines(userComments);
        if(effo1&&effo_2!=null){
            return effo_2;
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    @Override
    public boolean deleteUserDynamicMessage(long udmsg_id) {

        //1、删除广场消息表
        boolean effo=user_dyn_msg.deleteLineById(udmsg_id);

        //2、删除朋友圈 时间轴相关消息记录
        boolean effo1=user_time_stamp.deleteByMsgId(udmsg_id);

        //3、删除该消息的所有评论记录
        boolean effo2=user_comments.deleteByMsgId(udmsg_id);
        if(effo&&effo1&&effo2){
            return true;
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }


}
