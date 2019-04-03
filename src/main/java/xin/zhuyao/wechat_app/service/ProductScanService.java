package xin.zhuyao.wechat_app.service;


import java.util.Optional;

public interface ProductScanService {

    Optional<Object> getProductAndUserMessage(String sku);
}
