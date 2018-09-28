package com.smy.fbsj.controller;


import com.smy.fbsj.mapper.BaseUsersMapper;
import com.smy.fbsj.model.BaseUsers;
import com.smy.fbsj.model.UserFriends;
import com.smy.fbsj.service.PageInfo;
import com.smy.fbsj.service.global.GlobalBaseUsersBiz;
import com.smy.fbsj.service.global.GlobalUserFriendsBiz;
import com.smy.fbsj.service.useroperate.UserRegisterBiz;
import com.smy.fbsj.service.useroperate.impl.UserRegisterBizImpl;
import com.zhuoan.dto.Dto;
import com.zhuoan.util.DateUtils;
import com.zhuoan.util.ResultDataUtil;
import com.zhuoan.util.ResultUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
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

    @Autowired
    UserRegisterBiz user_register;

    @Autowired
    GlobalBaseUsersBiz base_userBiz;

    @Autowired
    GlobalUserFriendsBiz user_friendBiz;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getUser() {
        return "hello word!";
    }


    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    public String testData(@RequestParam("chain_add") String chain_add) {
        BaseUsers bu=new BaseUsers();
        bu.setChanAdd(chain_add);
        bu.setCreateTime(DateUtils.gettimestamp());
        bu.setIdDel(Dto.ALL_FALSE);
        bu.setMemo("mybatis插入");
        Long userId= user_register.addUserForRegister(bu);
        return "插入ID为："+userId.toString();
    }

    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public String getAllUsers(){
        JSONArray array =base_userBiz.getAllUsers();
        Object obj=new ResultDataUtil<JSONArray>(2,1,1,array);
        JSONObject os=JSONObject.fromObject(new ResultUtil<Object>(1,"获取成功",obj));
        Dto.writeLog("访问/test/getUsers的结果为："+os.toString());
        return os.toString();
    }

    @RequestMapping(value = "/getUserBy",method = RequestMethod.POST)
    public String testGetUser(@RequestParam("usertag") String usertag) {
        JSONObject obj=base_userBiz.getUserByIdOrChainAdd(usertag);
        JSONObject jbo=JSONObject.fromObject(ResultUtil.success(obj));
        return jbo.toString();
    }

    //获取该用户的好友
    @RequestMapping(value = "/getUserFriends",method = RequestMethod.POST)
    public String getUserFriends(@RequestParam("user_id") String user_id,
                                 @RequestParam(value = "now_page",defaultValue = "1") String now_page ) {

        JSONObject list=user_friendBiz.getUserFriendsByUserId(Long.valueOf(user_id),Integer.valueOf(now_page));
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
//        PageInfo<UserFriends> pageInfo = new PageInfo<>(list);
        return list.toString();
    }


}
