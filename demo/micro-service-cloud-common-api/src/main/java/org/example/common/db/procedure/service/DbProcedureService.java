package org.example.common.db.procedure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.common.db.procedure.paramIn.Uinp1311Input;

public interface DbProcedureService extends IService<Object> {
    void uinp1311(Uinp1311Input input);
}

