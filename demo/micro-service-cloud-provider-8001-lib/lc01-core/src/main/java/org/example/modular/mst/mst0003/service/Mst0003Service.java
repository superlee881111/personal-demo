package org.example.modular.mst.mst0003.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modular.mst.mst0003.param.paramIn.Mst0003InitParam;
import org.example.modular.mst.mst0003.param.paramOut.Mst0003InitResult;

/**
 * <p>
 * Mst0003マスタ サービス
 * </p>
 *
 * @author Li
 * @since 2025-07-01
 */
public interface Mst0003Service extends IService<Object> {
    /**
     * 初期表示イベント
     *
     * @author Li
     * @since 2025-07-01
     */
    Mst0003InitResult excelExporter(Mst0003InitParam param);
}
