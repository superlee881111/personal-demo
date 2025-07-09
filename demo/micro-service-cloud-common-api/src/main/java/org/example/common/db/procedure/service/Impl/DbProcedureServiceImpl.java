package org.example.common.db.procedure.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.db.procedure.mapper.DbProcedureMapper;
import org.example.common.db.procedure.paramIn.*;
import org.example.common.db.procedure.service.DbProcedureService;
import org.springframework.stereotype.Service;

@Service
public class DbProcedureServiceImpl extends ServiceImpl<DbProcedureMapper, Object> implements DbProcedureService {

    @Override
    public void uinp1311(Uinp1311Input input) {
        this.getBaseMapper().uinp1311(input);
    }

}
