package org.example.common.db.util;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import org.apache.ibatis.datasource.DataSourceException;
import org.example.common.db.sqls.TableListSql;
import org.example.common.db.table.entity.SysDatabaseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtil {
    private static final Logger log = LoggerFactory.getLogger(DbUtil.class);

    public DbUtil() {
    }

    public static List<Map<String, Object>> selectTables(SysDatabaseInfo dbInfo) {
        ArrayList tables = new ArrayList();

        try {
            Class.forName(dbInfo.getJdbcDriver());
            Connection conn = DriverManager.getConnection(dbInfo.getJdbcUrl(), dbInfo.getUserName(), dbInfo.getPassword());
            String dbName = getDbName(dbInfo);
            PreparedStatement preparedStatement = conn.prepareStatement((new TableListSql()).getSql(dbInfo.getJdbcUrl()));
            if (dbInfo.getJdbcUrl().contains("postgresql")) {
                String schema = "public";
                if (dbInfo.getJdbcUrl().contains("currentSchema=")) {
                    int start = dbInfo.getJdbcUrl().indexOf("currentSchema=");
                    int end = dbInfo.getJdbcUrl().indexOf("&", start);
                    if (end < 0) {
                        end = dbInfo.getJdbcUrl().length();
                    }

                    schema = dbInfo.getJdbcUrl().substring(start + "currentSchema=".length(), end);
                }

                preparedStatement.setString(1, schema);
            }

            if (!dbInfo.getJdbcUrl().contains("sqlserver") && !dbInfo.getJdbcUrl().contains("postgresql")) {
                preparedStatement.setString(1, dbName);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                HashMap<String, Object> map = new HashMap();
                String tableName = resultSet.getString("tableName");
                String tableComment = resultSet.getString("tableComment");
                map.put("tableName", tableName);
                map.put("tableComment", tableComment);
                tables.add(map);
            }

            return tables;
        } catch (Exception var9) {
            log.error("該当データベース全部テーブル情報の取得が異常終了しました！", var9);
            throw new DataSourceException("異常終了しました！");
        }
    }

//    public static List<SysDatabaseInfo> getTableFields(Connection conn, String tableName) {
//        ArrayList fieldList = new ArrayList();
//
//        try {
//            String sql = (new TableFieldListSql()).getSql("postgresql");
//            sql = String.format(sql, tableName);
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//                TableFieldInfo tableFieldInfo = new TableFieldInfo();
//                String columnName = resultSet.getString("columnName");
//                String columnComment = resultSet.getString("columnComment");
//                String dbType = resultSet.getString("columnType");
//                PostgreSqlTypeConvert convert = new PostgreSqlTypeConvert();
//                GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder().dateType(DateType.ONLY_DATE).build();
//                IColumnType iColumnType = convert.processTypeConvert(globalConfig, dbType);
//                tableFieldInfo.setColumnType(iColumnType.getType());
//                tableFieldInfo.setColumnName(columnName);
//                tableFieldInfo.setColumnComment(columnComment);
//                tableFieldInfo.setCamelFieldName(StrUtil.toCamelCase(columnName));
//                fieldList.add(tableFieldInfo);
//            }
//
//            return fieldList;
//        } catch (Exception var13) {
//            log.error("該当テーブル全部カラム内容の取得が異常終了しました！", var13);
//            throw new DataSourceException(DataSourceExceptionEnum.QUERY_DATASOURCE_INFO_ERROR);
//        }
//    }
//
//    public static List<TableFieldInfo> getTableFields(SysDatabaseInfo dbInfo, String tableName) {
//        ArrayList fieldList = new ArrayList();
//
//        try {
//            Class.forName(dbInfo.getJdbcDriver());
//            Connection conn = DriverManager.getConnection(dbInfo.getJdbcUrl(), dbInfo.getUserName(), dbInfo.getPassword());
//            String sql = (new TableFieldListSql()).getSql(dbInfo.getJdbcUrl());
//            if (dbInfo.getJdbcUrl().contains("postgresql")) {
//                sql = String.format(sql, tableName);
//            }
//
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            if (dbInfo.getJdbcUrl().contains("oracle")) {
//                preparedStatement.setString(1, tableName);
//            } else if (!dbInfo.getJdbcUrl().contains("postgresql")) {
//                if (dbInfo.getJdbcUrl().contains("sqlserver")) {
//                    preparedStatement.setString(1, tableName);
//                } else {
//                    String dbName = getDbName(dbInfo);
//                    preparedStatement.setString(1, tableName);
//                    preparedStatement.setString(2, dbName);
//                }
//            }
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//                TableFieldInfo tableFieldInfo = new TableFieldInfo();
//                String columnName = resultSet.getString("columnName");
//                String columnComment = resultSet.getString("columnComment");
//                if (dbInfo.getJdbcUrl().contains("postgresql")) {
//                    String dbType = resultSet.getString("columnType");
//                    PostgreSqlTypeConvert convert = new PostgreSqlTypeConvert();
//                    GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder().dateType(DateType.ONLY_DATE).build();
//                    IColumnType iColumnType = convert.processTypeConvert(globalConfig, dbType);
//                    tableFieldInfo.setColumnType(iColumnType.getType());
//                }
//
//                tableFieldInfo.setColumnName(columnName);
//                tableFieldInfo.setColumnComment(columnComment);
//                tableFieldInfo.setCamelFieldName(StrUtil.toCamelCase(columnName));
//                fieldList.add(tableFieldInfo);
//            }
//
//            return fieldList;
//        } catch (Exception var14) {
//            log.error("該当テーブル全部カラム内容の取得が異常終了しました！", var14);
//            throw new DataSourceException(DataSourceExceptionEnum.QUERY_DATASOURCE_INFO_ERROR);
//        }
//    }
//
//    public static void createDatabase(SysDatabaseInfo dbInfo, String databaseName) {
//        try {
//            Class.forName(dbInfo.getJdbcDriver());
//            Connection conn = DriverManager.getConnection(dbInfo.getJdbcUrl(), dbInfo.getUserName(), dbInfo.getPassword());
//            String sql = (new CreateDatabaseSql()).getSql(dbInfo.getJdbcUrl());
//            sql = sql.replaceAll("\\?", databaseName);
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            int i = preparedStatement.executeUpdate();
//            log.info("データベースを作成する！数量：" + i);
//        } catch (Exception var6) {
//            log.error("execute sql error！", var6);
//            throw new ServiceException(500, "create multi tenant-execute sql error！");
//        }
//    }
//
    private static String getDbName(SysDatabaseInfo dbInfo) {
        if (dbInfo.getJdbcUrl().contains("oracle")) {
            return dbInfo.getUserName();
        } else {
            int first;
            if (dbInfo.getJdbcUrl().contains("postgresql")) {
                first = dbInfo.getJdbcUrl().lastIndexOf("/") + 1;
                return dbInfo.getJdbcUrl().substring(first);
            } else if (dbInfo.getJdbcUrl().contains("sqlserver")) {
                first = dbInfo.getJdbcUrl().lastIndexOf("=") + 1;
                return dbInfo.getJdbcUrl().substring(first);
            } else {
                String jdbcUrl = dbInfo.getJdbcUrl();
                first = jdbcUrl.lastIndexOf("/") + 1;
                int last = jdbcUrl.indexOf("?");
                return jdbcUrl.substring(first, last);
            }
        }
    }
}
