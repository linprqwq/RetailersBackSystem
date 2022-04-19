package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.ShopTypeInfo;

import java.util.List;
import java.util.Map;

public interface  ShopTypeInfoService  extends IService<ShopTypeInfo> {

    //将商品进行分类
    List<ShopTypeInfo> queryallshoptype();


    //分页
    Page<ShopTypeInfo> queryfyshop(ShopTypeInfo shopTypeInfo,Integer pageno,Integer pagesize);


    //添加分类
    Map addsp(ShopTypeInfo shopTypeInfo);

    //根据id去删除
    Map delshopid(Integer id);

    //根据id去查询
    ShopTypeInfo selectid(Integer id);

    //编辑
    Map updatashop(ShopTypeInfo shopTypeInfo);


    List<String> getIds(String str);

    List<ShopTypeInfo> queryAllComClass();
}
