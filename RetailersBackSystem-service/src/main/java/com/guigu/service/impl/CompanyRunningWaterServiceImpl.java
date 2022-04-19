package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CommthinfoMapper;
import com.guigu.mapper.CompanyRunningWaterMapper;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.CompanyRunningWater;
import com.guigu.service.CommthinfoService;
import com.guigu.service.CompanyRunningWaterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyRunningWaterServiceImpl extends ServiceImpl<CompanyRunningWaterMapper, CompanyRunningWater> implements CompanyRunningWaterService {
    @Override
    public List<CompanyRunningWater> qeruyshys(CompanyRunningWater companyRunningWater) {
        QueryWrapper queryWrapper=new QueryWrapper();
        return null;
    }
}
