package org.example.modular.dev.dev0001.controlller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.common.lib.web.ResponseData;
import org.example.modular.dev.dev0001.controlller.service.GenerateService;
import org.example.modular.mst.mst0001.parameter.paramOut.Mst0001InitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @ApiOperation(value = "テーブル取得", response = Mst0001InitResult.class, notes = "テーブル取得notes")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData<List<Map<String, Object>>> getTables(@RequestParam(value = "dataSourceId", required = false) Long dataSourceId) {
        List<Map<String, Object>> tableFields = generateService.getTables(dataSourceId);
        return ResponseData.success(tableFields);
    }
}
