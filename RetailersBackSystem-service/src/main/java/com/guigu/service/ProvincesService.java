package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Orderinfo;
import com.guigu.pojo.Provinces;

import java.util.List;

public interface ProvincesService extends IService<Provinces> {
    List<Provinces> queryAllSheng(Provinces provinces);

    List<Provinces> queryChinaByShi(String  id);

    List<Provinces> queryChinaByQu(String  id);
}
