package org.example.modular.mst.mst0001.parameter.paramOut;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ApiModel(value="出力参数",description="用户DB出力参数")
public class Mst0001InitResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("ID Integer 999")
    private Long id;

    /**
     * データベース名称
     */
    @ApiModelProperty("データベース名称 String")
    private String dbName;

    /**
     * JDBCの駆動タイプ
     */
    @ApiModelProperty("JDBCの駆動タイプ String")
    private String jdbcDriver;

    /**
     * ユーザー
     */
    @ApiModelProperty(value = "ユーザー String", example = "李超")
    private String userName;

    /**
     * パスワード
     */
    @ApiModelProperty("パスワード String")
    private String password;

    /**
     * JDBCのURL
     */
    @ApiModelProperty("JDBCのURL String")
    private String jdbcUrl;

    /**
     * コメント
     */
    @ApiModelProperty("コメント String")
    private String remarks;

    /**
     * 作成時間
     */
    @ApiModelProperty("作成時間 Date")
    private Date createTime;

}
