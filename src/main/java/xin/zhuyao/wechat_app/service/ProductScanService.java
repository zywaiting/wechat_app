package xin.zhuyao.wechat_app.service;

import xin.zhuyao.wechat_app.entitydto.ProductAndUserMessageDto;

public interface ProductScanService {

    ProductAndUserMessageDto getProductAndUserMessage(String sku);
}
