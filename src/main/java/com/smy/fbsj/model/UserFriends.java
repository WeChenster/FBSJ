package com.smy.fbsj.model;

import java.util.Date;

public class UserFriends {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.id
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.user_id
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.rec_user
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Long recUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.create_time
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.friend_memo
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private String friendMemo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.top
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Integer top;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.msg_not
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Integer msgNot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.backg
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private String backg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.hide_me
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Integer hideMe;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.hide_her
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Integer hideHer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.is_blacklist
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Integer isBlacklist;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.id_del
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private Integer idDel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_friends.memo
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    private String memo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.id
     *
     * @return the value of user_friends.id
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.id
     *
     * @param id the value for user_friends.id
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.user_id
     *
     * @return the value of user_friends.user_id
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.user_id
     *
     * @param userId the value for user_friends.user_id
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.rec_user
     *
     * @return the value of user_friends.rec_user
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Long getRecUser() {
        return recUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.rec_user
     *
     * @param recUser the value for user_friends.rec_user
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setRecUser(Long recUser) {
        this.recUser = recUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.create_time
     *
     * @return the value of user_friends.create_time
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.create_time
     *
     * @param createTime the value for user_friends.create_time
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.friend_memo
     *
     * @return the value of user_friends.friend_memo
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public String getFriendMemo() {
        return friendMemo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.friend_memo
     *
     * @param friendMemo the value for user_friends.friend_memo
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setFriendMemo(String friendMemo) {
        this.friendMemo = friendMemo == null ? null : friendMemo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.top
     *
     * @return the value of user_friends.top
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Integer getTop() {
        return top;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.top
     *
     * @param top the value for user_friends.top
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.msg_not
     *
     * @return the value of user_friends.msg_not
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Integer getMsgNot() {
        return msgNot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.msg_not
     *
     * @param msgNot the value for user_friends.msg_not
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setMsgNot(Integer msgNot) {
        this.msgNot = msgNot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.backg
     *
     * @return the value of user_friends.backg
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public String getBackg() {
        return backg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.backg
     *
     * @param backg the value for user_friends.backg
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setBackg(String backg) {
        this.backg = backg == null ? null : backg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.hide_me
     *
     * @return the value of user_friends.hide_me
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Integer getHideMe() {
        return hideMe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.hide_me
     *
     * @param hideMe the value for user_friends.hide_me
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setHideMe(Integer hideMe) {
        this.hideMe = hideMe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.hide_her
     *
     * @return the value of user_friends.hide_her
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Integer getHideHer() {
        return hideHer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.hide_her
     *
     * @param hideHer the value for user_friends.hide_her
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setHideHer(Integer hideHer) {
        this.hideHer = hideHer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.is_blacklist
     *
     * @return the value of user_friends.is_blacklist
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Integer getIsBlacklist() {
        return isBlacklist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.is_blacklist
     *
     * @param isBlacklist the value for user_friends.is_blacklist
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setIsBlacklist(Integer isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.id_del
     *
     * @return the value of user_friends.id_del
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public Integer getIdDel() {
        return idDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.id_del
     *
     * @param idDel the value for user_friends.id_del
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setIdDel(Integer idDel) {
        this.idDel = idDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_friends.memo
     *
     * @return the value of user_friends.memo
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_friends.memo
     *
     * @param memo the value for user_friends.memo
     *
     * @mbggenerated Thu Sep 20 17:16:58 CST 2018
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}