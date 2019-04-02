package xin.zhuyao.wechat_app.controller.xiaoguo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.wechat_app.entity.SampleSign;
import xin.zhuyao.wechat_app.entity.UserMessage;
import xin.zhuyao.wechat_app.service.SampleSignService;
import xin.zhuyao.wechat_app.utils.ResponseMessageUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zy
 * @Date: 2019/4/2 16:23
 * @Version 1.0
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = "/xiaoguo")
@Api(value = "小郭小程序接口",description = "样品签收接口")
public class SampleSignController {

    @Autowired
    private SampleSignService sampleSignService;

    @RequestMapping(value = "/getSampleSignAll",method = RequestMethod.GET)
    @ApiOperation(value = "获取某人的样品", notes = "获取某人的样品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uesrName",value = "用户名称",dataType = "String")
    })
    public ResponseMessageUtils<List<SampleSign>> getSampleSignAll(String uesrName) {
        log.info("获取某人的样品---------------getSampleSignAll");
        return ResponseMessageUtils.ok(sampleSignService.findAllByUserName(uesrName));
    }


    @RequestMapping(value = "/getSampleSignByNow",method = RequestMethod.GET)
    @ApiOperation(value = "获取某人未确认的样品", notes = "获取某人未确认的样品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uesrName",value = "用户名称",dataType = "String")
    })
    public ResponseMessageUtils<List<SampleSign>> getSampleSignByNow(String uesrName) {
        log.info("获取某人未确认的样品---------------getSampleSignByNow");
        return ResponseMessageUtils.ok(sampleSignService.findAllByUserNameAndStatus(uesrName, 0));
    }

    @RequestMapping(value = "/submitMessage",method = RequestMethod.GET)
    @ApiOperation(value = "提交确认信息", notes = "提交确认信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "listData",value = "数据",dataType = "String")
    })
    public ResponseMessageUtils submitMessage(String listData) {
        log.info("提交确认信息---------------submitMessage");
        return ResponseMessageUtils.ok(sampleSignService.submitMessage(listData));
    }
}
