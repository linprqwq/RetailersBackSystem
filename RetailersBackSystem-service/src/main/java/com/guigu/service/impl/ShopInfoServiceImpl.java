package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.ShopInfoMapper;
import com.guigu.mapper.SysEmployeesMapper;
import com.guigu.pojo.ShopInfo;
import com.guigu.pojo.SysEmployees;
import com.guigu.service.ShopInfoService;
import com.guigu.service.SysEmployeesService;
import org.springframework.stereotype.Service;

@Service
public class ShopInfoServiceImpl extends ServiceImpl<ShopInfoMapper, ShopInfo>
        implements ShopInfoService {
}
