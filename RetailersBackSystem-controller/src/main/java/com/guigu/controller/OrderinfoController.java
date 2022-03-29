package com.guigu.controller;


import com.guigu.pojo.Orderinfo;
import com.guigu.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class OrderinfoController {

    @Autowired
    OrderinfoService orderService;

    @RequestMapping("queryuserorder.action")
    @CrossOrigin
    public List<Orderinfo> queryuserorder(Orderinfo order){

        return orderService.queryuserorder(order);
    }

}

