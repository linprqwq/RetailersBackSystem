package com.guigu.controller;


import com.guigu.pojo.WarehouseDetailsInfo;
import com.guigu.pojo.WarehouseInfo;
import com.guigu.service.WarehouseDetailsInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
@RestController
public class WarehouseDetailsInfoController {

    @Autowired
    WarehouseDetailsInfoService warehouseDetailsInfoService;

    @RequestMapping("querywaredetails.action")
    @CrossOrigin
    public Page<WarehouseDetailsInfo> querywaredetails(WarehouseDetailsInfo warehouseDetailsInfo,
                                                       @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                                       @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        System.out.println(warehouseDetailsInfo);
        return warehouseDetailsInfoService.querywaredetails(warehouseDetailsInfo, pageno, pagesize);
    }

}

