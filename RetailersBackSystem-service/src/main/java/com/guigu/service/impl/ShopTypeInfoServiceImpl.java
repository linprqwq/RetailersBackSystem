package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.ShopTypeInfoMapper;
import com.guigu.pojo.ShopTypeInfo;
import com.guigu.service.ShopTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ShopTypeInfoServiceImpl extends ServiceImpl<ShopTypeInfoMapper, ShopTypeInfo>
        implements ShopTypeInfoService {

    @Autowired
    ShopTypeInfoMapper shopTypeInfoMapper;

    //查询所有的                        b 商品分类
    @Override
    public List<ShopTypeInfo> queryallshoptype() {

        QueryWrapper<ShopTypeInfo> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("is_delete",0);  //是否删除
        return shopTypeInfoMapper.selectList(queryWrapper);
    }

}
