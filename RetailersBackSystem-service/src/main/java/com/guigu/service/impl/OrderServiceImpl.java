package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.OrderMapper;
import com.guigu.pojo.Order;
import com.guigu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> queryuserorder(Order order) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",order.getUid());
        return orderMapper.selectList(queryWrapper);
    }
}
