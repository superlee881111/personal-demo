package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_database_info
 * @author
 */
@TableName
@Data
public class SysDatabaseInfo implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * データベース名称
     */
    private String dbName;

    /**
     * JDBCの駆動タイプ
     */
    private String jdbcDriver;

    /**
     * ユーザー
     */
    private String userName;

    /**
     * パスワード
     */
    private String password;

    /**
     * JDBCのURL
     */
    private String jdbcUrl;

    /**
     * コメント
     */
    private String remarks;

    /**
     * 作成時間
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
