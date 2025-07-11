package org.example.modular.mst.mst0001.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.common.db.table.entity.SysDatabaseInfo;

@Mapper
public interface Mst0001Mapper extends BaseMapper<Object> {

    /**
     * データベース情報の取得
     *
     * @param id 区分ID
     * @return　SysDatabaseInfo
     */
    SysDatabaseInfo selectSysDatabaseInfo(@Param("id") int id);
}

