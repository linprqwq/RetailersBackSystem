package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.OrdderdetailsMapper;
import com.guigu.mapper.OrderinfoMapper;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;

import com.guigu.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


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

    @Autowired
    OrdderdetailsMapper ordderdetailsMapper;


    //订单表查询
    @Override
    public Page<Orderinfo> queryuserorder(Orderinfo order, int pageno, int pagesize) {
        QueryWrapper queryWrapper = new QueryWrapper();

            if (order.getStatus()>=1){
                queryWrapper.eq("status",order.getStatus());
            }
        queryWrapper.eq("uid",order.getUid());
        Page<Orderinfo> page = this.page(new Page<Orderinfo>(pageno, pagesize), queryWrapper);
        for (Orderinfo orderinfo : page.getRecords()) {
            //把订单详情数据添加到订单表实体类里
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("orderid",orderinfo.getOrderid());
            Ordderdetails ordderdetails = ordderdetailsMapper.selectOne(queryWrapper1);
            orderinfo.setOrdderdetails(ordderdetails);
        }
      return page;
    }

    @Override
    public Page<Orderinfo> queryshorder(Orderinfo order, int pageno, int pagesize) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("orderid");
        queryWrapper.eq("sid",order.getSid());
        queryWrapper.in("status",3,4,5);

        Page<Orderinfo> page = this.page(new Page<Orderinfo>(pageno, pagesize), queryWrapper);
        return page;
    }

    @Override
    public Page<Orderinfo> queryshdshorder(Orderinfo order, int pageno, int pagesize) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("orderid");
        queryWrapper.eq("sid",order.getSid());
        queryWrapper.eq("status",order.getStatus());

        Page<Orderinfo> page = this.page(new Page<Orderinfo>(pageno, pagesize), queryWrapper);
        return page;

    }

    @Override
    public Map uptorderdsh(Orderinfo orderinfo) {
        boolean num = this.updateById(orderinfo);
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","操作失败");
        if(num){
            map.put("code","1");
            map.put("msg","操作成功");
        }
        return map;
    }


}
