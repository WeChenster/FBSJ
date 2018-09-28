package com.smy.fbsj.service.global.impl;
/**
 * @Description: 评论表
 * @Author: lwt
 * @CreateDate: 2018/9/12
 * @Version: 1.0
 */

import com.smy.fbsj.mapper.UserCommentsMapper;
import com.smy.fbsj.model.UserComments;
import com.smy.fbsj.service.global.GlobalUserCommentsBiz;
import com.zhuoan.dto.Dto;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Primary
@Transactional
public class GlobalUserCommentsBizImpl implements GlobalUserCommentsBiz {
    @Autowired
    UserCommentsMapper user_comment;

    @Override
    public boolean deleteById(long uc_id) {
        UserComments userComments=new UserComments();
        userComments.setId(uc_id);
        userComments.setIdDel(Dto.ALL_TRUE);//逻辑删除
        int effo=user_comment.updateByPrimaryKeySelective(userComments);
        if(effo>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteByMsgId(long udmsg_id) {
        Map<Object,Object> par =new HashMap<>();
        par.put("id_del",Dto.ALL_TRUE);
        par.put("msg_id",udmsg_id);
        int effo=user_comment.updateByMsgIdSetIdDel(par);
        if(effo>0)
            return true;
        else
            return false;
    }

    @Override
    public Long insertLines(UserComments userComments) {
        int effo= user_comment.insert(userComments);
        Long id=userComments.getId();
        if(id!=null){
            return id;
        }else{
            return null;
        }
    }

    @Override
    public JSONObject isPraise(long msg_id, long user_id, int type){
        Map<Object,Object> par=new HashMap<>();
        par.put("msg_id",msg_id);
        par.put("user_id",user_id);
        par.put("type",type);
        par.put("id_del",Dto.ALL_FALSE);

        UserComments ua=user_comment.selectByWhereValue(par);
        return JSONObject.fromObject(ua);
    }
}
