package xin.zhuyao.wechat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_app.entity.AppMessage;
import xin.zhuyao.wechat_app.entity.XiaoGuoUser;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:18
 * @Version 1.0
 * @Description
 */
public interface XiaoGuoUserRepository extends JpaRepository<XiaoGuoUser, Integer>, JpaSpecificationExecutor<XiaoGuoUser> {

    XiaoGuoUser findByUserName(String userName);

    XiaoGuoUser findByJobNumber(String substring);
}
