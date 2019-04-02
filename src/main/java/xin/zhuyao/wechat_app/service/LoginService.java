package xin.zhuyao.wechat_app.service;

/**
 * @Author: zy
 * @Date: 2019/4/2 11:44
 * @Version 1.0
 * @Description
 */
public interface LoginService {

    //用户登录（适用于所有的小程序）
    String onLogin(String code, String express, String appUrlName, String userInfo);
}
