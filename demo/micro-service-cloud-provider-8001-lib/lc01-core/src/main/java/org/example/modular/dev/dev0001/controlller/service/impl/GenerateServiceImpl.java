package org.example.modular.dev.dev0001.controlller.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.db.table.entity.SysDatabaseInfo;
import org.example.common.db.table.service.SysDatabaseInfoService;
import org.example.common.db.util.DbUtil;
import org.example.modular.dev.dev0001.controlller.service.GenerateService;
import org.example.modular.mst.mst0001.mapper.Mst0001Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mst0001マスタ サービスImpl
 * </p>
 *
 * @author Li
 * @since 2025-07-01
 */
@Service
public class GenerateServiceImpl extends ServiceImpl<Mst0001Mapper, Object> implements GenerateService {

    @Value("${spring.datasource.driver-class-name}")
    private String driveClassName;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    /**
     * システムのDB名称
     */
    private String dbName = "master";

    @Autowired
    private SysDatabaseInfoService sysDatabaseInfoService;

    @Override
    public List<Map<String, Object>> getTables(Long dataSourceId) {
        SysDatabaseInfo databaseInfo = getDatabaseInfo(dataSourceId);
        return DbUtil.selectTables(databaseInfo);
    }

    private SysDatabaseInfo getDatabaseInfo(Long dataSourceId) {
        SysDatabaseInfo databaseInfo;
        if (dataSourceId != null) {
            databaseInfo = getSpecDatabaseInfo(dataSourceId);
        } else {
            databaseInfo = getDefaultDatabaseInfo();
        }
        return databaseInfo;
    }

    private SysDatabaseInfo getDefaultDatabaseInfo() {
        SysDatabaseInfo databaseInfo = new SysDatabaseInfo();
        databaseInfo.setJdbcDriver(driveClassName);
        databaseInfo.setJdbcUrl(dbUrl);
        databaseInfo.setUserName(userName);
        databaseInfo.setPassword(password);
        databaseInfo.setDbName(dbName);
        return databaseInfo;
    }

    private SysDatabaseInfo getSpecDatabaseInfo(Long dataSourceId) {
        SysDatabaseInfo database = sysDatabaseInfoService.getById(dataSourceId);
        if (database == null) {
            throw new RuntimeException("id=>" + dataSourceId +"database not exist");
        }
        return database;
    }

}
