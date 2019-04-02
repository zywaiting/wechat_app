package xin.zhuyao.wechat_app.utils;

import io.swagger.annotations.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author zy
 * @since 2019年04月02日
 */
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "响应结果")
public class ResponseMessageUtils<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否成功", dataType = "boolean")
    boolean success;

    @ApiModelProperty(value = "返回信息", dataType = "String")
    String message;

    @ApiModelProperty(value = "返回数据", dataType = "T")
    T data;

    @ApiModelProperty(value = "状态码", dataType = "int")
    int code;

    @ApiModelProperty(value = "时间戳", dataType = "Long")
    Long timestamp;


    /**
     * 失败
     */
    public static <T> ResponseMessageUtils<T> error(String message) {
        return error(message, 500, null);
    }

    public static <T> ResponseMessageUtils<T> error(T data) {
        return error(null, 500, data);
    }

    public static <T> ResponseMessageUtils<T> error(String message, int code) {
        return error(message, code, null);
    }

    public static <T> ResponseMessageUtils<T> error(ErrorCodeEnumUtils codeEnum) {
        return error(codeEnum.getMessage(),codeEnum.getCode());
    }

    public static <T> ResponseMessageUtils<T> error(String message, int code, T data) {
        return new ResponseMessageUtils<T>()
                .message(message)
                .code(code)
                .data(data)
                .success(false)
                .timeStamp();
    }

    /**
     * 成功
     */
    public static <T> ResponseMessageUtils<T> ok() {
        return ok(null);
    }

    public static <T> ResponseMessageUtils<T> ok(T data) {
        return ok(data,"请求成功");
    }

    public static <T> ResponseMessageUtils<T> ok(T data,String message) {
        return new ResponseMessageUtils<T>()
                .data(data)
                .message(message)
                .success(true)
                .timeStamp()
                .code(200);
    }



    public ResponseMessageUtils<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResponseMessageUtils<T> success(boolean success) {
        this.success = success;
        return this;
    }

    private ResponseMessageUtils<T> timeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public ResponseMessageUtils<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResponseMessageUtils<T> message(String message) {
        this.message = message;
        return this;
    }
}
