package xin.zhuyao.wechat_app.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import xin.zhuyao.httputil.HttpUtils;
import xin.zhuyao.wechat_app.utils.entity.WechatLoginResult;

import java.util.HashMap;

/**
 * 微信登录功能
 * https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
 */
@Data
public class WechatLoginUtils {

    public static WechatLoginResult login(String code, String appId, String appSecret, String url) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("appid",appId);
        hashMap.put("secret",appSecret);
        hashMap.put("js_code",code);
        hashMap.put("grant_type","authorization_code");
        String resultStr = HttpUtils.get(url, hashMap);
        WechatLoginResult wechatLoginResult = JSONObject.parseObject(resultStr, WechatLoginResult.class);
        return wechatLoginResult;
    }
}
