package com.smy.fbsj.service.friendscircle;

import com.smy.fbsj.model.UserComments;
import com.smy.fbsj.model.UserDyn_msg;

import net.sf.json.JSONObject;

/**
 * @Description: 好友圈业务接口
 * @Author: lwt
 * @CreateDate: 2018/9/10
 * @Version: 1.0
 */
public interface UserFriendsCircleBiz {

    /**
     * @Description:  发布动态
     * @Pramers:      userDynMsg
     * @return:       返回类型
     */
    public Long insertUserDynamicMessage(UserDyn_msg userDynMsg);

    /**
      * @Description:  获取用户的动态列表
      * @Pramers:      in   {"user_id":"xxx","now_page":1,"size":10}
      * @return:       返回类型
     */
    public JSONObject getMyDynamicMessage(long user_id,Integer now_page);


    /**
      * @Description:  转发动态
      * @Pramers:      userDynMsg
      * @return:       返回类型
     */
    public boolean forwardUserDynamicMessage(UserDyn_msg userDynMsg);

    /**
      * @Description:  点赞动态
      * @Pramers:      传入参数
      * @return:       返回类型
     */
    public boolean praiseUserDynamicMessage(UserComments userComments);

    /**
      * @Description:  评论动态
      * @Pramers:      userComments
      * @return:       返回类型
     */
    public boolean commentUserDynamicMessage(UserComments userComments);

    /**
      * @Description:  删除动态
      * @Pramers:      udmsg_id   消息ID
      * @return:       返回类型
     */
    public boolean deleteUserDynamicMessage(long udmsg_id);


    /**
      * @Description:  添加评论，点赞
      * @Pramers:      userComments
      * @return:       返回类型
     */
    public boolean insertCommentUserDynamicMessage(UserComments userComments);

}
