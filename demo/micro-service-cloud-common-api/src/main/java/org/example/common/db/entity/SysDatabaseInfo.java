package org.example.common.db.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_database_info
 * @author
 */
@Data
public class SysDatabaseInfo implements Serializable {
    /**
     * ID
     */
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

    /**
     * 作成時間
     */
    private Date dstart;

    /**
     * 作成時間
     */
    private Date dend;

    private static final long serialVersionUID = 1L;
}
