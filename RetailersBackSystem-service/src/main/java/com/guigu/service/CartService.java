package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Cart;
import com.guigu.pojo.Userinfo;

import java.util.List;
import java.util.Map;

public interface CartService extends IService<Cart> {
    //我的购物车查询
    List<Cart> querygwcid(Integer id);

    Map<String, String> addspingcart(Cart cart);

    Map<String, String> gwcssjj(Cart cart,boolean pdjj);

    List<Cart> queryusergwc(int[] list, Cart cart);
}
