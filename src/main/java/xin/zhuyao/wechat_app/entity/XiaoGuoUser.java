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
 * @Date: 2019/4/2 18:16
 * @Version 1.0
 * @Description
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_xiao_guo_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class XiaoGuoUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @ApiModelProperty(value = "用户名称", dataType = "String")
    String userName;

    @ApiModelProperty(value = "工号", dataType = "String")
    String jobNumber;

    @ApiModelProperty(value = "用户邮箱", dataType = "String")
    String email;

    @ApiModelProperty(value = "创建时间", dataType = "LocalDateTime")
    LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间", dataType = "LocalDateTime")
    LocalDateTime updateDate;
}
