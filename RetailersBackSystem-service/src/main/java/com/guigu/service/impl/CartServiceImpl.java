package com.guigu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CartMapper;
import com.guigu.pojo.Cart;
import com.guigu.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
}
