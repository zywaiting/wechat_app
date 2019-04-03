package xin.zhuyao.wechat_app.controller.xiaoguo;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xin.zhuyao.wechat_app.service.ProductNameExcelService;
import xin.zhuyao.wechat_app.utils.ExcelListenerUtils;
import xin.zhuyao.wechat_app.utils.ResponseMessageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: zy
 * @Date: 2018/12/28 10:54
 * @Description: 产品excel
 */
@Slf4j
@RestController
@RequestMapping(value = "/xiaoguo")
@Api(value = "产品excel", description = "产品excel")
public class ProductNameExcelController {

    @Autowired
    private ProductNameExcelService productNameExcelService;

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST,consumes = "multipart/form-data")
    @ApiOperation(value = "上传Excel解析保存到数据库", notes = "上传Excel解析保存到数据库")
    public ResponseMessageUtils<?> upload(@RequestParam("files") MultipartFile files){

        //单文件
        if (files != null ) {
            try {
                ExcelListenerUtils listener = new ExcelListenerUtils();
                ExcelReader excelReader = new ExcelReader(files.getInputStream(), ExcelTypeEnum.XLSX, listener);
                excelReader.read();
                List<Object> datas = listener.getDatas();
                productNameExcelService.saveAll(datas);
            } catch (Exception e) {
                log.info(e.getMessage());
                return ResponseMessageUtils.error("导入文件异常，请检查文件和文件中数据是否正确");
            }
        }
        return ResponseMessageUtils.ok();
    }
}
