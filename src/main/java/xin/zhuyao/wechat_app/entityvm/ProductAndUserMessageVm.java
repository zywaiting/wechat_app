package xin.zhuyao.wechat_app.entityvm;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @ClassName ProductAndUserMessageDto
 * @Description: TODO
 * author zy
 * @date 2019/4/3 2:15
 **/
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAndUserMessageVm implements Serializable {

    @ApiModelProperty(value = "sku", dataType = "String")
    String sku;
    @ApiModelProperty(value = "用户名称", dataType = "String")
    String userName;
    @ApiModelProperty(value = "产品名称", dataType = "String")
    String productName;
    @ApiModelProperty(value = "产品数量", dataType = "String")
    Integer productNum;

}
