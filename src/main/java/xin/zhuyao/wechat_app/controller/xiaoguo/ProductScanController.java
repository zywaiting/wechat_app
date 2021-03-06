package xin.zhuyao.wechat_app.controller.xiaoguo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.wechat_app.entity.SampleSign;
import xin.zhuyao.wechat_app.entitydto.ProductAndUserMessageDto;
import xin.zhuyao.wechat_app.entityvm.ProductAndUserMessageVm;
import xin.zhuyao.wechat_app.service.ProductScanService;
import xin.zhuyao.wechat_app.service.SampleSignService;
import xin.zhuyao.wechat_app.utils.ResponseMessageUtils;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProductScanController
 * @Description: TODO
 * author zy
 * @date 2019/4/3 2:09
 **/
@Slf4j
@RestController
@RequestMapping(value = "/xiaoguo")
@Api(value = "小郭小程序接口",description = "样品扫描接口")
public class ProductScanController {

    @Autowired
    private ProductScanService productScanService;
    @Autowired
    private SampleSignService sampleSignService;

    @RequestMapping(value = "/getProductAndUserMessage", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品和所属用户", notes = "获取产品和所属用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sku", value = "sku", dataType = "String")
    })
    public ResponseMessageUtils<Object> getProductAndUserMessage(String sku) {
        log.info("获取某人的样品---------------getProductAndUserMessage");
        if (sku.length() > 4) {
            Optional<Object> optional = productScanService.getProductAndUserMessage(sku);
            if (optional.isPresent()) {
                return ResponseMessageUtils.ok(optional.get());
            }
            return ResponseMessageUtils.ok("SKU错误");
        }
        return ResponseMessageUtils.error("SKU错误");
    }

    @RequestMapping(value = "/getSampleSign",method = RequestMethod.GET)
    @ApiOperation(value = "获取未确认的样品", notes = "获取未确认的样品")
    public ResponseMessageUtils<List<SampleSign>> getSampleSign() {
        log.info("获取未确认的样品---------------getSampleSign");
        return ResponseMessageUtils.ok(sampleSignService.findAllByStatus(0));
    }

    @RequestMapping(value = "/saveSampleSign",method = RequestMethod.POST)
    @ApiOperation(value = "保存样品数量", notes = "保存样品数量")
    public ResponseMessageUtils<?> saveSampleSign(@RequestBody ProductAndUserMessageVm productAndUserMessageVm) {
        log.info("保存样品数量---------------getSampleSignByNow");
        String s = sampleSignService.saveSampleSign(productAndUserMessageVm);
        if (s.equals("ok")) {
            return ResponseMessageUtils.ok();
        }else {
            return ResponseMessageUtils.error("有数据为空!");
        }
    }
}
