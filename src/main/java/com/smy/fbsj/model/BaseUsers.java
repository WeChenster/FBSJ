package com.smy.fbsj.model;

import java.util.Date;

public class BaseUsers {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.id
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.img_url
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private String imgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.nick_name
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.user_tel
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private String userTel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.sex
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.create_time
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.memo
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private String memo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_users.chan_add
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    private String chanAdd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.id
     *
     * @return the value of base_users.id
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.id
     *
     * @param id the value for base_users.id
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.img_url
     *
     * @return the value of base_users.img_url
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.img_url
     *
     * @param imgUrl the value for base_users.img_url
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.nick_name
     *
     * @return the value of base_users.nick_name
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.nick_name
     *
     * @param nickName the value for base_users.nick_name
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.user_tel
     *
     * @return the value of base_users.user_tel
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.user_tel
     *
     * @param userTel the value for base_users.user_tel
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.sex
     *
     * @return the value of base_users.sex
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.sex
     *
     * @param sex the value for base_users.sex
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.create_time
     *
     * @return the value of base_users.create_time
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.create_time
     *
     * @param createTime the value for base_users.create_time
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.memo
     *
     * @return the value of base_users.memo
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.memo
     *
     * @param memo the value for base_users.memo
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_users.chan_add
     *
     * @return the value of base_users.chan_add
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public String getChanAdd() {
        return chanAdd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_users.chan_add
     *
     * @param chanAdd the value for base_users.chan_add
     *
     * @mbggenerated Thu Aug 30 17:05:47 CST 2018
     */
    public void setChanAdd(String chanAdd) {
        this.chanAdd = chanAdd == null ? null : chanAdd.trim();
    }
}