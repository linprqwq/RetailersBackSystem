package com.guigu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.guigu.mapper.CommodityMapper;
import com.guigu.pojo.Commodity;
import com.guigu.service.CommodityService;
import com.guigu.service.ShopTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    ShopTypeInfoService shopTypeInfoService;
    @Override
    //查询商品id
    public Commodity querycommodityid( Integer id) {



        return commodityMapper.selectById(id);
    }


    //查询所有商品分页
    @Override
    public Page<Commodity> queryAllshop(Commodity commodity, Integer pageno, Integer pagesize) {
      //条件查询
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<Commodity>();
        queryWrapper.eq("is_delete",0);
        //判断是否为空
        if(StringUtil.isNotEmpty(commodity.getProname())){
            queryWrapper.like("proname",commodity.getProname());
        }
        Page<Commodity> page=this.page(new Page<Commodity>(pageno,pagesize),queryWrapper);

        //查找商品类型
        for(Commodity commodity1:page.getRecords()){
            commodity1.setShopTypeInfo(shopTypeInfoService.getById(commodity1.getShopType()));
        }
        return page;
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
