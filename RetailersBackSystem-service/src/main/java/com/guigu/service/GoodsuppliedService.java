package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Goodsupplied;
import com.guigu.pojo.SupplierGoodsCategory;

import java.util.List;
import java.util.Map;


//供应商提供商品
public interface GoodsuppliedService extends IService<Goodsupplied> {


    //根据当前的用户，去查询供应商目前可以添加的供应商维护商品平商品表的商品
    List<Commodity>  selelctcomodity(Commodity commodity,Integer  id );


    //根据id去查询商品维护表里面的对象
    Goodsupplied querybyid(Integer supplyOrderId);

    //在供应商表里面去添加商品
    Map add(Goodsupplied goodsupplied);

    //去查询当前供应商提供的商品
   List<Goodsupplied> queryallgoodsupp();
}
