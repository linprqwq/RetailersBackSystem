package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.*;
import com.guigu.pojo.*;
import com.guigu.service.WarehouseDetailsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
@Service
public class WarehouseDetailsInfoServiceImpl extends ServiceImpl<WarehouseDetailsInfoMapper, WarehouseDetailsInfo> implements WarehouseDetailsInfoService {

    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    WarehouseInfoMapper warehouseInfoMapper;
    @Autowired
    WarehouseDetailsInfoMapper warehouseDetailsInfoMapper;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    ShopTypeInfoMapper shopTypeInfoMapper;

    @Override
    public Page<WarehouseDetailsInfo> querywaredetails(WarehouseDetailsInfo warehouseDetailsInfo, Integer pageno, Integer pagesize) {

        //根据仓库id 去仓库详情查询 根据仓库详情商品id 去商品表查询商品数据
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("p_id", warehouseDetailsInfo.getPId());
        Page<WarehouseDetailsInfo> page = this.page(new Page<WarehouseDetailsInfo>(pageno, pagesize), queryWrapper);

        for (WarehouseDetailsInfo record : page.getRecords()) {

            //查询商品
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("id", record.getShopId());
            Commodity commodity = commodityMapper.selectOne(queryWrapper1);

            //查询商品类别
            QueryWrapper queryWrapper3 = new QueryWrapper();
            queryWrapper3.eq("id",commodity.getShopType());
            ShopTypeInfo shopTypeInfo = shopTypeInfoMapper.selectOne(queryWrapper3);
            commodity.setShopTypeInfo(shopTypeInfo);
            //实体类set值
            record.setCommodity(commodity);

            //查询供应商
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("ID",record.getUId());

            Userinfo userinfo = userinfoMapper.selectOne(queryWrapper2);
            record.setUserinfo(userinfo);



        }
        return page;
    }
}
