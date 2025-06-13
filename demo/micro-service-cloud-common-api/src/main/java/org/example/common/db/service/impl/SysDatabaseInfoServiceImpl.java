package org.example.common.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.db.entity.SysDatabaseInfo;
import org.example.common.db.mapper.SysDatabaseInfoMapper;
import org.example.common.db.service.SysDatabaseInfoService;
import org.springframework.stereotype.Service;

@Service
public class SysDatabaseInfoServiceImpl extends ServiceImpl<SysDatabaseInfoMapper, SysDatabaseInfo> implements SysDatabaseInfoService {

}
