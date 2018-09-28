package com.smy.fbsj.service.global.impl;

import com.github.pagehelper.PageHelper;
import com.smy.fbsj.mapper.UserAgreeMapper;
import com.smy.fbsj.mapper.UserFriendsMapper;
import com.smy.fbsj.model.UserAgree;
import com.smy.fbsj.model.UserFriends;
import com.smy.fbsj.service.PageInfo;
import com.smy.fbsj.service.global.GlobalUserAgreeBiz;
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

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 好友请求表
 * @Author: lwt
 * @CreateDate: 2018/9/6
 * @Version: 1.0
 */

@Service
@Primary
@Transactional
public class GlobalUserAgreeBizImpl implements GlobalUserAgreeBiz {
    @Autowired
    UserAgreeMapper user_agree;
    @Autowired
    UserFriendsMapper user_friend;


    @Override
    public JSONObject getUserApplyList(long user_id, int now_page) {

        PageHelper.startPage(now_page,Dto.GLOBAL_PAGE_SIZE);

        Map<Object,Object> par=new HashMap<>();
        par.put("user_id",user_id);
        par.put("id_del",Dto.ALL_FALSE);
        List<UserAgree> list = user_agree.selectObjectListByUserId(par);

        PageInfo<UserAgree> pageInfo =new PageInfo<>(list);
        JSONArray array=JSONArray.fromObject(pageInfo.getList());
        if(array.size()>0){
            pageInfo.setList(TimeUtil.transTimestamp(array,"createTime","yyyy-MM-dd HH:mm:ss"));
        }

        return JSONObject.fromObject(pageInfo);
    }

    @Override
    public Long isExistRelation(long user_id, long rec_user) {
        return user_agree.selectByUserIdAndRecUser(user_id,rec_user);
    }

    @Override
    public boolean addBuddyAction(long user_id, long rec_user) {
        UserFriends u1=new UserFriends();
        u1.setUserId(user_id);
        u1.setRecUser(rec_user);
        u1.setCreateTime(DateUtils.gettimestamp());
        u1.setTop(Dto.ALL_FALSE);
        u1.setMsgNot(Dto.ALL_FALSE);
        u1.setHideHer(Dto.ALL_FALSE);
        u1.setHideMe(Dto.ALL_FALSE);
        u1.setIsBlacklist(Dto.ALL_FALSE);
        u1.setIdDel(Dto.ALL_FALSE);
        int u1Rs=user_friend.insert(u1);

        UserFriends u2=new UserFriends();
        u2.setUserId(rec_user);
        u2.setRecUser(user_id);
        u2.setCreateTime(DateUtils.gettimestamp());
        u2.setTop(Dto.ALL_FALSE);
        u2.setMsgNot(Dto.ALL_FALSE);
        u2.setHideHer(Dto.ALL_FALSE);
        u2.setHideMe(Dto.ALL_FALSE);
        u2.setIsBlacklist(Dto.ALL_FALSE);
        u2.setIdDel(Dto.ALL_FALSE);
        int u2Rs=user_friend.insert(u2);
        if(u1Rs>0&&u2Rs>0){
            return  true;
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public boolean deleteUserAgreeById(long agree_id) {
        UserAgree userAgree=new UserAgree();
        userAgree.setId(agree_id);
        userAgree.setIdDel(Dto.ALL_TRUE);//逻辑删除
        int effo= user_agree.updateByPrimaryKeySelective(userAgree);
        if(effo>0)
            return true;
        else
            return false;
    }
}
