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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
           //把商品数据添加到实体类里的commodity里
            ((Cart)emp).setCommodity(commodityMapper.selectById(((Cart) emp).getCid()));
        }
        return carts ;
    }

    @Override
    //加入购物车
    public Map<String, String> addspingcart(Cart cart) {
        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","购物车已有当前商品");
        int insert=0;
        QueryWrapper  queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",cart.getUid());
        queryWrapper.eq("cid",cart.getCid());
        //查询数据库当前用户购物车商品
        Cart cart1 = cartMapper.selectOne(queryWrapper);
        //数据库已有数据
        if (cart1!=null){
            //商品数量加1
            int a = cart1.getQuantity()+1;
            System.out.println("商品数量:"+a);
            cart1.setQuantity(a);
            //添加到数据库
            cartMapper.updateById(cart1);
        }else if (cart1==null){
            cart.setQuantity(1);
            insert = cartMapper.insert(cart);
        }

        if (insert!=0){
            map.put("code","1");
            map.put("msg","加入购物车成功");
        }
        return map;
    }
}
