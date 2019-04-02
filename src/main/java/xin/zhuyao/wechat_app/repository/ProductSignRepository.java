package xin.zhuyao.wechat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_app.entity.ProductSign;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:18
 * @Version 1.0
 * @Description
 */
public interface ProductSignRepository extends JpaRepository<ProductSign, Integer>, JpaSpecificationExecutor<ProductSign> {

    ProductSign findBySku(String sku);
}
