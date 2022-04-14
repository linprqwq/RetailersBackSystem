package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.guigu.mapper.*;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Goodsupplied;
import com.guigu.pojo.SupplierGoodsCategory;
import com.guigu.pojo.Userinfo;
import com.guigu.service.CommodityService;
import com.guigu.service.GoodsuppliedService;
import com.sun.prism.impl.Disposer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsuppliedServiceImpl extends ServiceImpl<GoodsuppliedMapper, Goodsupplied>
        implements  GoodsuppliedService {


    @Autowired
    UserinfoMapper userinfoMapper; //用户表

    @Autowired
    CommodityMapper commodityMapper;   //商品表

    @Autowired
    GoodsuppliedMapper goodsuppliedMapper; // 供应商提供商品

    @Autowired
    SupplierGoodsCategoryMapper supplierGoodsCategoryMapper; //供应商品分类

    //查询可供应的商品
    @Override
    public List<Commodity> selelctcomodity(Commodity commodity,Integer id) {

        //去定义商品表集合
        List<Commodity> records=new ArrayList();
        //去根据用户id,查询供应商维护商品分类表里面的数据
        QueryWrapper queryWrapper=new QueryWrapper<SupplierGoodsCategory>();

        queryWrapper.eq("p_id",id);
        //去查询应分类表里面的数据
            List<SupplierGoodsCategory> supplierGoodsCategoryList=
                  supplierGoodsCategoryMapper.selectList(queryWrapper);
        //查询商品表里面的数据 根据分类筛选商品
            queryWrapper =new QueryWrapper<Commodity>();
            //循环设置条件
            for (int i=0;i<supplierGoodsCategoryList.size();i++){
            queryWrapper.eq("shop_type",supplierGoodsCategoryList.get(i).getSortId());
                //检查是否循环到最后一个元素
                if(i+1!=supplierGoodsCategoryList.size()){
                        //不是最后一个元素  添加or
                    queryWrapper.or();
                }
            }
            //条件查询
            //商品名称
                if(!StringUtil.isEmpty(commodity.getProname())){
                    queryWrapper.eq("proname",commodity.getProname());
                }

     List<Commodity> commodityList=commodityMapper.selectList(queryWrapper);
        //将筛选出来的商品 循环查询 ，检查供应商商品表里面是否存在商品，如果不存在，就要将该商品取出来
        queryWrapper=new QueryWrapper<Goodsupplied>();
        for(Commodity c:commodityList){
            //商品表里面的数据
                queryWrapper =new QueryWrapper<Commodity>();
                queryWrapper.eq("g_id",c.getId());
        //根据商品表id,查询数据的条数，说明没有供应商品
            if( goodsuppliedMapper.selectList(queryWrapper).size()<1){
                    //没有数据添加到集合中
                records.add(c);
            }
        }
        return records;
    }


    //(供货商分页的显示)
    @Override
    public Page<Goodsupplied> queryAllSupplier(Goodsupplied goodsupplied, Integer pageno, Integer pagesize) {

        QueryWrapper<Goodsupplied> queryWrapper= new QueryWrapper<Goodsupplied>();

        //条件查询
        //审核状态
            if(goodsupplied.getIsCheck()!=null){
                    queryWrapper.eq("is_check",goodsupplied.getIsCheck());
            }
        //删除状态
        if(goodsupplied.getIsDelete()!=null){
                    queryWrapper.eq("is_delete",goodsupplied.getIsDelete());
        }

        Page<Goodsupplied> page=this.page(new Page<Goodsupplied>(pageno,pagesize),queryWrapper);

        //循环集合  添加对象，补全属性
        for(Goodsupplied supplied:page.getRecords()){
                //设置供应商对象
            //添加供应商
            supplied.setUserinfo(userinfoMapper.selectById(supplied.getPId()));
            Commodity commodity = commodityMapper.selectById(supplied.getGId());
            //添加商品分类
            commodity.setSupplierGoodsCategory(supplierGoodsCategoryMapper.selectById(commodity.getShopType()));
            //添加商品
            supplied.setCommodity(commodity);
        }

        return  page;
    }

    //去修改供应商状态
    @Override
    public Map xgsupplier(Goodsupplied goodsupplied) {
        return null;
    }

    //去根据供应商里面的id查询商品和供应商
    @Override
    public Goodsupplied querybyid(Integer supplyOrderId) {
        Goodsupplied supplied=this.getById(supplyOrderId);
        supplied.setUserinfo(userinfoMapper.selectById(supplied.getPId()));
        supplied.setCommodity(commodityMapper.selectById(supplied.getGId()));

        return supplied;
    }

    //去添加商品到供应商
    @Override
    public Map add(Goodsupplied goodsupplied) {
            Map<String,Object> map=new HashMap<>();
            //设置默认属性值
            //设置配置
            goodsupplied.setIsConfig(0);
            //设置为等待审核
            goodsupplied.setIsCheck(0);
            //设置为正常供应的商品
            goodsupplied.setIsDelete(0);
            //去进行添加
            if(goodsuppliedMapper.insert(goodsupplied)>0)
            {
                    map.put("msg","申请提交审核成功，等待审核");
                    map.put("x",true);
            } else {
                map.put("msg","操作失败");
                map.put("x",false);
            }
        return map;
    }

    //去查询所有提供的商品
    @Override
    public List<Goodsupplied> queryallgoodsupp() {
        List<Goodsupplied> list=this.list();
        for (Goodsupplied goodsupplied:list){
                //设置用户
            goodsupplied.setUserinfo(userinfoMapper.selectById(goodsupplied.getPId()));
        }
        return list;
    }

    @Override
    public Map checkGoodsupplied(Goodsupplied goodsupplied) {
        Map map=new HashMap();
        if(goodsupplied.getIsCheck()==1){
            boolean b = this.updateById(goodsupplied);
            map.put("msg","操作失败");
            map.put("code","0");
            if(b){
                map.put("msg","审核通过！！");
                map.put("code","1");
            }
        }else{
            goodsupplied.setIsDelete(1);
            boolean b = this.updateById(goodsupplied);
            map.put("msg","操作失败");
            map.put("code","0");
            if(b){
                map.put("msg","拒绝通过！！");
                map.put("code","1");
            }
        }
        return map;
    }
}
