package xin.zhuyao.wechat_app.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: zy
 * @Date: 2019/4/2 16:12
 * @Version 1.0
 * @Description
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_sample_sign")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SampleSign implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @ApiModelProperty(value = "SKU", dataType = "String")
    String sku;

    @ApiModelProperty(value = "产品名称", dataType = "String")
    String productName;

    @ApiModelProperty(value = "所属用户", dataType = "String")
    String userName;

    @ApiModelProperty(value = "appid", dataType = "String")
    Integer productNum;

    @ApiModelProperty(value = "创建时间", dataType = "LocalDateTime")
    LocalDateTime createDate;

    @ApiModelProperty(value = "查询时间", dataType = "String")
    String selectDate;

    @ApiModelProperty(value = "修改时间", dataType = "LocalDateTime")
    LocalDateTime updateDate;

    @ApiModelProperty(value = "是否确认，0未确认，1确认", dataType = "LocalDateTime")
    Integer status;
}
