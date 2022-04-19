package com.guigu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.guigu.mapper.CommodityMapper;
import com.guigu.mapper.ShopTypeInfoMapper;
import com.guigu.mapper.SupplierGoodsCategoryMapper;
import com.guigu.pojo.*;
import com.guigu.service.CommodityService;
import com.guigu.service.ShopTypeInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    SupplierGoodsCategoryMapper supplierGoodsCategoryMapper;

    @Autowired
    ShopTypeInfoMapper shopTypeInfoMapper;
    @Autowired
    ShopTypeInfoService shopTypeInfoService;


    //去添加商品
    @Override
    public Map addsp(Commodity commodity, MultipartFile imgs, String appth) {

        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","添加失败");
        //去设置默认值
        commodity.setQuantity(0);
        commodity.setCreatetime(new Date());
        commodity.setIsDelete(0);
        //添加图片
        if(imgs!=null && imgs.getSize()>0){
            File file=new File(appth);
            if(!file.exists()){
                    //不存在就去创建
                file.mkdirs();
            }
        }
        //去获取文件名称
        String fileName = imgs.getOriginalFilename();
        //去保存文件到路径
        try {
            imgs.transferTo(new File(appth, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
            //去将路径设置到对象
        commodity.setProzimg("/image/" + fileName);

        boolean b=this.save(commodity);
        map.put("code", 1);
        map.put("msg", "添加成功");

        return map;
    }

    //修改状态 上架和下架
    @Override
    public Map xgstatus(Commodity commodity) {
        Map map=new HashMap();
        map.put("code",0);
        if(commodity.getStatus()==1){
            //下架
                map.put("msg","下架失败");
                commodity.setQuantity(0);
                boolean b=this.updateById(commodity);
                if(b){
                    map.put("code","1");
                    map.put("msg","下架成功");
                }
        }else{
            //上架检查商品商品库存是否存在商品数量
            map.put("code","上架失败");
                boolean b=this.updateById(commodity);
                    if(b){
                        map.put("code",1);
                        map.put("msg","上架成功");
                    }
        }
        return map;
    }

    @Override
    public Map delid(Commodity commodity) {

        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","删除失败");
        boolean num=this.updateById(commodity);
        if(num){
            map.put("code",1);
            map.put("msg","删除成功");
        }

        return  map;
    }

    @Override
    //去根据id去查询商品
    public Commodity querycommodityid( Integer id) {

        return commodityMapper.selectById(id);
    }
    //根据id查找到商品后 去编辑商品
    @Override
    public Map editsp(Commodity commodity, MultipartFile imgs, String appth) {
       /*
            Map map=new HashMap();
            map.put("code",0);
            map.put("msg","修改成功");
            boolean b=this.updateById(commodity);
            //图片修改
            if(b){
                if(imgs!=null && imgs.getSize()>0){
                    File file=new File(appth);
                    if(!file.exists()){
                        //不存在就去创建
                        file.mkdirs();
                    }
                }
                //去获取文件名称
                String fileName = imgs.getOriginalFilename();
                //去保存文件到路径
                try {
                    imgs.transferTo(new File(appth, fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //去将路径设置到对象
                commodity.setProzimg("/image/" + fileName);
                map.put("code", 1);
                map.put("msg", "编辑成功");
            }
*/
        return null;
    }

    //查询所有商品分页
    @Override
    public Page<Commodity> queryAllshop(Commodity commodity, Integer pageno, Integer pagesize) {
      //条件查询
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<Commodity>();
        queryWrapper.eq("is_delete",0);
        //判断是否为空
        if(StringUtil.isNotEmpty(commodity.getProname())){
            queryWrapper.like("proname",commodity.getProname());
        }
        Page<Commodity> page=this.page(new Page<Commodity>(pageno,pagesize),queryWrapper);

        //查找商品类型
        for(Commodity commodity1:page.getRecords()){
            commodity1.setShopTypeInfo(shopTypeInfoService.getById(commodity1.getShopType()));
        }
        return page;
    }



    //查询所有商品
    public List<Commodity> QueryAllCommodity(){

        return commodityMapper.QueryAllCommodity();
    }

    @Override
    public List<Commodity> QueryAllCommodityHS() {

        return commodityMapper.QueryAllCommodityHS();
    }

    @Override
    public List<Commodity> QueryAllCommodityRL() {
        return commodityMapper.QueryAllCommodityRL();
    }

    @Override
    public Page<Commodity> QueryAllcommoditybycond(Commodity commodity, Integer pageno, Integer pagesize) {
        QueryWrapper<Commodity> queryWrapper= new QueryWrapper<Commodity>();
        Page<Commodity> page=this.page(new Page<Commodity>(pageno,pagesize),queryWrapper);

        //循环集合  添加对象，补全属性
        for(Commodity commodity1:page.getRecords()){
            //添加商品分类
            commodity1.setShopTypeInfo(shopTypeInfoMapper.selectById(commodity1.getShopType()));
        }
        return  page;
    }
}
