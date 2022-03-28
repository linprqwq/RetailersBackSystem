package com.guigu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CartMapper;
import com.guigu.mapper.CommodityMapper;
import com.guigu.pojo.Cart;
import com.guigu.pojo.Commodity;
import com.guigu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Override
    //我的购物车查询
    public List<Cart> querygwcid(Integer id) {
        QueryWrapper  queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",id);
        List<Cart> carts =   cartMapper.selectList(queryWrapper);
        for (Object emp:carts) {
            //这里调用Emp中的getEmpno方法
            ((Cart)emp).setCommodity(commodityMapper.selectById(((Cart) emp).getCid()));
        }
        return carts ;
    }
}
