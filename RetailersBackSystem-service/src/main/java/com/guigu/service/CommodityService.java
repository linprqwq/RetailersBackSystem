package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commodity;

import java.util.List;

public interface CommodityService extends IService<Commodity> {
    //查询商品id
    Commodity querycommodityid(Integer id);

    //查询所有
    List<Commodity> QueryAllCommodity();
}
