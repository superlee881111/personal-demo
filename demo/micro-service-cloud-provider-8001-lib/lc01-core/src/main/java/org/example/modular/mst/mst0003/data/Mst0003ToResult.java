package org.example.modular.mst.mst0003.data;

import org.example.common.db.table.entity.SysDatabaseInfo;
import org.example.modular.mst.mst0003.param.paramOut.Mst0003InitResult;

public class Mst0003ToResult {
    private Mst0003ToResult() throws IllegalAccessException {throw new IllegalAccessException("Utility class");}
    public static Mst0003InitResult toInitResult(SysDatabaseInfo results) {
        return Mst0003InitResult.builder()
                .id(results.getId())
                .dbName(results.getUserName())
                .jdbcUrl(results.getJdbcUrl())
                .build();
    }
}
