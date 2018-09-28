package com.smy.fbsj.service.useroperate.impl;

import com.smy.fbsj.mapper.BaseUsersMapper;
import com.smy.fbsj.model.BaseUsers;
import com.smy.fbsj.service.useroperate.UserRegisterBiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



/**
 * @Description: java类作用描述
 * @Author: lwt
 * @CreateDate: 2018/9/5
 * @Version: 1.0
 */
@Service
@Primary
public class UserRegisterBizImpl implements UserRegisterBiz {
    @Autowired
    BaseUsersMapper base_user;

    @Override
    public Long addUserForRegister(BaseUsers baseUsers) {
        int obj= base_user.insert(baseUsers);
        return baseUsers.getId();
    }
}
