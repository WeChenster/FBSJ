package com.smy.fbsj.mapper;

import com.smy.fbsj.model.UserDyn_msg;

public interface UserDyn_msgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_dyn_msg
     *
     * @mbggenerated Mon Sep 10 17:45:46 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_dyn_msg
     *
     * @mbggenerated Mon Sep 10 17:45:46 CST 2018
     */
    int insert(UserDyn_msg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_dyn_msg
     *
     * @mbggenerated Mon Sep 10 17:45:46 CST 2018
     */
    int insertSelective(UserDyn_msg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_dyn_msg
     *
     * @mbggenerated Mon Sep 10 17:45:46 CST 2018
     */
    UserDyn_msg selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_dyn_msg
     *
     * @mbggenerated Mon Sep 10 17:45:46 CST 2018
     */
    int updateByPrimaryKeySelective(UserDyn_msg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_dyn_msg
     *
     * @mbggenerated Mon Sep 10 17:45:46 CST 2018
     */
    int updateByPrimaryKey(UserDyn_msg record);
}