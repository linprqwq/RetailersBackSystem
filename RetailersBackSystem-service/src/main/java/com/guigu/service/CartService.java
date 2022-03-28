package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {
    //我的购物车查询
    List<Cart> querygwcid(Integer id);
}
