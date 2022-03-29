package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Order;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface OrderService extends IService<Order> {

    List<Order> queryuserorder(Order order);
}
