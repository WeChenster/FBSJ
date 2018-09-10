package com.smy.fbsj.controller;

import com.smy.fbsj.mapper.BaseUsersMapper;
import com.smy.fbsj.model.BaseUsers;


import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Description: java类作用描述
 * @Author: lwt
 * @CreateDate: 2018/8/30
 * @Version: 1.0
 */

@RestController
public class TestCotroller {
    @Autowired
    BaseUsersMapper base_user;

    @RequestMapping("/hello")
    public String getUser() {
        return "hello word!";
    }


    @RequestMapping("/test")
    public String testData() {
        BaseUsers bu=new BaseUsers();
        bu.setNickName("lwt");
        bu.setUserTel("17759********");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        bu.setCreateTime(Timestamp.valueOf(date));

        bu.setChanAdd(bu.getNickName()+bu.getUserTel()+date);
        bu.setSex(1);
        bu.setImgUrl("xxx/xxxx/xxxx/xxxx");

        int effo= base_user.insert(bu);
        String msg="插入结果为："+effo;
        System.out.print(msg);
        return msg;
    }

    @RequestMapping("/getUsers")
    public String getAllUsers(){
        List<BaseUsers> list= base_user.getAllUsers();
        JSONArray array =JSONArray.fromObject(list);
        return array.toString();
    }


}
