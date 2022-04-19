package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.CompanyRunningWater;
import com.guigu.pojo.Shyys;

import java.util.List;

public interface CompanyRunningWaterMapper extends BaseMapper<CompanyRunningWater> {

    List<Shyys> qeruyshys(int uid);
}
