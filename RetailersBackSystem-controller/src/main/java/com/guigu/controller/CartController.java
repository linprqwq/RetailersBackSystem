package com.guigu.controller;

import com.guigu.pojo.Cart;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;
import com.guigu.pojo.Userinfo;
import com.guigu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("querygwcid.action")
    @CrossOrigin
    //我的购物车查询
    public List<Cart> querygwcid(Integer uid){
        return cartService.querygwcid(uid);
    }

    @PostMapping("addspingcart.action")
    @CrossOrigin
    //加入购物车
    public Map<String,String> addspingcart(Cart cart){
        System.out.println(cart);
        return cartService.addspingcart(cart);
    }

    @PostMapping("gwcssjj.action")
    @CrossOrigin
    //购物车加减
    public Map<String,String> gwcssjj(Cart cart,boolean pdjj){

        return cartService.gwcssjj(cart,pdjj);
    }

    @PostMapping("queryusergwc")
    @CrossOrigin
    //提交订单查询商品信息
    public List<Cart> queryusergwc(int list [], Cart cart){
        return cartService.queryusergwc(list,cart);
    }

    @PostMapping("usertijiaodd.action")
    @CrossOrigin
    //提交订单
    public Map<String,String> usertijiaodd(int list [],Cart cart){
        return cartService.usertijiaodd(list,cart);
    }

    @PostMapping("addgwc.action")
    @CrossOrigin
    public Map<String,String> addgwc(int arr [],Cart cart){
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(cart);
        return cartService.addgwc(arr,cart);
    }


}
