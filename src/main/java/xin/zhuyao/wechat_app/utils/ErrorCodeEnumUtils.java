package xin.zhuyao.wechat_app.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author Han.Sun
 * @since 2017年07月28日
 */
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCodeEnumUtils {
    TOKEN_VALID(50008, "非法的token"),
    TOKEN_EXPIRED(50014, "Token 过期了"),

    /**微信小程序从错误码*/
    SESSION_OVERDUE(40008,"用户身份已过期"),
    SESSION_VERIFY(40009,"用户检验失败"),
    SESSION_NOT_EXIST(40010,"SESSION不存在"),
    OPENID_NOT_EXIST(40011,"OPENID不存在"),
    ;

    int code;
    String message;
}
