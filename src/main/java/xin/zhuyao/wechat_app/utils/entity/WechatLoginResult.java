package xin.zhuyao.wechat_app.utils.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:35
 * @Version 1.0
 * @Description
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WechatLoginResult implements Serializable {
    /**
     * //满足UnionID返回条件时，返回的JSON数据包
     * {
     *     "openid": "OPENID",
     *     "session_key": "SESSIONKEY",
     *     "unionid": "UNIONID"
     * }
     * //错误时返回JSON数据包(示例为Code无效)
     * {
     * 	"errcode": 40029,
     * 	"errmsg": "invalid code"
     * }
     */
    String openid;
    @JsonProperty(value = "session_key")
    String sessionKey;
    String unionid;
    String errcode;
    String errmsg;
}
