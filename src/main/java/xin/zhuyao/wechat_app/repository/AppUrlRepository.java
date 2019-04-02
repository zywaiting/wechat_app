package xin.zhuyao.wechat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_app.entity.AppUrl;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:17
 * @Version 1.0
 * @Description
 */
public interface AppUrlRepository extends JpaRepository<AppUrl, Integer>, JpaSpecificationExecutor<AppUrl> {

    AppUrl findByName(String appUrlName);
}
