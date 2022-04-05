package com.guigu.controller;


import com.guigu.pojo.Commodity;
import com.guigu.pojo.Goodsupplied;
import com.guigu.service.GoodsuppliedService;
import org.springframework.beans.factory.annotation.Autowired;
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


    //添加商品到供应商维护商品表
    @PutMapping("supplierSupplyOfGoods.action")
    public Map add(@RequestBody Goodsupplied goodsupplied){

        return null;
       //return goodsuppliedService.add(goodsupplied);
    }

    //根据当前用户，查询供应商目前可以添加到供应商维护商品表里面的商品
        @GetMapping("/selelctcomodity.action")
        public List<Commodity> selelctcomodity(Commodity commodity,
                                               @RequestParam(value = "id")Integer id){
            return  goodsuppliedService.selelctcomodity(commodity,id);
        }


    //获取供应商品里面的所有数据
    @GetMapping("/queryallSupplier.action")
    public List<Goodsupplied> queryallsupplied(){
        return goodsuppliedService.queryallgoodsupp();
    }


}

