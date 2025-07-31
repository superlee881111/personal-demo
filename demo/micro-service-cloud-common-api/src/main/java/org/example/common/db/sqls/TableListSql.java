package org.example.common.db.sqls;

public class TableListSql extends AbstractSql {
    public TableListSql() {
    }

    protected String mysql() {
        return "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = ?";
    }

    protected String sqlServer() {
        return "SELECT DISTINCT\nd.name as tableName,\nCONVERT(varchar(200), f.value) as tableComment\nFROM\nsyscolumns a\nLEFT JOIN systypes b ON a.xusertype= b.xusertype\nINNER JOIN sysobjects d ON a.id= d.id\nAND d.xtype= 'U'\nAND d.name<> 'dtproperties'\nLEFT JOIN syscomments e ON a.cdefault= e.id\nLEFT JOIN sys.extended_properties g ON a.id= G.major_id\nAND a.colid= g.minor_id\nLEFT JOIN sys.extended_properties f ON d.id= f.major_id\nAND f.minor_id= 0";
    }

    protected String pgSql() {
        return "select relname as \"tableName\", cast(obj_description(relfilenode,'pg_class') as varchar) as tableComment from pg_class c JOIN pg_namespace n on c.relnamespace = n.oid where relkind = 'r' and relname not like 'pg_%' and relname not like 'sql_%' and n.nspname = ? order by relname;";
    }

    protected String oracle() {
        return "select ut.table_name as tableName, co.comments as tableComment from user_tables ut\nleft join user_tab_comments co on ut.table_name = co.table_name\nwhere tablespace_name is not null and  user= ?";
    }
}