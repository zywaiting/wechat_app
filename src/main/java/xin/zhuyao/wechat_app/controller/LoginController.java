package xin.zhuyao.wechat_app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.wechat_app.service.LoginService;
import xin.zhuyao.wechat_app.utils.ResponseMessageUtils;

/**
 * 微信用户登录
 */
@RestController
@Slf4j
@Api(value = "小程序接口登陆总接口",description = "所有小程序都从这地方登陆")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户拥有登录
     * @param code
     * @param express
     * @param appUrlName
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "onLogin",method = RequestMethod.GET)
    @ApiOperation(value = "用户拥有登录", notes = "用户拥有登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "code",dataType = "String"),
            @ApiImplicitParam(name = "express",value = "小程序标志",dataType = "String"),
            @ApiImplicitParam(name = "appUrlName",value = "请求路径",dataType = "String"),
            @ApiImplicitParam(name = "userInfo",value = "用户信息",dataType = "String")
    })
    public ResponseMessageUtils<String> onLoginAll(String code, String express, String appUrlName, String userInfo) {
        log.info("调用了用户登录接口---------------onLoginAll");
        String openId = loginService.onLogin(code, express, appUrlName, userInfo);
        return ResponseMessageUtils.ok(openId);
    }
}
