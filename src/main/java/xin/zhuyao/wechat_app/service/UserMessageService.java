package xin.zhuyao.wechat_app.service;

import xin.zhuyao.wechat_app.entity.UserMessage;

import java.util.Optional;

/**
 * @Author: zy
 * @Date: 2019/4/2 14:18
 * @Version 1.0
 * @Description
 */
public interface UserMessageService {

    //获取用户信息
    Optional<UserMessage> findByAppidAndOpenId(String appid, String openId);

    Boolean updateUserName(String userName, String openId);
}
