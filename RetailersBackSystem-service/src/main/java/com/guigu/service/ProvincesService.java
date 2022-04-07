package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Orderinfo;
import com.guigu.pojo.Provinces;

import java.util.List;

public interface ProvincesService extends IService<Provinces> {
    List<Provinces> queryAllChina(Provinces provinces);

    List<Provinces> queryChinaByPid(Provinces provinces);

    List<Provinces> queryChinaByshi(Provinces provinces);
}
