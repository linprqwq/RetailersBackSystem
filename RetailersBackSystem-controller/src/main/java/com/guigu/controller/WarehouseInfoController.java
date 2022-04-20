package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.WarehouseInfo;

import com.guigu.service.WarehouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
@RestController
public class WarehouseInfoController {

    @Autowired
    WarehouseInfoService warehouseInfoService;

    /**
     * 查询仓库
     * @param warehouseInfo
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping("queryallck.action")
    @CrossOrigin
    public Page<WarehouseInfo>  queryallck(WarehouseInfo warehouseInfo, @RequestParam(value = "pageno",defaultValue = "1")Integer pageno,
                                           @RequestParam(value="pagesize",defaultValue = "5")Integer pagesize){
        return warehouseInfoService.queryallck(warehouseInfo,pageno,pagesize);
    }

    //查询仓库是否重复
    @RequestMapping("cxwhouse.action")
    @CrossOrigin
    public Map<String,String> cxwhouse(WarehouseInfo warehouseInfo){
        return warehouseInfoService.cxwhouse(warehouseInfo);
    }

    //添加仓库  仓库商品分类表
    @RequestMapping("tjck.action")
    @CrossOrigin
    public Map<String,String> tjck(WarehouseInfo warehouseInfo,int [] arr){
        return warehouseInfoService.tjck(warehouseInfo,arr);
    }

    @RequestMapping("querywarehouseInfobyid.action")
    @CrossOrigin
    public WarehouseInfo querywarehouseInfobyid(WarehouseInfo warehouseInfo){
        return warehouseInfoService.querywarehouseInfobyid(warehouseInfo);
    }

    @RequestMapping("updatewarehbyid.action")
    @CrossOrigin
    public Map<String,String> updatewarehbyid(WarehouseInfo warehouseInfo,int [] list){

        return warehouseInfoService.updatewarehbyid(warehouseInfo,list);
    }
}

