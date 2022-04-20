package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.GatherDetailInfoMapper;
import com.guigu.mapper.GatherInfoMapper;
import com.guigu.mapper.PurchaseDetailInfoMapper;
import com.guigu.mapper.PurchaseInfoMapper;
import com.guigu.pojo.GatherDetailInfo;
import com.guigu.pojo.GatherInfo;
import com.guigu.pojo.PurchaseDetailInfo;
import com.guigu.pojo.PurchaseInfo;
import com.guigu.service.GatherInfoService;
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
 * @since 2022-04-18
 */
@Service
public class GatherInfoServiceImpl extends ServiceImpl<GatherInfoMapper, GatherInfo> implements GatherInfoService {

    @Autowired
    GatherInfoMapper gatherInfoMapper;
    @Autowired
    PurchaseInfoMapper purchaseInfoMapper;
    @Autowired
    PurchaseDetailInfoMapper purchaseDetailInfoMapper;
    @Autowired
    GatherDetailInfoMapper gatherDetailInfoMapper;
    @Override
    public Map addGatherInfoandDetailPurchaseInfo(Integer id) {
        //根据采购单id，获取采购表对象和详情数据
        PurchaseInfo purchaseInfo=purchaseInfoMapper.selectById(id);
        QueryWrapper queryWrapper=new QueryWrapper<PurchaseDetailInfo>();
        queryWrapper.eq("pid",purchaseInfo.getId());
        purchaseInfo.setPurchaseDetailInfoList(purchaseDetailInfoMapper.selectList(queryWrapper));
        //入库对象
        GatherInfo gatherInfo=new GatherInfo();
        //采购理由：采购入库
        gatherInfo.setGatherType(0);
        //查询号：存放采购单
        gatherInfo.setTrackingNumber(purchaseInfo.getBuyNumber());
        //入库时间：当前时间
        gatherInfo.setGtime(new Date());
        //审核状态：等待审核
        gatherInfo.setIsCheck(0);
        //详情表是否全部指定了仓库：未全部指定
        gatherInfo.setAllSpecified(0);
        //删除状态：正常
        gatherInfo.setIsDelete(0);
        //进行添加
        Map map=new HashMap<String,Object>();
        if(gatherInfoMapper.insert(gatherInfo)>0){
            //循环采购详情表添加入库详情表数据
            for(PurchaseDetailInfo p : purchaseInfo.getPurchaseDetailInfoList()){
                GatherDetailInfo gatherDetailInfo=new GatherDetailInfo();
                gatherDetailInfo.setGatherId(gatherInfo.getId());
                gatherDetailInfo.setWarId(null);
                gatherDetailInfo.setSupplyOrderid(p.getShopId());
                gatherDetailInfo.setShopNum(p.getShopNum());
                gatherDetailInfo.setIsDelete(0);
                //进行添加入库详情数据
                gatherDetailInfoMapper.insert(gatherDetailInfo);
            }
            //修改采购单的设计状态设置为已设计
            UpdateWrapper updateWrapper =new UpdateWrapper<PurchaseInfo>();
            updateWrapper.eq("id",purchaseInfo.getId());
            updateWrapper.set("is_design",1);
            purchaseInfoMapper.update(new PurchaseInfo(),updateWrapper);
            map.put("msg","开始对该采购单指定仓库");
            map.put("x",true);
        }else {
            map.put("msg","操作错误");
            map.put("x",false);
        }
        return map;
    }
}
