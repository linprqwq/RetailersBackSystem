package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.PurchaseDetailInfoMapper;
import com.guigu.pojo.PurchaseDetailInfo;
import com.guigu.service.GoodsuppliedService;
import com.guigu.service.PurchaseDetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
@Service
public class PurchaseDetailInfoServiceImpl extends ServiceImpl<PurchaseDetailInfoMapper, PurchaseDetailInfo> implements PurchaseDetailInfoService {

    @Autowired
    GoodsuppliedService goodsuppliedService;//供应商维护商品表Service
    @Override
    public Page<PurchaseDetailInfo> queryPurchaseDetails(PurchaseDetailInfo detail, Integer pageno, Integer pagesize) {
        QueryWrapper<PurchaseDetailInfo> queryWrapper=
                new QueryWrapper<PurchaseDetailInfo>();
        if (detail.getPid()!=null){
            queryWrapper.eq("pid",detail.getPid());
        }
        Page<PurchaseDetailInfo> page = this.page(new Page<PurchaseDetailInfo>(pageno, pagesize),queryWrapper);
        for (PurchaseDetailInfo pd : page.getRecords()) {
            //设置供应商维护表
            pd.setGoodsupplied(goodsuppliedService.queryById(pd.getShopId()));
        }
        return page;
    }
}
