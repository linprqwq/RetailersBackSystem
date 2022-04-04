package com.guigu.controller;


import com.guigu.pojo.ShopTypeInfo;
import com.guigu.service.ShopTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shopinfo.action/")
public class ShopTypeInfoController {

    //自动导入
    @Autowired
    ShopTypeInfoService shopTypeInfoService;

    //去显示所有商品的分类
    @GetMapping("queryallshoptype.action")
    public List<ShopTypeInfo> queryallshoptype(){
        return shopTypeInfoService.queryallshoptype();
    }
}
