package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.ShopTypeInfo;
import com.guigu.service.ShopTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/shopinfo.action/")
public class ShopTypeInfoController {

    //自动导入
    @Autowired
    ShopTypeInfoService shopTypeInfoService;

    //根据id删除
    @DeleteMapping("delshopid.action/{id}")
    public Map delshopid(@PathVariable Integer id){

        return  shopTypeInfoService.delshopid(id);
    }

    //添加分类
    @PostMapping("addsptype.acction")
    public Map addsptype(@RequestBody ShopTypeInfo shopTypeInfo){
        System.out.println(shopTypeInfo);
        return  shopTypeInfoService.addsp(shopTypeInfo);
    }

    //根据分类id去查找
   @GetMapping("selectid.action/{id}")
    public  ShopTypeInfo selectid(@PathVariable Integer id){
        return  shopTypeInfoService.selectid(id);
    }

    //编辑
    @PutMapping("updatashop.action")
    public Map updatashop(@RequestBody ShopTypeInfo shopTypeInfo){

        return  shopTypeInfoService.updatashop(shopTypeInfo);
    }


    //分页
    @GetMapping("queryfyshop.action")
    public Page<ShopTypeInfo> queryfyshop(ShopTypeInfo shopTypeInfo,
                                          @RequestParam(value = "pageno",defaultValue = "1")Integer pageno,
                                          @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize)
    {

        return  shopTypeInfoService.queryfyshop(shopTypeInfo,pageno,pagesize);
    }

    //去显示所有商品的分类
    @GetMapping("queryallshoptype.action")
    public List<ShopTypeInfo> queryallshoptype(){
        return shopTypeInfoService.queryallshoptype();
    }
}
