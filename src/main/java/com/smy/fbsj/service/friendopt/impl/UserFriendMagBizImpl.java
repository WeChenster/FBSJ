package com.smy.fbsj.service.friendopt.impl;


import com.smy.fbsj.mapper.UserAgreeMapper;
import com.smy.fbsj.model.UserAgree;
import com.smy.fbsj.model.UserFriends;
import com.smy.fbsj.service.friendopt.UserFriendMagBiz;
import com.smy.fbsj.service.global.GlobalBaseUsersBiz;
import com.smy.fbsj.service.global.GlobalUserAgreeBiz;
import com.smy.fbsj.service.global.GlobalUserFriendsBiz;
import com.zhuoan.dto.Dto;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户体系接口Impl
 * @Author: lwt
 * @CreateDate: 2018/9/5
 * @Version: 1.0
 */
@Service
@Primary
@Transactional
public class UserFriendMagBizImpl implements UserFriendMagBiz {
    @Autowired
    UserAgreeMapper user_agreeMapper;
    @Autowired
    GlobalUserFriendsBiz user_fiend;
    @Autowired
    GlobalUserAgreeBiz user_agree;


    @Override
    public Long addNewFriends(UserAgree userAgree) {
        int effo=user_agreeMapper.insert(userAgree);
        if(effo>0){
            Long id=userAgree.getId();
            return id;
        }else{
            return null;
        }
        //TODO:客户点发送消息到被添加的用户,发消息给user_id
    }


    @Override
    public boolean addFriendRequestProcess(long agree_id, int type) {
        //获取该消息记录
        UserAgree useragree = user_agreeMapper.selectByPrimaryKey(agree_id);
        if(useragree!=null){
            //判断处理类型
            if(type== Dto.FRIENDS_APPLE_TYPE_ACCEPT){//类型为：接受
                //1、添加好友操作
                boolean effo=user_agree.addBuddyAction(useragree.getUserId(),useragree.getSrcId());

                //2、修改该消息记录的处理类型
                useragree.setType(Dto.FRIENDS_APPLE_TYPE_ADDED);//设置类型为已添加好友
                int effo1=user_agreeMapper.updateByPrimaryKeySelective(useragree);

                if(effo&&effo1>0){
                    //TODO:客户端发送消息到被添加的用户：已成为好友可以互相聊天
                    return true;
                }else{
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }else{
                return false;
            }
        }else{
            Dto.writeLog("好友请求表记录："+agree_id+"不存在");
            return  false;
        }
    }

    @Override
    public boolean updateFriendSetting(UserFriends userFriends) {
        //待定
        return false;
    }

    @Override
    public Long getFriendRelsId(long user_id, long rec_user){
        Map<Object,Object> par =new HashMap<>();
        par.put("user_id",user_id);
        par.put("rec_user",rec_user);
        par.put("id_del",Dto.ALL_FALSE);
        Long id=null;
        List<UserAgree> userAgree= user_agreeMapper.selectObjectListByUserId(par);
        for (int i = 0; i <userAgree.size() ; i++) {
            UserAgree ua=userAgree.get(i);
            id=ua.getId();
            if(id!=null) break;
            Dto.writeLog("第"+i+"次遍历userAgree，ID="+id);
        }
        if(id!=null){
            return id;
        }else{
            return null;
        }
    }


    @Override
    public boolean deleteFriend(long user_id, long rec_user) {
        //查询好友关系是否存在
        Long Fd1=this.getFriendRelsId(user_id,rec_user);
        Long Fd2=this.getFriendRelsId(rec_user,user_id);

        if(Fd1!=null&&Fd2!=null){
            //删除好友关系
            boolean fd1=user_fiend.deleteSingleFriend(Fd1);
            boolean fd2=user_fiend.deleteSingleFriend(Fd2);

            //查询还有申请记录
            Long Rel_1= user_agree.isExistRelation(user_id,rec_user);
            Long Rel_2= user_agree.isExistRelation(rec_user,user_id);
            boolean ug1=true;
            boolean ug2=true;
            //1、删除好友申请记录
            if(Rel_1!=null){
                ug1=user_agree.deleteUserAgreeById(Rel_1);
            }
            if(Rel_2!=null){
                ug2=user_agree.deleteUserAgreeById(Rel_2);
            }

            //TODO:触发朋友圈时间轴  删除好友动态

            if(fd1&&fd2&&ug1&&ug2){
                return true;
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }else{
            return false;
        }
    }


}
