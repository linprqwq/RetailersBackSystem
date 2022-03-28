package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.OrderMapper;
import com.guigu.pojo.Order;
import com.guigu.service.OrderService;
import org.springframework.stereotype.Service;

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

}
