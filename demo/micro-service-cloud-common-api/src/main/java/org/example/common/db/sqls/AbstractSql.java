package org.example.common.db.sqls;

import org.example.common.lib.enums.DbIdEnum;

public abstract class AbstractSql {
    public AbstractSql() {
    }

    public String getSql(String jdbcUrl) {
        if (jdbcUrl.contains(DbIdEnum.ORACLE.getName())) {
            return this.oracle();
        } else if (jdbcUrl.contains(DbIdEnum.PG_SQL.getName())) {
            return this.pgSql();
        } else {
            return jdbcUrl.contains(DbIdEnum.MS_SQL.getName()) ? this.sqlServer() : this.mysql();
        }
    }

    protected abstract String mysql();

    protected abstract String sqlServer();

    protected abstract String pgSql();

    protected abstract String oracle();
}