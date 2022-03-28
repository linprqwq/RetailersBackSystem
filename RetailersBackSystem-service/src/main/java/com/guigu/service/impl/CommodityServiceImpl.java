package com.guigu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CommodityMapper;
import com.guigu.pojo.Commodity;
import com.guigu.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;
    @Override
    //查询商品id
    public Commodity querycommodityid( Integer id) {

        return commodityMapper.selectById(id);
    }
}
