package xin.zhuyao.wechat_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zhuyao.wechat_app.entity.UserMessage;
import xin.zhuyao.wechat_app.entity.XiaoGuoUser;
import xin.zhuyao.wechat_app.repository.UserMessageRepository;
import xin.zhuyao.wechat_app.repository.XiaoGuoUserRepository;
import xin.zhuyao.wechat_app.service.UserMessageService;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @Author: zy
 * @Date: 2019/4/2 14:18
 * @Version 1.0
 * @Description
 */
@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Autowired
    private UserMessageRepository userMessageRepository;
    @Autowired
    private XiaoGuoUserRepository xiaoGuoUserRepository;

    @Override
    public Optional<UserMessage> findByAppidAndOpenId(String appid, String openId) {
        return Optional.ofNullable(userMessageRepository.findByAppidAndOpenId(appid,openId));
    }

    @Override
    public Boolean updateUserName(String userName, String openId) {
        Optional<XiaoGuoUser> optionalXiaoGuoUser = Optional.ofNullable(xiaoGuoUserRepository.findByUserName(userName));
        if (!optionalXiaoGuoUser.isPresent()) {
            return false;
        }
        Optional<UserMessage> optionalUserMessage = Optional.ofNullable(userMessageRepository.findByUserName(userName));
        if (optionalUserMessage.isPresent()) {
            return false;
        }
        Optional<UserMessage> byOpenId = Optional.ofNullable(userMessageRepository.findByOpenId(openId));
        if (byOpenId.isPresent()) {
            UserMessage userMessage = byOpenId.get();
            userMessage.setUserName(userName);
            userMessage.setUpdateDate(LocalDateTime.now());
            userMessageRepository.save(userMessage);
            return true;
        }
        return false;
    }
}
