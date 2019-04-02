package xin.zhuyao.wechat_app.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:12
 * @Version 1.0
 * @Description
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_app_message")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppMessage implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @ApiModelProperty(value = "appid", dataType = "String")
    String appId;

    @ApiModelProperty(value = "app_secret", dataType = "String")
    String appSecret;

    @ApiModelProperty(value = "备注", dataType = "String")
    String reamke;

    @ApiModelProperty(value = "所属小程序", dataType = "String")
    String express;

    @ApiModelProperty(value = "邮箱", dataType = "String")
    String email;

    @ApiModelProperty(value = "创建时间", dataType = "LocalDateTime")
    LocalDateTime createDate;
}
