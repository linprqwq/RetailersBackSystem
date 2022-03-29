package com.guigu.controller;


import com.guigu.pojo.Order;
import com.guigu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("queryuserorder.action")
    public List<Order> queryuserorder(Order order){

        return orderService.queryuserorder(order);
    }

}

