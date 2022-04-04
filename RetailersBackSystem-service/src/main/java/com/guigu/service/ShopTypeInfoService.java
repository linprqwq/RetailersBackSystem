package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.ShopTypeInfo;

import java.util.List;

public interface  ShopTypeInfoService  extends IService<ShopTypeInfo> {

    //将商品进行分类
    List<ShopTypeInfo> queryallshoptype();
}
