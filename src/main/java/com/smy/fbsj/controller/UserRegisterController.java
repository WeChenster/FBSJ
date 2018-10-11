package com.smy.fbsj.controller;

import com.smy.fbsj.model.BaseUsers;
import com.smy.fbsj.service.useroperate.UserRegisterBiz;
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
 * @Description: 用户同步
 * @Author: lwt
 * @CreateDate: 2018/9/18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/socialmode")
public class UserRegisterController {

    @Autowired
    UserRegisterBiz user_register;
    /**
      * @Description:  实现socialmode向外提供注册用户
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUser(@RequestParam("chain_add") String chain_add,
                               @RequestParam(value = "memo",defaultValue = "") String memo) throws IOException {

        JSONObject obj=new JSONObject();
        if(chain_add!=null&&!chain_add.equals("")){
            BaseUsers baseUsers=new BaseUsers();
            baseUsers.setChanAdd(chain_add);
            baseUsers.setCreateTime(DateUtils.gettimestamp());
            baseUsers.setIdDel(Dto.ALL_FALSE);
            baseUsers.setMemo(memo!=null?memo:"");
            Long effo=user_register.addUserForRegister(baseUsers);
            if(effo!=null){
                obj.put("code", Dto.ALL_TRUE);
                obj.put("msg", "同步成功");
            }else{
                obj.put("code", Dto.ALL_FALSE);
                obj.put("msg", "同步失败");
            }
        }else{
            obj.put("code", Dto.ALL_FALSE);
            obj.put("msg", "用户区块不能为空");
        }
        return obj.toString();
    }
}
