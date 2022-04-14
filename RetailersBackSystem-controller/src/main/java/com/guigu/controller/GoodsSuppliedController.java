package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Goodsupplied;
import com.guigu.service.GoodsuppliedService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @RequestMapping("/queryAllSupplier.action")
    public Page<Goodsupplied> queryallUser(Goodsupplied goodsupplied,
                                           @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                           @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return goodsuppliedService.queryAllSupplier(goodsupplied, pageno, pagesize);
    }



    //提供商品添加商品到供应商商品表
    @PutMapping("addsupplierSupplyOfGoods.action")
    public Map add(@RequestBody Goodsupplied goodsupplied){

        return goodsuppliedService.add(goodsupplied);

    }

    //根据当前用户，查询供应商目前可以添加到供应商维护商品表里面的商品
        @GetMapping("/selelctcomodity.action")
        public List<Commodity> selelctcomodity(Commodity commodity,
                                               @RequestParam(value = "id")Integer id){

            System.out.println("商品"+commodity);
            System.out.println("用户id"+id);
            return  goodsuppliedService.selelctcomodity(commodity,id);
        }


    //查询用户表里面的数据
    @GetMapping("/queryallSupplier.action")
    public List<Goodsupplied> queryallsupplied(){
        return goodsuppliedService.queryallgoodsupp();
    }


}

