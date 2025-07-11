package org.example.modular.mst.mst0003.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.lib.web.ResponseData;
import org.example.modular.mst.mst0003.param.paramIn.Mst0003InitParam;
import org.example.modular.mst.mst0003.param.paramOut.Mst0003InitResult;
import org.example.modular.mst.mst0003.service.Mst0003Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MST0003 コントローラ
 *
 * @author Li
 * @since 2025-07-01
 */
@RestController
@RequestMapping(name = "[MST0003]Excelファイル処理", value = "/mst0003")
@Api(tags = "[MST0003]Excelファイル処理")
public class Mst0003Controller {

    @Autowired
    private Mst0003Service mst0003Service;

    /**
     * 初期表示イベント
     *
     * @author Li
     * @since 2025-07-01
     */
    @RequestMapping(name = "Excel出力", value = "/excelExporter", method = RequestMethod.POST)
    @ApiOperation(value = "Excel出力", response = Mst0003InitResult.class, notes = "Excel出力notes")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData<Mst0003InitResult> excelExporter(@RequestBody Mst0003InitParam param) {
        Mst0003InitResult result = mst0003Service.excelExporter(param);
        if (ObjectUtils.isEmpty(result)) {
            return ResponseData.successNoData(Mst0003InitResult.builder().build());
        } else {
            return ResponseData.success(result);
        }
    }
}
