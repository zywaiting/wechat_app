package xin.zhuyao.wechat_app.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:08
 * @Version 1.0
 * @Description
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_app_url")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUrl implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @ApiModelProperty(value = "名称", dataType = "String")
    String name;

    @ApiModelProperty(value = "路径", dataType = "String")
    String url;

    @ApiModelProperty(value = "备注", dataType = "String")
    String remake;

}
