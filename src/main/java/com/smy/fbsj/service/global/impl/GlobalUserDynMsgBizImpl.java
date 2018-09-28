package com.smy.fbsj.service.global.impl;
/**
 * @Description: 朋友圈动态消息表
 * @Author: lwt
 * @CreateDate: 2018/9/11
 * @Version: 1.0
 */

import com.smy.fbsj.mapper.UserDyn_msgMapper;
import com.smy.fbsj.model.UserDyn_msg;
import com.smy.fbsj.service.global.GlobalUserDynMsgBiz;
import com.zhuoan.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


/**
 *@auther:Administrator
 *@Date:2018/9/11
 *@descriotion:
 */
@Service
@Primary
@Transactional
public class GlobalUserDynMsgBizImpl implements GlobalUserDynMsgBiz {
    @Autowired
    UserDyn_msgMapper userDynMsgMapper;

    @Override
    public Long insertUserDynMsg(UserDyn_msg userDynMsg) {
        int effo=userDynMsgMapper.insert(userDynMsg);
        if(effo>0){
            Long id=userDynMsg.getId();
            if(id!=null){
                return id;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public UserDyn_msg getUserDynMsgById(Long msg_id) {
        return userDynMsgMapper.selectByPrimaryKey(msg_id);
    }

    @Override
    public boolean updateColumnValue(String column_value, long udmsg_id) {
        Map<Object,Object> par=new HashMap<>();
        par.put("column_value",column_value);
        par.put("id",udmsg_id);
        int effo=userDynMsgMapper.updateBySetColunmValue(par);
        if(effo>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteLineById(long msg_id) {
        Map<Object,Object> par=new HashMap<>();
        par.put("column_value","id_del="+Dto.ALL_TRUE);
        par.put("id",msg_id);
        int effo=userDynMsgMapper.updateBySetColunmValue(par);
        if(effo>0)
            return true;
        else
            return false;
    }
}
