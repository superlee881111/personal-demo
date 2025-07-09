package org.example.modular.mst.parameter.paramIn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="入力参数",description="用户DB入力参数")
public class Mst0001InitParam  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID Integer
     */
    @ApiModelProperty(value = "用户名ID Integer", required = true, example = "999")
    private Integer id;

    /**
     * kbn String
     */
    @ApiModelProperty(value = "kbn String", example = "01:common 02:custom")
    private String kbn;
}
