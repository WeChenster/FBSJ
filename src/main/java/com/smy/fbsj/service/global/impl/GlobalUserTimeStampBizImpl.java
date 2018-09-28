package com.smy.fbsj.service.global.impl;
/**
 * @Description: 用户时间轴表
 * @Author: lwt
 * @CreateDate: 2018/9/11
 * @Version: 1.0
 */

import com.github.pagehelper.PageHelper;
import com.smy.fbsj.mapper.UserTimeStampMapper;
import com.smy.fbsj.model.UserTimeStamp;
import com.smy.fbsj.service.PageInfo;
import com.smy.fbsj.service.global.GlobalUserTimeStampBiz;
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
public class GlobalUserTimeStampBizImpl implements GlobalUserTimeStampBiz {
    @Autowired
    UserTimeStampMapper userTimeStampMapper;

    @Override
    public Long insertLine(UserTimeStamp userTimeStamp) {
        int effo=userTimeStampMapper.insert(userTimeStamp);
        if(effo>0){
            Long id=userTimeStamp.getId();
            return id;
        }else{
            return null;
        }
    }

    @Override
    public JSONObject getUserTimeStampListByUserId(long user_id, int now_page) {
        PageHelper.startPage(now_page,Dto.GLOBAL_PAGE_SIZE);

        Map<Object,Object> par =new HashMap<>();
        par.put("user_id",user_id);
        par.put("id_del",Dto.ALL_FALSE);
        List<UserTimeStamp> list=userTimeStampMapper.selectByUserId(par);

        PageInfo<UserTimeStamp> pageInfo=new PageInfo<>(list);

        JSONArray array=JSONArray.fromObject(pageInfo.getList());
        if(array.size()>0){
            pageInfo.setList(TimeUtil.transTimestamp(array,"createTime","yyyy-MM-dd HH:mm:ss"));
        }
        return JSONObject.fromObject(pageInfo);
    }

    @Override
    public boolean deleteByMsgId(long udmsg_id) {
        Map<Object,Object> par =new HashMap<>();
        par.put("id_del",Dto.ALL_TRUE);
        par.put("udmsg_id",udmsg_id);
        int effo=userTimeStampMapper.updateIdDelByMsgId(par);
        if(effo>0)
            return true;
        else
            return false;
    }
}
