package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CommthinfoMapper;
import com.guigu.mapper.CompanyRunningWaterMapper;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.CompanyRunningWater;
import com.guigu.pojo.Shyys;
import com.guigu.service.CommthinfoService;
import com.guigu.service.CompanyRunningWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyRunningWaterServiceImpl extends ServiceImpl<CompanyRunningWaterMapper, CompanyRunningWater> implements CompanyRunningWaterService {

@Autowired

    CompanyRunningWaterMapper companyRunningWaterMapper;
    @Override
    public List<Shyys> qeruyshys(int uid) {

        List<Shyys> list=companyRunningWaterMapper.qeruyshys(uid);
        return list;
    }
}
