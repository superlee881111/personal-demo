package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.SysDatabaseInfo;

@Mapper
public interface HelloTMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDatabaseInfo record);

    int insertSelective(SysDatabaseInfo record);
    SysDatabaseInfo selectByPrimaryKey(long id);

    int updateByPrimaryKeySelective(SysDatabaseInfo record);

    int updateByPrimaryKey(SysDatabaseInfo record);

//    SysDatabaseInfo selecttest(@Param("id") Long id);
}
