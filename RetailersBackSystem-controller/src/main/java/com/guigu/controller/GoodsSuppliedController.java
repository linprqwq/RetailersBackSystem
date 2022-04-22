package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Goodsupplied;
import com.guigu.pojo.PurchaseInfo;
import com.guigu.service.GoodsuppliedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@CrossOrigin
@RestController
@RequestMapping("/goodsSupplied/")
public class GoodsSuppliedController {

    //自动注入
    @Autowired
    GoodsuppliedService goodsuppliedService;

    //供应商供应状态
    @PutMapping("updatadelte.action")
    public  Map updatadelte(@RequestBody Goodsupplied goodsupplied){

        return goodsuppliedService.updatadelte(goodsupplied);
    }
    //处理总店采购申请【供应商确认发货】
    @PostMapping("supplierfh.action")
    public Map supplierfh(@RequestBody PurchaseInfo purchaseInfo){
        return  goodsuppliedService.supplierfh(purchaseInfo);
    }

    //供应商商品供应表的分页查询
    @GetMapping("queryALlPage.action")
    public Page<Goodsupplied>  queryALlPage(Goodsupplied goodsupplied,
                                        @RequestParam(value="pageno",defaultValue ="1")Integer pageno,
                                        @RequestParam(value ="pagesize",defaultValue ="5")Integer pagesize ){

        return goodsuppliedService.queryAllSupplier(goodsupplied,pageno,pagesize);
    }

    //获取供应商维护表
    @GetMapping("queryAllGoodSupplied.action")
    public List<Goodsupplied>  queryAllGoodSupplied(){

        return goodsuppliedService.queryAllGoodSupplied();
    }

    //提供商品添加商品到供应商商品表
    @PutMapping("addsupplierSupplyOfGoods.action")
    public Map add(@RequestBody Goodsupplied goodsupplied){

        return goodsuppliedService.add(goodsupplied);

    }

    //根据当前用户，查询供应商目前可以添加到供应商维护商品表里面的商品
        @GetMapping("/selelctcomodity.action")
        public com.guigu.service.utils.Page  selelctcomodity(Commodity commodity,
                                                          @RequestParam(value = "id")Integer id,
                                                          @RequestParam(value = "pageno",defaultValue = "1")Integer pageno,
                                                          @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize)
        {

            System.out.println("商品"+commodity);
            System.out.println("用户id"+id);
            return  goodsuppliedService.selelctcomodity(commodity,id,pageno,pagesize);
        }

    //去根据待供应商商品表 去查询商品 商品类型
    @GetMapping("querybysid.action/{id}")
    public Goodsupplied querybyid(@PathVariable Integer id){
        return goodsuppliedService.querybysid(id);
    }

    //供应商修改供应商品的价格
    @PutMapping("xgsupplier.action")
    public Map xgsupplier(@RequestBody Goodsupplied goodsupplied){
        return  goodsuppliedService.xgsupplier(goodsupplied);
    }

    //查询用户表里面的数据
    @GetMapping("/queryallSupplier.action")
    public List<Goodsupplied> queryallsupplied(){
        return goodsuppliedService.queryallgoodsupp();
    }

    //审核供应商维护商品
    @PostMapping("checkGoodsupplied.action")
    public Map checkGoodsupplied(@RequestBody Goodsupplied goodsupplied){
        return  goodsuppliedService.checkGoodsupplied(goodsupplied);
    }

}

