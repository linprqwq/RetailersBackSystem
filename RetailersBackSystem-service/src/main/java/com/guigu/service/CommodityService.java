package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commodity;

public interface CommodityService extends IService<Commodity> {
    //查询商品id
    Commodity querycommodityid(Integer id);
}
