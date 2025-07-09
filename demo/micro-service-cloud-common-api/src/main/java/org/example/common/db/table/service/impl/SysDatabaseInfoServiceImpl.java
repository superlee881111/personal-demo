package org.example.common.db.table.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.db.table.entity.SysDatabaseInfo;
import org.example.common.db.table.mapper.SysDatabaseInfoMapper;
import org.example.common.db.table.service.SysDatabaseInfoService;
import org.springframework.stereotype.Service;

@Service
public class SysDatabaseInfoServiceImpl extends ServiceImpl<SysDatabaseInfoMapper, SysDatabaseInfo> implements SysDatabaseInfoService {

}
