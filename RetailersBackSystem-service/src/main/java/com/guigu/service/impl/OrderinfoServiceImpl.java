package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.OrderinfoMapper;
import com.guigu.pojo.Orderinfo;
import com.guigu.service.OrderinfoService;
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
public class OrderinfoServiceImpl extends ServiceImpl<OrderinfoMapper, Orderinfo> implements OrderinfoService {

    @Autowired
    OrderinfoMapper orderMapper;

    @Override
    public List<Orderinfo> queryuserorder(Orderinfo order) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",order.getUid());
        return orderMapper.selectList(queryWrapper);
    }
}
