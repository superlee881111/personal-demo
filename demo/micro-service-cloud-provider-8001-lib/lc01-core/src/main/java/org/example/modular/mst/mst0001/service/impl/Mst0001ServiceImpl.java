package org.example.modular.mst.mst0001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.db.table.entity.SysDatabaseInfo;
import org.example.common.db.table.service.SysDatabaseInfoService;
import org.example.modular.mst.mst0001.data.Mst0001ToResult;
import org.example.modular.mst.mst0001.mapper.Mst0001Mapper;
import org.example.modular.mst.mst0001.parameter.paramOut.Mst0001InitResult;
import org.example.modular.mst.mst0001.service.Mst0001Service;
import org.example.modular.mst.mst0001.parameter.paramIn.Mst0001InitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Mst0001マスタ サービスImpl
 * </p>
 *
 * @author Li
 * @since 2025-07-01
 */
@Service
public class Mst0001ServiceImpl extends ServiceImpl<Mst0001Mapper, Object> implements Mst0001Service {

    @Autowired
    private SysDatabaseInfoService sysDatabaseInfoService;

    @Override
    public Mst0001InitResult init(Mst0001InitParam param) {

        SysDatabaseInfo sysDatabaseInfo = new SysDatabaseInfo();
        if ("01".equals(param.getKbn())) {
            QueryWrapper<SysDatabaseInfo> info = new QueryWrapper<>();
            info.lambda().eq(SysDatabaseInfo::getId, param.getId());
            sysDatabaseInfo = sysDatabaseInfoService.getOne(info);
//            if(sysDatabaseInfo == null) {
//                throw new RuntimeException("id=>" + param.getId() +",该用户不存在。或者信息无法找到");
//            }
        }else {
            sysDatabaseInfo = this.getBaseMapper().selectSysDatabaseInfo(param.getId());
//            if(sysDatabaseInfo == null) {
//                throw new RuntimeException("id=>" + param.getId() +",该用户不存在。或者信息无法找到");
//            }
        }
        return Mst0001ToResult.toInitResult(sysDatabaseInfo);
    }

}
