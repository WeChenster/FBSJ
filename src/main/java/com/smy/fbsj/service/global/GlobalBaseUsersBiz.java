package com.smy.fbsj.service.global;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Description: 用户表
 * @Author: lwt
 * @CreateDate: 2018/9/6
 * @Version: 1.0
 */
public interface GlobalBaseUsersBiz {

    /**
      * @Description:  通过区块地址用户id 获取用户信息
      * @Pramers:      传入参数
      * @return:       id.chanAdd,createTime,idDel.....
     */
    public JSONObject getUserByIdOrChainAdd(String user_id);

    /**
      * @Description:  获取系统所有用户id
      * @Pramers:      传入参数
      * @return:       id.chanAdd,createTime,idDel.....
     */
    public JSONArray getAllUsers();

}
