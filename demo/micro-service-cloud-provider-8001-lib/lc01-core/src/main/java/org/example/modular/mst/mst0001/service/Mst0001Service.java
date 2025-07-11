package org.example.modular.mst.mst0001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modular.mst.mst0001.parameter.paramIn.Mst0001InitParam;
import org.example.modular.mst.mst0001.parameter.paramOut.Mst0001InitResult;

/**
 * <p>
 * Mst0001マスタ サービス
 * </p>
 *
 * @author Li
 * @since 2025-07-01
 */
public interface Mst0001Service extends IService<Object> {
    /**
     * 初期表示イベント
     *
     * @author Li
     * @since 2025-07-01
     */
    Mst0001InitResult init(Mst0001InitParam param);
}
