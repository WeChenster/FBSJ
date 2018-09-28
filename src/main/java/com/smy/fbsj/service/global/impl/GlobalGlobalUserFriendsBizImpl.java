package com.smy.fbsj.service.global.impl;
/**
 * @Description: 用户关系表
 * @Author: lwt
 * @CreateDate: 2018/9/11
 * @Version: 1.0
 */

import com.github.pagehelper.PageHelper;
import com.smy.fbsj.mapper.UserFriendsMapper;
import com.smy.fbsj.model.UserFriends;
import com.smy.fbsj.service.PageInfo;
import com.smy.fbsj.service.global.GlobalUserFriendsBiz;
import com.zhuoan.dto.Dto;
import com.zhuoan.util.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@auther:Administrator
 *@Date:2018/9/11
 *@descriotion:
 */
@Service
@Primary
@Transactional
public class GlobalGlobalUserFriendsBizImpl implements GlobalUserFriendsBiz {
    @Autowired
    UserFriendsMapper user_friend;


    @Override
    public JSONObject getUserFriendsByUserId(long user_id, int now_page) {
//        JSONObject list=new JSONObject();
        PageHelper.startPage(now_page, Dto.GLOBAL_PAGE_SIZE);
        Map<Object,Object> par= new HashMap<>();
        par.put("user_id",user_id);
        par.put("id_del",Dto.ALL_FALSE);
        List<UserFriends> list=user_friend.getFriendListByuserId(par);
        PageInfo<UserFriends> pageInfo = new PageInfo<>(list);

        JSONArray arr =JSONArray.fromObject(pageInfo.getList());
        if(arr.size()>0){
            arr= TimeUtil.transTimestamp(arr,"createTime","yyyy-MM-dd HH:mm:ss");
        }
        pageInfo.setList(arr);
        return JSONObject.fromObject(pageInfo);
    }

    @Override
    public JSONObject getUserFriendsById(long ufd_id) {
        UserFriends userFriends=user_friend.selectByPrimaryKey(ufd_id);
        if(userFriends!=null){
            JSONObject obj=JSONObject.fromObject(userFriends);
            return obj;
        }else{
            return new JSONObject();
        }
    }
}
