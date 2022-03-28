package com.guigu.controller;

import com.guigu.pojo.Cart;
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
}
