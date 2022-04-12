package com.guigu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.*;
import com.guigu.pojo.*;
import com.guigu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.*;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    OrderinfoMapper orderinfoMapper;
    @Autowired
    OrdderdetailsMapper ordderdetailsMapper;

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

    @Override
    //购物车加减
    public Map<String, String> gwcssjj(Cart cart,boolean pdjj) {
        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","失败");
        Cart cart1 =     cartMapper.selectById(cart.getCartid());

        if (pdjj==false){
           int a = cart1.getQuantity()+1;
           cart1.setQuantity(a);
            cartMapper.updateById(cart1);

        }
        if (pdjj&&cart1.getQuantity()==1){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("cartid",cart1.getCartid());
           cartMapper.delete(queryWrapper);
        }
        if (pdjj){
            int a = cart1.getQuantity()-1;
            cart1.setQuantity(a);
            cartMapper.updateById(cart1);
        }
        map.put("code","1");
        map.put("msg","成功");

        return map;
    }
    //提交订单查询商品信息
    @Override
    public List<Cart> queryusergwc(int[] list, Cart cart) {

        //id放到querywrapper里面
       QueryWrapper queryWrapper = new QueryWrapper();
       queryWrapper.eq("uid",cart.getUid());
        //循环查询添加到list里

        List<Cart> list1 =   cartMapper.selectusergwc(list,cart);
        //根据id查询商品表商品
        for (Object emp:list1) {
            //把商品数据添加到实体类里的commodity里
            ((Cart)emp).setCommodity(commodityMapper.selectById(((Cart) emp).getCid()));
        }

        return list1;
    }
    //提交订单
    @Override
    public Map<String, String> usertijiaodd(int[] list,Orderinfo orderinfo) {


        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","下单失败");
        System.out.println(orderinfo);
        //创建时间
        orderinfo.setCreatetime(new Date());
        //待评价
        orderinfo.setEvaluate(2);
        //显示
        orderinfo.setState(1);
        //商户id


        //添加订单表
      orderinfoMapper.insert(orderinfo);

      //订单详情表
        for (int i : list) {
            Ordderdetails ordderdetails = new Ordderdetails();
            //订单详情表里 订单表id
            ordderdetails.setOrderid(orderinfo.getOrderid());
            //订单详情表用户id
            ordderdetails.setUid(orderinfo.getUid());
            //订单详情表商品编号
            ordderdetails.setProid(i);
            //订单详情表商品名称
            Commodity commodity = commodityMapper.selectById(i);
            ordderdetails.setProname(commodity.getProname());
            //订单详情表图片地址
            ordderdetails.setProimage(commodity.getProimage());
            //订单详情表商品单价
            ordderdetails.setProsprice(commodity.getProsprice());
            //订单详情表商品数量
         Cart cart =    cartMapper.selectcartone(i,orderinfo.getUid());
            ordderdetails.setQuantity(cart.getQuantity());
            //订单详情表创建时间
            ordderdetails.setCreatetime(new Date());
            //退款状态
            ordderdetails.setRefund(0);

          int a =   ordderdetailsMapper.insert(ordderdetails);
          if (a>=1){
              //删除购物车表里购买的商品
              boolean b = cartMapper.scbyid(i,orderinfo.getUid());
              if (b){
                  map.put("code","1");
                  map.put("msg","下单成功");
              }
          }
        }

        return map;
    }

    //添加购物车
    @Override
    public Map<String, String> addgwc(int[] arr, Cart cart) {

            Map<String,String> map = new HashMap<>();


        for (int i : arr) {

            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("uid",cart.getUid());
            queryWrapper.eq("cid",i);
            Cart cart1 = cartMapper.selectOne(queryWrapper);
            if (cart1!=null){
                cart1.setQuantity(cart1.getQuantity()+1);
                cartMapper.updateById(cart1);
                map.put("code","0");
                map.put("msg","购物车已有当前商品");
            }else{
                cart.setCid(i);
                cart.setQuantity(1);
                int a =  cartMapper.insert(cart);
                if (a>=1){
                    map.put("code","1");
                    map.put("msg","加入购物车成功");
                }
            }
        }
        return map;
    }
}
