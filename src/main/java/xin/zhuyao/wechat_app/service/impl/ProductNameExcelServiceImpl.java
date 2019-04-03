package xin.zhuyao.wechat_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xin.zhuyao.wechat_app.entity.ProductSign;
import xin.zhuyao.wechat_app.repository.ProductSignRepository;
import xin.zhuyao.wechat_app.service.ProductNameExcelService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zy
 * @Date: 2019/4/3 13:08
 * @Version 1.0
 * @Description
 */
@Service
public class ProductNameExcelServiceImpl implements ProductNameExcelService {

    @Autowired
    private ProductSignRepository productSignRepository;

    @Override
    public String saveAll(List<Object> datas) {
        if (datas.size() > 1) {
            List<ProductSign> productSignList = new ArrayList<>();
            for (int i = 1; i < datas.size(); i++) {
                String[] split = datas.get(i).toString().replace("[", "").replace("]", "").split(",");
                if (split.length == 2 && !StringUtils.isEmpty(split[0].trim()) && !StringUtils.isEmpty(split[1].trim())
                        && !"null".equals(split[0].trim()) && !"null".equals(split[1].trim())
                        GIT&& productSignList.stream().noneMatch(productSign -> productSign.getSku().toUpperCase().equals(split[0].trim().toUpperCase()))) {
                    ProductSign productSign = new ProductSign();
                    productSign.setSku(split[0].trim());
                    productSign.setProductName(split[1].trim());
                    productSign.setCreateDate(LocalDateTime.now());
                    productSign.setUpdateDate(LocalDateTime.now());
                    productSignList.add(productSign);
                }
            }
            List<ProductSign> productSignListAll = productSignRepository.findAll();
            List<String> skuList = productSignListAll.stream().map(ProductSign::getSku).collect(Collectors.toList());
            List<ProductSign> productSignListSave = productSignList.stream().filter(productSign -> !skuList.contains(productSign.getSku())).collect(Collectors.toList());
            productSignRepository.saveAll(productSignListSave);
        }
        return "ok";
    }
}
