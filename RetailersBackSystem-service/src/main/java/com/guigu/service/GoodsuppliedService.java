package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.*;

import java.util.List;
import java.util.Map;


//供应商提供商品
public interface GoodsuppliedService extends IService<Goodsupplied> {

    //处理总店采购申请（供应商确认发货）
    public Map supplierfh(PurchaseInfo purchaseInfo);

    //根据用户，去查询供应商目前可以添加的供应商维护商品平商品表的商品
    com.guigu.service.utils.Page<Commodity> selelctcomodity(Commodity commodity, Integer  id, Integer pageno, Integer pagesize );

    //分页查询
    Page<Commodity> fecom(Commodity commodity, Integer  id, Integer pageno, Integer pagesize );

    //根据id去查询商品维护表里面的对象
    Goodsupplied querybyid(Integer supplyOrderId);

    //去查询供应商维护分页操作
    Page<Goodsupplied> queryAllSupplier(Goodsupplied goodsupplied,Integer pageno,Integer pagesize);


    //去根据待供应商商品表 去查询商品 商品类型
    Goodsupplied querybysid(Integer id);

    //修改供应商里面的信息
    Map  xgsupplier(Goodsupplied goodsupplied);



    //在供应商表里面去添加商品
    Map add(Goodsupplied goodsupplied);

    //去查询当前供应商提供的商品
   List<Goodsupplied> queryallgoodsupp();

    Map checkGoodsupplied(Goodsupplied goodsupplied);

    List<Goodsupplied> queryAllGoodSupplied();

    Goodsupplied queryById(Integer shopId);
}
