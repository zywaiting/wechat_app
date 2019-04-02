package xin.zhuyao.wechat_app.controller.xiaoguo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.wechat_app.entity.UserMessage;
import xin.zhuyao.wechat_app.service.UserMessageService;
import xin.zhuyao.wechat_app.utils.ResponseMessageUtils;

import java.util.Optional;

/**
 * @Author: zy
 * @Date: 2019/4/2 14:07
 * @Version 1.0
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = "/xiaoguo")
public class UserMessagerController {

    @Autowired
    private UserMessageService userMessageService;

    /**
     * 获取用户信息
     * @param appid
     * @param openId
     * @return
     */
    @RequestMapping(value = "/getUserMessage",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appid",value = "小程序id",dataType = "String"),
            @ApiImplicitParam(name = "openId",value = "用户id",dataType = "String"),
    })
    public ResponseMessageUtils getUserMessage(String appid, String openId) {
        log.info("获取用户信息---------------getUserMessage");
        Optional<UserMessage> optionalUserMessage = userMessageService.findByAppidAndOpenId(appid, openId);
        if (optionalUserMessage.isPresent()) {
            return ResponseMessageUtils.ok(optionalUserMessage.get());
        }
        return ResponseMessageUtils.ok(new UserMessage());
    }


    @RequestMapping(value = "/updateUserName",method = RequestMethod.GET)
    @ApiOperation(value = "更新用户名称", notes = "更新用户名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名称",dataType = "String"),
            @ApiImplicitParam(name = "openId",value = "用户id",dataType = "String")
    })
    public ResponseMessageUtils updateUserName(String userName, String openId) {
        log.info("更新用户名称---------------updateUserName");
        Boolean aBoolean = userMessageService.updateUserName(userName, openId);
        if (aBoolean) {
            return ResponseMessageUtils.ok();
        }
        return ResponseMessageUtils.error("错误");
    }
}
