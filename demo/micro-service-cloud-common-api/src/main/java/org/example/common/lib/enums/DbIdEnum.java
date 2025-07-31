package org.example.common.lib.enums;

public enum DbIdEnum {
    MYSQL("mysql", "mysql"),
    PG_SQL("pgsql", "postgresql"),
    ORACLE("oracle", "oracle"),
    MS_SQL("mssql", "sqlserver");

    private final String code;
    private final String name;

    private DbIdEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
