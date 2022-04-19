package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.WarehouseClassificationMapper;
import com.guigu.mapper.WarehouseInfoMapper;
import com.guigu.pojo.WarehouseClassification;
import com.guigu.pojo.WarehouseDetailsInfo;
import com.guigu.pojo.WarehouseInfo;
import com.guigu.service.WarehouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
@Service
public class WarehouseInfoServiceImpl extends ServiceImpl<WarehouseInfoMapper, WarehouseInfo> implements WarehouseInfoService {

    @Autowired
    WarehouseInfoMapper warehouseInfoMapper;
    @Autowired
    WarehouseClassificationMapper warehouseClassificationMapper;
    @Override
    public Page<WarehouseInfo> queryallck(WarehouseInfo warehouseInfo, Integer pageno, Integer pagesize) {

        QueryWrapper queryWrapper = new QueryWrapper();

        if (StringUtils.isNotEmpty(warehouseInfo.getWarName())){
            queryWrapper.like("war_name",warehouseInfo.getWarName());
        }
        return  this.page(new Page<WarehouseInfo>(pageno,pagesize), queryWrapper);
    }

    @Override
    public Map<String, String> cxwhouse(WarehouseInfo warehouseInfo) {
        Map<String, String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","仓库名不为空");
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("war_name",warehouseInfo.getWarName());
        WarehouseInfo warehouseInfo1 = warehouseInfoMapper.selectOne(queryWrapper);
        if (warehouseInfo1!=null){
            map.put("code","1");
            map.put("msg","仓库名重复");
        }
        return map;
    }

    //添加仓库
    @Override
    public Map<String, String> tjck(WarehouseInfo warehouseInfo, int[] arr) {
        System.out.println(warehouseInfo);
        warehouseInfo.setIsCheck(0);
        warehouseInfo.setIsDelete(0);
        Map<String, String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","添加失败");
        int s = 0;
        int a = warehouseInfoMapper.insert(warehouseInfo);
       //添加成功   循环添仓库商品分类表
       if (a>=1){
           for (int i : arr) {
               WarehouseClassification warehouseClassification = new WarehouseClassification();
               //仓库id
               warehouseClassification.setPId(warehouseInfo.getId());
               //商品分类id
               warehouseClassification.setShopClassId(i);
               s =  warehouseClassificationMapper.insert(warehouseClassification);
           }
           if (s>=1){
               map.put("code","1");
               map.put("msg","新增仓库成功");
           }
       }

        return map;
    }
}
