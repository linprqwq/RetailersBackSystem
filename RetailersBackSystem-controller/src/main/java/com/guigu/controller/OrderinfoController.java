package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Orderinfo;
import com.guigu.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@RestController
public class OrderinfoController {

    @Autowired
    OrderinfoService orderService;

    //查询当前用户订单信息
    @RequestMapping("queryuserorder.action")
    @CrossOrigin
    public Page<Orderinfo> queryuserorder(Orderinfo order, @RequestParam(value = "pageno", defaultValue = "1") int pageno,
                                          @RequestParam(value = "pagesize", defaultValue = "5") int pagesize) {
        return orderService.queryuserorder(order, pageno, pagesize);
    }

    //删除当前用户指定订单

    @RequestMapping("delorder.action")
    @CrossOrigin
    public Map<String, String> deleorder(Orderinfo orderinfo) {
        System.out.println(orderinfo);
        return orderService.delorderbyid(orderinfo);
    }

    @RequestMapping("queryshorder.action")
    @CrossOrigin
    public Page<Orderinfo> queryshorder(Orderinfo order, @RequestParam(value = "pageno",defaultValue = "1")int pageno,
                                          @RequestParam(value = "pagesize",defaultValue = "5")int pagesize){
        return orderService.queryshorder(order,pageno,pagesize);
    }
    @RequestMapping("queryshdshorder.action")
    @CrossOrigin
    public Page<Orderinfo> queryshdshorder(Orderinfo order, @RequestParam(value = "pageno",defaultValue = "1")int pageno,
                                          @RequestParam(value = "pagesize",defaultValue = "5")int pagesize){
        return orderService.queryshdshorder(order,pageno,pagesize);
    }
    @RequestMapping("uptorderdsh.action")
    @CrossOrigin
    public Map uptorderdsh(Orderinfo orderinfo){
        return orderService.uptorderdsh(orderinfo);
    }

    //确认收货
    @PostMapping("cofirmorder.action")
    @CrossOrigin
    public Map<String,String> cofirmorder(Orderinfo orderinfo){
        return orderService.cofirmorder(orderinfo);
    }
}

