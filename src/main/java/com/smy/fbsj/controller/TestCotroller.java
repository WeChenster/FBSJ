package com.smy.fbsj.controller;


import com.smy.fbsj.mapper.BaseUsersMapper;
import com.smy.fbsj.model.BaseUsers;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping(value = "/test")
public class TestCotroller {
    @Autowired
    BaseUsersMapper base_user;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getUser() {
        return "hello word!";
    }


    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String testData(@RequestParam("username") String username,
                @RequestParam("nickname") String nickname,
                @RequestParam("img") String img,
        @RequestParam(value = "sex",required = false,defaultValue = "0") int sex) {
            BaseUsers bu=new BaseUsers();


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        bu.setCreateTime(Timestamp.valueOf(date));

        bu.setChanAdd(username+nickname+date);


        int effo= base_user.insert(bu);
        String msg="插入结果为："+effo;
        System.out.print(msg);
        return msg;
    }

//    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
//    public String getAllUsers(){
//        List<BaseUsers> list= base_user.getAllUsers();
//        JSONArray array =JSONArray.fromObject(list);
//        return array.toString();
//    }


}
