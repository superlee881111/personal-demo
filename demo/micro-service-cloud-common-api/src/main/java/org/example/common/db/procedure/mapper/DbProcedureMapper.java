package org.example.common.db.procedure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.common.db.procedure.paramIn.*;

/**
 * データベースの中procedure定義
 */
@Mapper
public interface DbProcedureMapper extends BaseMapper<Object> {
    /**
     * @param input{@link Uinp1311Input}
     */
    void uinp1311(Uinp1311Input input);

}
