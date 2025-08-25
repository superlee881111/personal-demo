package org.example.modular.dev.dev0001.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.db.table.entity.SysDatabaseInfo;
import org.example.common.db.table.entity.SysGeneratorBase;
import org.example.common.db.table.service.SysDatabaseInfoService;
import org.example.common.db.util.DbUtil;
import org.example.common.db.util.TableFieldInfo;
import org.example.config.CustomFieldConfig;
import org.example.modular.dev.dev0001.service.GenerateService;
import org.example.modular.mst.mst0001.mapper.Mst0001Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

//    @Autowired
//    private SysDatabaseInfoService sysDatabaseInfoService;

    @Override
    public List<Map<String, Object>> getTables(Long dataSourceId) {
        SysDatabaseInfo databaseInfo = getDatabaseInfo(dataSourceId);
        return DbUtil.selectTables(databaseInfo);
    }

    @Override
    public List<CustomFieldConfig> getDefaultTableFields(Long dataSourceId, String tableName) {
        List<TableFieldInfo> tableFields = getTableFieldInfos(dataSourceId, tableName);

        //如果没有配置直接转换
        return tableFields.stream().map(tableFieldInfo -> convertToFieldConfig(tableFieldInfo, tableName))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity execute(Long generatorId) {
//        SysGeneratorBase genBase = generatorBaseService.getById(generatorId);
//        if (genBase == null) {
//            throw new ServiceException(400, "database not exist");
//        }
//        ContextParam contextParam = buildContextParam(genBase);
//
//        // 查询template数据（参数和文件）
//        List<String> formTypeList = contextParam.getFormConfigMap().values().stream().map(formConfig -> formConfig.getFormType()).collect(Collectors.toList());
//        List<FormTemplateDto> formTemplateList = formTemplateService.findFormTemplates(formTypeList);
//        List<FormTemplateParamResult> formTemplateParamList = formTemplateParamService.findListByFormTypes(formTypeList);
//
//        // 模板画面map
//        Map<String, List<FormTemplateDto>> templateFormMap = formTemplateList.stream()
//                .filter(formTemplateDto -> (StrUtil.isNotBlank(formTemplateDto.getGeneratorCode())
//                        && StrUtil.isNotBlank(formTemplateDto.getTemplatePath()))).collect(
//                        Collectors.groupingBy(formTemplateResult -> formTemplateResult.getGeneratorCode()));
//
//        // custom画面模板map,outPath不为空
//        Map<String, List<FormTemplateDto>> customFormTemplateMap = formTemplateList.stream()
//                .filter(formTemplateDto -> (StrUtil.isNotBlank(formTemplateDto.getGeneratorCode())
//                        && StrUtil.isNotBlank(formTemplateDto.getTemplatePath())
//                        && StrUtil.isNotBlank(formTemplateDto.getOutPath()))).collect(
//                        Collectors.groupingBy(formTemplateResult -> formTemplateResult.getFormType()));
//
//        Map<String, Map<String, List<FormTemplateParamResult>>> templateParamFormMap = formTemplateParamList.stream().collect(
//                Collectors.groupingBy(formTemplateResult -> formTemplateResult.getTemplateCode(),
//                        Collectors.groupingBy(formTemplateResult -> formTemplateResult.getParamCode())));
//
//        contextParam.setCustomFormTemplateMap(customFormTemplateMap);
//        contextParam.setTemplateFormMap(templateFormMap);
//        contextParam.setTemplateParamFormMap(templateParamFormMap);
//
//        MpParam mpContextParam = new MpParam();
//        mpContextParam.setGeneratorInterface(true);
//        mpContextParam.setIncludeTables(contextParam.getTableArray());
//
//        // 支持多个prefix
//        if (StrUtil.isNotEmpty(genBase.getRemovePrefix())) {
//            mpContextParam.setRemoveTablePrefix(genBase.getRemovePrefix().split(";"));
//        }
//
//        //获取表主键
//        List<TablePk> tablePks = tablePkService.findListByTableList(Arrays.asList(contextParam.getTableArray()));
//        Map<String, List<TablePk>> tablePkMap = tablePks.stream().collect(Collectors.groupingBy(tablePk -> tablePk.getTableName()));
//
//        try {
//            GenSessionFieldConfigs sessionFieldConfigs = new GenSessionFieldConfigs();
//            sessionFieldConfigs.setPkConfigs(tablePkMap);
//            sessionFieldConfigs.setIncludeTables(contextParam.getTableArray());
//            FieldsConfigHolder.put(sessionFieldConfigs);
//
//            //如果是微服务版本代码生成
//            RestfulApiExecutor.executor(contextParam, mpContextParam);
//
//        } finally {
//            FieldsConfigHolder.remove();
//        }
//
//        File zip = ZipUtil.zip(contextParam.getOutputPath(), Charset.forName("MS932"));
//        return renderFile(contextParam.getFileName() + ".zip", zip.getAbsolutePath());
        return null;
    }

    private CustomFieldConfig convertToFieldConfig(TableFieldInfo tableFieldInfo, String tableName) {
        // 默认转换参数
        CustomFieldConfig detail = new CustomFieldConfig();
        detail.setColumnName(tableFieldInfo.getColumnName());
        detail.setFieldName(tableFieldInfo.getCamelFieldName());
        detail.setLabel(tableFieldInfo.getColumnComment());
        detail.setColumnType(tableFieldInfo.getColumnType());
        return detail;
    }

    private List<TableFieldInfo> getTableFieldInfos(Long dataSourceId, String tableName) {
        SysDatabaseInfo databaseInfo = getDatabaseInfo(dataSourceId);
        return DbUtil.getTableFields(databaseInfo, tableName);
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
