package xin.zhuyao.wechat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_app.entity.UserMessage;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:46
 * @Version 1.0
 * @Description
 */
public interface UserMessageRepository extends JpaRepository<UserMessage, Integer>, JpaSpecificationExecutor<UserMessage> {

    UserMessage findByOpenId(String openId);

    UserMessage findByAppidAndOpenId(String appid, String openId);

    UserMessage findByUserName(String userName);
}
