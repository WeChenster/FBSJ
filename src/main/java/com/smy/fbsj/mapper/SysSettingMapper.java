package com.smy.fbsj.mapper;

import com.smy.fbsj.model.SysSetting;

public interface SysSettingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int insert(SysSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int insertSelective(SysSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    SysSetting selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int updateByPrimaryKeySelective(SysSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    int updateByPrimaryKey(SysSetting record);
}