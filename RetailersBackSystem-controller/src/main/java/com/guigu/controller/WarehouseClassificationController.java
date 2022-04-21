package com.guigu.controller;


import com.guigu.pojo.WarehouseInfo;
import com.guigu.service.WarehouseClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
public class WarehouseClassificationController {
    @Autowired
    WarehouseClassificationService warehouseClassificationService;


}

