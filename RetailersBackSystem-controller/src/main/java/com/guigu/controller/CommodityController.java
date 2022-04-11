package com.guigu.controller;


import com.guigu.pojo.Commodity;
import com.guigu.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @GetMapping("queryspid.action")
    @CrossOrigin
    //查询商品id
    public Commodity querycommodityid(Integer id){
        System.out.println(id);
        return commodityService.querycommodityid(id);
    }

    @RequestMapping("queryAllcom.action")
    @CrossOrigin
    //查询所有
    public List<Commodity>QueryAllCommodity(){
        return commodityService.QueryAllCommodity();
    }
}
