package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.guigu.mapper.ShopTypeInfoMapper;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.ShopTypeInfo;
import com.guigu.service.CommodityService;
import com.guigu.service.ShopTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopTypeInfoServiceImpl extends ServiceImpl<ShopTypeInfoMapper, ShopTypeInfo>
        implements ShopTypeInfoService {

    @Autowired
    ShopTypeInfoMapper shopTypeInfoMapper;

    @Autowired
    CommodityService commodityService;

    //查询所有的                        b 商品分类
    @Override
    public List<ShopTypeInfo> queryallshoptype() {

        QueryWrapper<ShopTypeInfo> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("is_delete",0);  //是否删除
        return shopTypeInfoMapper.selectList(queryWrapper);
    }



//分页查询商品分类
    @Override
    public Page<ShopTypeInfo> queryfyshop(ShopTypeInfo shopTypeInfo, Integer pageno, Integer pagesize) {
       //条件查询
        QueryWrapper<ShopTypeInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("is_delete",0);

        if(StringUtil.isNotEmpty(shopTypeInfo.getName())){
                queryWrapper.like("name",shopTypeInfo.getName());
        }

        Page<ShopTypeInfo> page=this.page(new Page<ShopTypeInfo>(pageno,pagesize),queryWrapper);

        return page;
    }


    //新增新的商品分类
    @Override
    public Map addsp(ShopTypeInfo shopTypeInfo) {
        Map map=new HashMap();
        map.put("code","0");
        map.put("code","添加失败");
        shopTypeInfo.setIsDelete(1);
        boolean b=this.save(shopTypeInfo);
        if(b){
            map.put("code","1");
            map.put("msg","添加成功");
        }
        return map;
    }

    @Override
    public Map delshopid(Integer id) {
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","删除成功");
        //删除前要看是否商品有这个分类
            QueryWrapper<Commodity> queryWrapper=
                    new QueryWrapper<Commodity>();
            queryWrapper.eq("shop_type",id);
            List<Commodity> list=commodityService.list(queryWrapper);

            if(list.size()>0){
                    map.put("msg","还有商品使用此分类");
            }else{
                        ShopTypeInfo shopTypeInfo=new ShopTypeInfo();
                        shopTypeInfo.setId(id);
                        shopTypeInfo.setIsDelete(1);
            boolean b=this.updateById(shopTypeInfo);
                if(b){
                    map.put("code","1");
                    map.put("msg","删除成功");
                }

            }

        return map;
    }

    //根据id查询
    @Override
    public ShopTypeInfo selectid(Integer id) {
        return this.getById(id);
    }

    //编辑
    @Override
    public Map updatashop(ShopTypeInfo shopTypeInfo) {

        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","修改失败");
        boolean b=this.updateById(shopTypeInfo);
        if(b){
            map.put("code","0");
            map.put("msg","修改成功");
        }
        return map;
    }

    @Override
    public List<String> getIds(String str) {
        return null;
    }

}
