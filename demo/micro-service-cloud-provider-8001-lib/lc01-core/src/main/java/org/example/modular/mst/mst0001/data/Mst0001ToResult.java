package org.example.modular.mst.mst0001.data;

import org.example.common.db.table.entity.SysDatabaseInfo;
import org.example.modular.mst.mst0001.parameter.paramOut.Mst0001InitResult;

public class Mst0001ToResult {
    private Mst0001ToResult() throws IllegalAccessException {throw new IllegalAccessException("Utility class");}
    public static Mst0001InitResult toInitResult(SysDatabaseInfo results) {
        return Mst0001InitResult.builder()
                .id(results.getId())
                .dbName(results.getUserName())
                .jdbcUrl(results.getJdbcUrl())
                .build();
    }
}
