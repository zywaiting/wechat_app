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
 * @ClassName ProductSign
 * @Description: TODO
 * author zy
 * @date 2019/4/3 2:19
 **/
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_product_sign")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductSign implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @ApiModelProperty(value = "sku", dataType = "String")
    String sku;

    @ApiModelProperty(value = "产品名称", dataType = "String")
    String productName;

    @ApiModelProperty(value = "创建时间", dataType = "LocalDateTime")
    LocalDateTime createDate;

    @ApiModelProperty(value = "修改时间", dataType = "LocalDateTime")
    LocalDateTime updateDate;

}
