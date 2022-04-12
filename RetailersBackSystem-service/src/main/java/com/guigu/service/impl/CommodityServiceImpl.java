package com.guigu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CommodityMapper;
import com.guigu.pojo.Commodity;
import com.guigu.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;
    @Override
    //查询商品id
    public Commodity querycommodityid( Integer id) {

        return commodityMapper.selectById(id);
    }
    //查询所有商品
    public List<Commodity> QueryAllCommodity(){
        return commodityMapper.QueryAllCommodity();
    }

    @Override
    public List<Commodity> QueryAllCommodityHS() {
        return commodityMapper.QueryAllCommodityHS();
    }

    @Override
    public List<Commodity> QueryAllCommodityRL() {
        return commodityMapper.QueryAllCommodityRL();
    }
}
