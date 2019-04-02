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
 * @Date: 2019/4/2 12:40
 * @Version 1.0
 * @Description
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_user_message")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserMessage implements Serializable {
    /**
     *   `id` int(11) NOT NULL,
     *   `user_name` varchar(100) DEFAULT '' COMMENT '用户名',
     *   `password` varchar(100) DEFAULT NULL COMMENT '密码',
     *   `nick_name` varchar(100) DEFAULT NULL COMMENT '用户昵称',
     *   `avatar_url` varchar(255) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表132*132正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
     *   `gender` varchar(5) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
     *   `city` varchar(20) DEFAULT NULL COMMENT '用户所在城市',
     *   `province` varchar(20) DEFAULT NULL COMMENT '用户所在省份',
     *   `country` varchar(20) DEFAULT NULL COMMENT '用户所在国家',
     *   `language` varchar(20) DEFAULT NULL COMMENT '用户的语言，简体中文为zh_CN',
     *   `mobile` varchar(15) DEFAULT NULL COMMENT '手机号',
     *   `latitude` varchar(15) DEFAULT NULL COMMENT '纬度，浮点数，范围为-90~90，负数表示南纬',
     *   `longitude` varchar(15) DEFAULT NULL COMMENT '经度，浮点数，范围为-180~180，负数表示西经',
     *   `speed` varchar(20) DEFAULT NULL COMMENT '速度，浮点数，单位m/s',
     *   `accuracy` varchar(20) DEFAULT NULL COMMENT '位置的精确度',
     *   `altitude` varchar(20) DEFAULT NULL COMMENT '高度，单位 m',
     *   `verticalAccuracy` varchar(20) DEFAULT NULL COMMENT '垂直精度，单位 m（Android 无法获取，返回 0）',
     *   `horizontalAccuracy` varchar(20) DEFAULT NULL COMMENT '水平精度，单位 m',
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    @ApiModelProperty(value = "名称", dataType = "String")
    String appid;
    @ApiModelProperty(value = "名称", dataType = "String")
    String openId;
    @ApiModelProperty(value = "用户名", dataType = "String")
    String userName;
    @ApiModelProperty(value = "密码", dataType = "String")
    String password;
    @ApiModelProperty(value = "用户昵称", dataType = "String")
    String nickName;
    @ApiModelProperty(value = "用户头像", dataType = "String")
    String avatarUrl;
    @ApiModelProperty(value = "用户的性别,值为1时是男性，值为2时是女性，值为0时是未知'", dataType = "String")
    String gender;
    @ApiModelProperty(value = "用户所在城市", dataType = "String")
    String city;
    @ApiModelProperty(value = "用户所在省份", dataType = "String")
    String province;
    @ApiModelProperty(value = "用户所在国家", dataType = "String")
    String country;
    @ApiModelProperty(value = "用户的语言，简体中文为zh_CN", dataType = "String")
    String language;
    @ApiModelProperty(value = "手机号", dataType = "String")
    String mobile;
    @ApiModelProperty(value = "纬度，浮点数，范围为-90~90，负数表示南纬", dataType = "Double")
    Double latitude;
    @ApiModelProperty(value = "经度，浮点数，范围为-180~180，负数表示西经", dataType = "Double")
    Double longitude;
    @ApiModelProperty(value = "速度，浮点数，单位m/s", dataType = "Double")
    Double speed;
    @ApiModelProperty(value = "位置的精确度", dataType = "String")
    String accuracy;
    @ApiModelProperty(value = "高度，单位 m", dataType = "String")
    String altitude;
    @ApiModelProperty(value = "垂直精度，单位 m", dataType = "String")
    String verticalAccuracy;
    @ApiModelProperty(value = "水平精度，单位 m", dataType = "String")
    String horizontalAccuracy;
    @ApiModelProperty(value = "unionId", dataType = "String")
    String unionId;
    @ApiModelProperty(value = "unionId", dataType = "LocalDateTime")
    LocalDateTime createDate;
    @ApiModelProperty(value = "unionId", dataType = "LocalDateTime")
    LocalDateTime updateDate;
}
