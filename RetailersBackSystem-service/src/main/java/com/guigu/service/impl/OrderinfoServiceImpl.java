package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CustomerbalancelogMapper;
import com.guigu.mapper.OrdderdetailsMapper;
import com.guigu.mapper.OrderinfoMapper;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.Customerbalancelog;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;

import com.guigu.pojo.Userinfo;
import com.guigu.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    CustomerbalancelogMapper customerbalancelogMapper;


    //订单表查询
    @Override
    public Page<Orderinfo> queryuserorder(Orderinfo order, int pageno, int pagesize) {
        QueryWrapper queryWrapper = new QueryWrapper();

            if (order.getStatus()>=1){
                queryWrapper.eq("status",order.getStatus());
            }
        queryWrapper.eq("uid",order.getUid());
            queryWrapper.eq("state",1);
        Page<Orderinfo> page = this.page(new Page<Orderinfo>(pageno, pagesize), queryWrapper);
        for (Orderinfo orderinfo : page.getRecords()) {
            //把订单详情数据添加到订单表实体类里
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("orderid",orderinfo.getOrderid());
            orderinfo.setOrdderdetails(ordderdetailsMapper.selectList(queryWrapper1));
        }
      return page;
    }

    //订单删除
    @Override
    public Map<String, String> delorderbyid(Orderinfo orderinfo) {
        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","订单删除失败");
            orderinfo.setState(0);
            int a = orderMapper.updateById(orderinfo);

            if (a>=1){
                map.put("code","1");
                map.put("msg","订单删除成功");
            }

        return map;
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

    @Override
    public Map<String, String> cofirmorder(Orderinfo orderinfo) {
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","失败");
        orderinfo.setStatus(5);
        orderinfo.setColsetime(new Date());
       int a= orderMapper.updateById(orderinfo);
       if (a>=1){
           map.put("code","1");
           map.put("msg","确认成功");
       }
        return map;
    }

    //取消订单
    @Override
    public Map<String, String> qxddorder(Orderinfo orderinfo,boolean boolea) {
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","取消失败");
        if (boolea){
            int i = orderMapper.updateById(orderinfo);
            if (i>=1){
                map.put("code","1");
                map.put("msg","取消成功");
            }
        }else{
            //查询当前订单
            Orderinfo orderinfo1 = orderMapper.selectById(orderinfo.getOrderid());
            //查询当前订单用户
            Userinfo userinfo = userinfoMapper.selectById(orderinfo1.getUid());
            //用户余额添加
            userinfo.setUmoney(userinfo.getUmoney()+orderinfo1.getZprice());
            //用户表修改
            userinfoMapper.updateById(userinfo);
            //用户余额变动
            Customerbalancelog customerbalancelog  =new Customerbalancelog();
            customerbalancelog.setUid(userinfo.getId());
            customerbalancelog.setCtime(new Date());
            customerbalancelog.setAmount(orderinfo1.getZprice());
            customerbalancelog.setSource(4);
            customerbalancelogMapper.insert(customerbalancelog);
            map.put("code","1");
            map.put("msg","取消成功");
        }
        return map;
    }

    //付款
    @Override
    public Map<String, String> fkorder(Orderinfo orderinfo) {
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","当前余额不足,请充值");
        //查询当前订单用户余额
        Userinfo userinfo = userinfoMapper.selectById(orderinfo.getUid());
        //查询当前订单总价格
        Orderinfo orderinfo1 = orderMapper.selectById(orderinfo.getOrderid());

        //判断用户余额大于订单总价格
        if (userinfo.getUmoney()>orderinfo1.getZprice()){

            //用户余额更改
            userinfo.setUmoney(userinfo.getUmoney()-orderinfo1.getZprice());
            //用户余额变动表添数据
            Customerbalancelog customerbalancelog = new Customerbalancelog();
            //记录生成时间
            customerbalancelog.setCtime(new Date());
            //用户id
            customerbalancelog.setUid(orderinfo.getUid());
            //状态
            customerbalancelog.setSource(2);
            //消费金额
            customerbalancelog.setAmount(orderinfo1.getZprice());
            //用户余额变动表新增
            customerbalancelogMapper.insert(customerbalancelog);

            //修改用户表
            userinfoMapper.updateById(userinfo);

            //更改订单表状态
            orderinfo1.setStatus(3);
            int i = orderMapper.updateById(orderinfo1);
            if (i>=1){
                map.put("code","1");
                map.put("msg","支付成功");
            }
        }
        return map;
    }


}
