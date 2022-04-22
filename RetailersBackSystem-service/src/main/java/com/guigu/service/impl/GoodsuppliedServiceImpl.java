package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.guigu.mapper.*;
import com.guigu.pojo.*;
import com.guigu.service.CommodityService;
import com.guigu.service.GoodsuppliedService;
import com.guigu.service.ShopInfoService;
import com.sun.prism.impl.Disposer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsuppliedServiceImpl extends ServiceImpl<GoodsuppliedMapper, Goodsupplied>
        implements GoodsuppliedService {


    @Autowired
    UserinfoMapper userinfoMapper; //用户表

    @Autowired
    CommodityMapper commodityMapper;   //商品表

    @Autowired
    ShopInfoMapper shopInfoMapper;
    @Autowired
    GoodsuppliedMapper goodsuppliedMapper; // 供应商提供商品

    @Autowired
    SupplierGoodsCategoryMapper supplierGoodsCategoryMapper; //供应商品分类

    @Autowired
    PurchaseDetailInfoMapper purchaseDetailInfoMapper;// 采购详情表

    @Autowired
    PurchaseInfoMapper purchaseInfoMapper; //采购申请表
    @Autowired
    ShopTypeInfoMapper shopTypeInfoMapper;

    //采购单去申请 然后去发货
    @Override
    public Map supplierfh(PurchaseInfo purchaseInfo) {

        Map<String, Object> map = new HashMap<>();

        if (purchaseInfoMapper.updateById(purchaseInfo) > 0) {
            map.put("msg", "确认发货成功");
            map.put("x", true);
        } else {
            map.put("msg", "发货失败");
            map.put("x", false);
        }
        return map;
    }

    //查询可供应的商品
    @Override
    public com.guigu.service.utils.Page<Commodity> selelctcomodity(Commodity commodity, Integer id, Integer pageno, Integer pagesize) {

        //去定义商品表集合
        List<Commodity> records = new ArrayList();
        //去根据用户id,查询供应商维护商品分类表里面的数据
        QueryWrapper queryWrapper = new QueryWrapper<SupplierGoodsCategory>();

        queryWrapper.eq("p_id", id);
        //去查询应分类表里面的数据
        List<SupplierGoodsCategory> supplierGoodsCategoryList =
                supplierGoodsCategoryMapper.selectList(queryWrapper);
        //查询商品表里面的数据 根据分类筛选商品
        queryWrapper = new QueryWrapper<Commodity>();
        //循环设置条件
        for (int i = 0; i < supplierGoodsCategoryList.size(); i++) {
            queryWrapper.eq("shop_type", supplierGoodsCategoryList.get(i).getSortId());
            //检查是否循环到最后一个元素
            if (i + 1 != supplierGoodsCategoryList.size()) {
                //不是最后一个元素  添加or
                queryWrapper.or();
            }
        }
        //条件查询
        //商品名称
        if (!StringUtil.isEmpty(commodity.getProname())) {
            queryWrapper.eq("proname", commodity.getProname());
        }

        List<Commodity> commodityList = commodityMapper.selectList(queryWrapper);
        //将筛选出来的商品 循环查询 ，检查供应商商品表里面是否存在商品，如果不存在，就要将该商品取出来
        queryWrapper = new QueryWrapper<Goodsupplied>();
        for (Commodity c : commodityList) {
            //商品表里面的数据
            queryWrapper = new QueryWrapper<Commodity>();
            queryWrapper.eq("g_id", c.getId());  //如果供应商有了这个数据  就跳过了
            //根据商品表id,查询数据的条数，说明没有供应商品
            if (goodsuppliedMapper.selectList(queryWrapper).size() < 1) {
                //没有数据添加到集合中
                records.add(c);
            }
            //补全商品分类属性
            if (c.getId() != null) {
                c.setShopTypeInfo(shopTypeInfoMapper.selectById(c.getId()));
            }

        }
        com.guigu.service.utils.Page page = new com.guigu.service.utils.Page();
        return page.pageList(records, pageno, pagesize);
    }

    @Override
    public Page<Commodity> fecom(Commodity commodity, Integer id, Integer pageno, Integer pagesize) {
        return null;
    }


    //(供货商分页的显示)
    @Override
    public Page<Goodsupplied> queryAllSupplier(Goodsupplied goodsupplied, Integer pageno, Integer pagesize) {
        System.out.println(goodsupplied);
        QueryWrapper<Goodsupplied> queryWrapper = new QueryWrapper<Goodsupplied>();
        //审核状态
//        queryWrapper.eq("is_check", 1);
//        //供应状态
//        queryWrapper.eq("is_delete", 0);
        if (goodsupplied.getIsCheck() != null) {
            queryWrapper.eq("is_check", goodsupplied.getIsCheck());
        }
        if (goodsupplied.getIsDelete() != null) {
            queryWrapper.eq("is_delete", goodsupplied.getIsDelete());
        }

        if (goodsupplied.getGId() != null) {
            queryWrapper.eq(
                    "g_id", goodsupplied.getGId());
        }
        if (goodsupplied.getPId() != null) {
            queryWrapper.eq(
                    "p_id", goodsupplied.getPId());
        }

        Page<Goodsupplied> page = this.page(new Page<Goodsupplied>(pageno, pagesize), queryWrapper);

        for (Goodsupplied goods : page.getRecords()) {
            //去设置用户
            Commodity commodity = commodityMapper.selectById(goods.getGId());
            goods.setCommodity(commodity);
            goods.setShopTypeInfo(shopTypeInfoMapper.selectById(commodity.getShopType()));
            goods.setUserinfo(userinfoMapper.selectById(goods.getPId()));
        }


        return page;
    }


    //去根据待供应商商品表 去查询商品 商品类型
    @Override
    public Goodsupplied querybysid(Integer id) {
        Goodsupplied g = this.getById(id);
        if (g != null) {
            Commodity c = commodityMapper.selectById(g.getGId());
            g.setCommodity(c);
            g.setShopTypeInfo(shopTypeInfoMapper.selectById(c.getShopType()));
        }
        return g;
    }

    //去修改供应商状态
    @Override
    public Map xgsupplier(Goodsupplied goodsupplied) {
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "修改失败");
        if (goodsupplied.getSupplierPrice() != null) {
            boolean b = this.updateById(goodsupplied);
            if (b) {
                map.put("code", "1");
                map.put("msg", "修改成功");
            }
        }
        return map;
    }


    //供应商的提供状态  可供应 取消供应
    @Override
    public Map updatadelte(Goodsupplied goodsupplied) {
        Map map = new HashMap();
//        if (goodsuppliedMapper.updateById(goodsupplied) > 0) {
//            if (goodsupplied.getIsDelete() == 0) {
//                map.put("msg", "商品正在供应");
//                map.put("x", true);
//            } else {
//                map.put("msg", "取消供应商品");
//                map.put("x", false);
//            }
//        }
        if(goodsupplied.getIsDelete()==0){
            int i = goodsuppliedMapper.updateById(goodsupplied);
            map.put("msg", "操作失败");
            map.put("x", false);
            if(i>0){
                map.put("x",true);
                map.put("msg","商品正在供应");
            }
        }else{
            int i = goodsuppliedMapper.updateById(goodsupplied);
            map.put("msg", "操作失败");
            map.put("x", false);
            if(i>0){
                map.put("x",true);
                map.put("msg","取消供应商品");
            }
        }
        return map;
    }

    //去根据供应商里面的id查询商品和供应商
    @Override
    public Goodsupplied querybyid(Integer supplyOrderId) {
        Goodsupplied supplied = this.getById(supplyOrderId);
        supplied.setUserinfo(userinfoMapper.selectById(supplied.getPId()));
        supplied.setCommodity(commodityMapper.selectById(supplied.getGId()));

        return supplied;
    }

    //去添加商品到供应商
    @Override
    public Map add(Goodsupplied goodsupplied) {
        Map<String, Object> map = new HashMap<>();
        //设置默认属性值
        //设置配置
        goodsupplied.setIsConfig(0);
        //设置为等待审核
        goodsupplied.setIsCheck(0);
        //设置为正常供应的商品
        goodsupplied.setIsDelete(0);
        //去进行添加
        if (goodsuppliedMapper.insert(goodsupplied) > 0) {
            map.put("msg", "申请提交审核成功，等待审核");
            map.put("x", true);
        } else {
            map.put("msg", "操作失败");
            map.put("x", false);
        }
        return map;
    }

    //去查询所有提供的商品
    @Override
    public List<Goodsupplied> queryallgoodsupp() {
        List<Goodsupplied> list = this.list();
        for (Goodsupplied goodsupplied : list) {
            //设置用户
            goodsupplied.setUserinfo(userinfoMapper.selectById(goodsupplied.getPId()));
        }
        return list;
    }

    @Override
    public Map checkGoodsupplied(Goodsupplied goodsupplied) {
        Map map = new HashMap();
        if (goodsupplied.getIsCheck() == 1) {
            boolean b = this.updateById(goodsupplied);
            map.put("msg", "操作失败");
            map.put("code", "0");
            if (b) {
                map.put("msg", "审核通过！！");
                map.put("code", "1");
            }
        } else {
            goodsupplied.setIsDelete(1);
            boolean b = this.updateById(goodsupplied);
            map.put("msg", "操作失败");
            map.put("code", "0");
            if (b) {
                map.put("msg", "拒绝通过！！");
                map.put("code", "1");
            }
        }
        return map;
    }

    @Override
    public List<Goodsupplied> queryAllGoodSupplied() {
        List<Goodsupplied> list = this.list();
        for (Goodsupplied goodsupplied : list) {
            //设置用户
            goodsupplied.setUserinfo(userinfoMapper.selectById(goodsupplied.getPId()));
        }
        return list;
    }

    @Override
    public Goodsupplied queryById(Integer shopId) {
        System.out.println(shopId);
        Goodsupplied supply = this.getById(shopId);
        System.out.println(supply.getPId());
        supply.setUserinfo(userinfoMapper.selectById(supply.getPId()));
        supply.setCommodity(commodityMapper.selectById(supply.getGId()));
        return supply;
    }
}
