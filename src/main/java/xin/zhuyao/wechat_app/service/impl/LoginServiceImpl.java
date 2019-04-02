package xin.zhuyao.wechat_app.service.impl;

import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xin.zhuyao.httputil.Utils;
import xin.zhuyao.wechat_app.entity.AppMessage;
import xin.zhuyao.wechat_app.entity.AppUrl;
import xin.zhuyao.wechat_app.entity.UserMessage;
import xin.zhuyao.wechat_app.mapper.UserMessageMapper;
import xin.zhuyao.wechat_app.repository.AppMessageRepository;
import xin.zhuyao.wechat_app.repository.AppUrlRepository;
import xin.zhuyao.wechat_app.repository.UserMessageRepository;
import xin.zhuyao.wechat_app.service.LoginService;
import xin.zhuyao.wechat_app.utils.WechatLoginUtils;
import xin.zhuyao.wechat_app.utils.entity.WechatLoginResult;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:19
 * @Version 1.0
 * @Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AppUrlRepository appUrlRepository;
    @Autowired
    private AppMessageRepository appMessageRepository;
    @Autowired
    private UserMessageRepository userMessageRepository;
    @Autowired
    private UserMessageMapper userMessageMapper;

    @Override
    public String onLogin(String code, String express, String appUrlName, String userInfo) {
        AppMessage appMessage = appMessageRepository.findByExpress(express);
        AppUrl appUrl = appUrlRepository.findByName(appUrlName);
        WechatLoginResult loginResult = WechatLoginUtils.login(code, appMessage.getAppId(), appMessage.getAppSecret(), appUrl.getUrl());

        UserMessage userMessage = new UserMessage();
        if (!StringUtils.isEmpty(userInfo) && userInfo.length() > 0) {
            userMessage = Utils.json(userInfo, UserMessage.class);
        }
        if (loginResult != null && !StringUtils.isEmpty(loginResult.getOpenid())) {
            userMessage.setAppid(appMessage.getAppId());
            userMessage.setOpenId(loginResult.getOpenid());
            userMessage.setUnionId(loginResult.getUnionid());
            Optional<UserMessage> optionalUserMessage = Optional.ofNullable(userMessageRepository.findByOpenId(userMessage.getOpenId()));
            if (optionalUserMessage.isPresent()) {
                userMessageMapper.updateUserConfigByOpenId(userMessage);
                return loginResult.getOpenid();
            }
            userMessage.setCreateDate(LocalDateTime.now());
            userMessage.setUpdateDate(LocalDateTime.now());
            userMessageRepository.save(userMessage);
            return loginResult.getOpenid();
        }
        return "未获取到";
    }
}
