package org.example.modular.dev.dev0001.controlller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.common.lib.web.ResponseData;
import org.example.config.CustomFieldConfig;
import org.example.modular.dev.dev0001.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * DEV0001 代码生成控制器 コントローラ
 *
 * @author Li
 * @since 2025-07-29
 */
@Slf4j
@RestController
@RequestMapping(name = "[DEV0001]代码生成控制器", value = "/dev0001")
@Api(tags = "[DEV0001]代码生成控制器")
public class GeneratorController {

    @Autowired
    private GenerateService generateService;

    /**
     * 初期表示イベント
     *
     * @author Li
     * @since 2025-07-01
     */
    @RequestMapping(name = "テーブル取得", value = "/getTables", method = RequestMethod.POST)
    @ApiOperation(value = "テーブル取得", notes = "テーブル取得notes")
    @ResponseBody
    public ResponseData<List<Map<String, Object>>> getTables(@RequestParam(value = "dataSourceId", required = false) Long dataSourceId) {
        List<Map<String, Object>> tableFields = generateService.getTables(dataSourceId);
        return ResponseData.success(tableFields);
    }

    /**
     * 获取表的字段列表
     *
     * @author Li
     * @since 2025-07-01
     */
    @RequestMapping(name = "テーブルカラム取得", value = "/getDefaultTableFields", method = RequestMethod.POST)
    @ApiOperation(value = "テーブルカラム取得", notes = "テーブルカラム取得notes")
    @ResponseBody
    public ResponseData<List<CustomFieldConfig>> getDefaultTableFields(@RequestParam("tableName") String tableName,
                                              @RequestParam(value = "dataSourceId", required = false) Long dataSourceId) {

        List<CustomFieldConfig> tableFields = generateService.getDefaultTableFields(dataSourceId, tableName);

        return ResponseData.success(tableFields);
    }


    /**
     * 执行代码生成
     */
    @RequestMapping(name = "ソース生成", value = "/execute", method = RequestMethod.POST)
    @ApiOperation(value = "ソース生成", notes = "ソース生成notes")
    @ResponseBody
    public ResponseEntity execute(@RequestParam("generatorId") Long generatorId) {
        return generateService.execute(generatorId);
    }

}
