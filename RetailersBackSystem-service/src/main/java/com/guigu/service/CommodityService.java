package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commodity;

public interface CommodityService extends IService<Commodity> {
    Commodity querycommodityid(Integer id);
}
