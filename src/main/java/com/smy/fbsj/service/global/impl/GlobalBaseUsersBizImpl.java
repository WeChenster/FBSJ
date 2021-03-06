package com.smy.fbsj.service.global.impl;


import com.smy.fbsj.mapper.BaseUsersMapper;
import com.smy.fbsj.model.BaseUsers;
import com.smy.fbsj.service.global.GlobalBaseUsersBiz;
import com.zhuoan.dto.Dto;

import com.zhuoan.util.CheckTypeUtil;
import com.zhuoan.util.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 用户表
 * @Author: lwt
 * @CreateDate: 2018/9/6
 * @Version: 1.0
 */
@Service
@Primary
@Transactional
public class GlobalBaseUsersBizImpl implements GlobalBaseUsersBiz {
    @Autowired
    BaseUsersMapper baer_user;

    @Override
    public JSONObject getUserByIdOrChainAdd(String user_id) {
        JSONObject bu=new JSONObject();
        Map<Object,Object> hp=new HashMap<Object,Object>();
        if(CheckTypeUtil.isNumber(user_id)){
            hp.put("id",user_id);
            hp.put("id_del",Dto.ALL_FALSE);
            bu=JSONObject.fromObject(baer_user.getUserById(hp));
        }else{
            hp.put("chan_add",user_id);
            hp.put("id_del",Dto.ALL_FALSE);
            bu=JSONObject.fromObject(baer_user.getUserById(hp));
        }
        if(!bu.isNullObject() && !bu.getString("id").equals("null")){
            return TimeUtil.transTimeStamp(JSONObject.fromObject(bu),"yyyy-MM-dd HH:mm:ss","createTime");
        }else{
            return null;
        }
    }

    @Override
    public JSONArray getAllUsers() {
        JSONArray array =JSONArray.fromObject(baer_user.getAllUsers(Dto.ALL_FALSE));
        if(array.size()>0){
            array= TimeUtil.transTimestamp(array,"createTime","yyyy-MM-dd HH:mm:ss");
        }
        return array;
    }
}
