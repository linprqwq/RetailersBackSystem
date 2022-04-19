package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.CompanyRunningWater;
import com.guigu.pojo.Shyys;

import java.util.List;

public interface CompanyRunningWaterService extends IService<CompanyRunningWater> {
    List<Shyys> qeruyshys(int uid);
}
