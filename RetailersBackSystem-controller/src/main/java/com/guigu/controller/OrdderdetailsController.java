package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;
import com.guigu.service.OrdderdetailsService;
import com.guigu.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@RestController
@RequestMapping("/ordderdetails")
public class OrdderdetailsController {
    @Autowired
    OrdderdetailsService ordderdetailsService;
    @RequestMapping("queryshorderdetails.action")
    @CrossOrigin
    public List<Ordderdetails> queryshorderdetails(Ordderdetails ordderdetails){

        return ordderdetailsService.queryshorderdetails(ordderdetails);
    }
}

