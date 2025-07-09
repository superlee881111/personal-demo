package org.example.modular.mst.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.lib.web.ResponseData;
import org.example.modular.mst.parameter.paramIn.Mst0001InitParam;
import org.example.modular.mst.parameter.paramOut.Mst0001InitResult;
import org.example.modular.mst.service.Mst0001Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MST0001マスタ改定 コントローラ
 *
 * @author Li
 * @since 2025-07-01
 */
@RestController
@RequestMapping(name = "[MST0001]MST0001管理", value = "/mst0001")
@Api(tags = "[MST0001]MST0001")
public class Mst0001Controller {

    @Autowired
    private Mst0001Service mst0001Service;

    /**
     * 初期表示イベント
     *
     * @author Li
     * @since 2025-07-01
     */
    @RequestMapping(name = "初期化", value = "/init", method = RequestMethod.POST)
    @ApiOperation(value = "初期化", response = Mst0001InitResult.class, notes = "初期化notes")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData<Mst0001InitResult> init(@RequestBody Mst0001InitParam param) {
        Mst0001InitResult result = mst0001Service.init(param);
        if (ObjectUtils.isEmpty(result)) {
            return ResponseData.successNoData(Mst0001InitResult.builder().build());
        } else {
            return ResponseData.success(result);
        }
    }

//    /**
//     * 検索イベント
//     *
//     * @author Li
//     * @since 2025-07-01
//     */
//    @PostResource(name = "検索", path = "/query")
//    @ApiOperation(value = "検索", response = Mst0001QueryResult.class)
//    @AccessLogAnno(opId = "MST0001", opType = AccessLogOpTypeConstants.QUERY, title = "MST0001マスタ情報の検索を行う。",
//            detailField = "accessLogDetail", menuCodeField = "menuCode", menuNameField = "menuName")
//    @Transactional(rollbackFor = Exception.class)
//    @BusinessLockAnno
//    public ResponseData<Mst0001QueryResult> query(@RequestBody Mst0001QueryParam param) {
//        Mst0001QueryResult result = mst0001Service.query(param);
//        return ResponseData.success(result);
//    }
//
//    /**
//     * 登録イベント
//     *
//     * @author Li
//     * @since 2025-07-01
//     */
//    @PostResource(name = "登録", path = "/save")
//    @ApiOperation(value = "登録")
//    @AccessLogAnno(opId = "MST0001", opType = AccessLogOpTypeConstants.UPDATE, title = "MST0001マスタ情報の登録を行う。",
//            detailField = "accessLogDetail", menuCodeField = "menuCode", menuNameField = "menuName")
//    @Transactional(rollbackFor = Exception.class)
//    @BusinessLockAnno
//    public ResponseData save(@RequestBody Mst0001SaveParam param) {
//        mst0001Service.save(param);
//        return ResponseData.success();
//    }
}
