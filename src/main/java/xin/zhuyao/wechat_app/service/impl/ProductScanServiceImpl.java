package xin.zhuyao.wechat_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zhuyao.wechat_app.entity.ProductSign;
import xin.zhuyao.wechat_app.entity.XiaoGuoUser;
import xin.zhuyao.wechat_app.entitydto.ProductAndUserMessageDto;
import xin.zhuyao.wechat_app.repository.ProductSignRepository;
import xin.zhuyao.wechat_app.repository.XiaoGuoUserRepository;
import xin.zhuyao.wechat_app.service.ProductScanService;

import java.util.Optional;

/**
 * @ClassName ProductScanServiceImpl
 * @Description: TODO
 * author zy
 * @date 2019/4/3 2:13
 **/
@Service
public class ProductScanServiceImpl implements ProductScanService {

    @Autowired
    private ProductSignRepository productSignRepository;
    @Autowired
    private XiaoGuoUserRepository xiaoGuoUserRepository;

    @Override
    public ProductAndUserMessageDto getProductAndUserMessage(String sku) {
        Optional<ProductSign> optionalProductSign = Optional.ofNullable(productSignRepository.findBySku(sku));
        Optional<XiaoGuoUser> optionalXiaoGuoUser = Optional.ofNullable(xiaoGuoUserRepository.findByJobNumber(sku.substring(1,4)));
        ProductAndUserMessageDto productAndUserMessageDto = new ProductAndUserMessageDto();
        productAndUserMessageDto.setSku(sku);
        if (optionalProductSign.isPresent()) {
            productAndUserMessageDto.setProductName(optionalProductSign.get().getProductName());
        }
        if (optionalXiaoGuoUser.isPresent()) {
            productAndUserMessageDto.setUserName(optionalXiaoGuoUser.get().getUserName());
        }
        return productAndUserMessageDto;
    }

}
