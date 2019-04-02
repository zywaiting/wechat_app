package xin.zhuyao.wechat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_app.entity.AppMessage;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:18
 * @Version 1.0
 * @Description
 */
public interface AppMessageRepository extends JpaRepository<AppMessage, Integer>, JpaSpecificationExecutor<AppMessage> {

    AppMessage findByExpress(String express);
}
