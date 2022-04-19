package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Cart;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;
import com.guigu.pojo.Userinfo;

import java.util.List;
import java.util.Map;

public interface CartService extends IService<Cart> {
    //我的购物车查询
    List<Cart> querygwcid(Integer id);
    //加入购物车
    Map<String, String> addspingcart(Cart cart);
    //购物车加减
    Map<String, String> gwcssjj(Cart cart,boolean pdjj);
    //提交订单查询商品信息
    List<Cart> queryusergwc(int[] list, Cart cart);
    //提交订单
    Map<String, String> usertijiaodd(int[] list, Orderinfo orderinfo);

    //添加购物车
    Map<String, String> addgwc(int[] arr, Cart cart);

    Map<String, String> cartplscid(int[] list);

    Cart ljgmaddgwc(Cart c);
}
