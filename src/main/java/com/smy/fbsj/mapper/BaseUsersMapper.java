package com.smy.fbsj.mapper;

import com.smy.fbsj.model.BaseUsers;

import java.util.List;

public interface BaseUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_users
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_users
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int insert(BaseUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_users
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int insertSelective(BaseUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_users
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    BaseUsers selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_users
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int updateByPrimaryKeySelective(BaseUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_users
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int updateByPrimaryKey(BaseUsers record);

    List<BaseUsers> getAllUsers();
}