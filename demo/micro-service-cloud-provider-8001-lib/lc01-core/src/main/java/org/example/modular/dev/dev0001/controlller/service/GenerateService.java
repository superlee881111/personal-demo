package org.example.modular.dev.dev0001.controlller.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modular.mst.mst0001.parameter.paramIn.Mst0001InitParam;
import org.example.modular.mst.mst0001.parameter.paramOut.Mst0001InitResult;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * DEV0001 代码生成控制器 サービス
 * </p>
 *
 * @author Li
 * @since 2025-07-01
 */
public interface GenerateService extends IService<Object> {
    /**
     * 初期表示イベント
     *
     * @author Li
     * @since 2025-07-01
     */
    List<Map<String, Object>> getTables(Long dataSourceId);
}
