package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.PurchaseInfoMapper;
import com.guigu.pojo.PurchaseDetailInfo;
import com.guigu.pojo.PurchaseInfo;
import com.guigu.service.PurchaseInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
@Service
public class PurchaseInfoServiceImpl extends ServiceImpl<PurchaseInfoMapper, PurchaseInfo> implements PurchaseInfoService {

    @Override
    public Map addPurchaseInfo(List<PurchaseInfo> purchaseList) {
       /* Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "创建失败");
        for (PurchaseInfo purchaseInfo : purchaseList) {
            purchaseInfo.setBuyNumber(myIdAdd.idadd("200",true));
            purchaseInfo.setPtime(new Date()); //设置时间
            purchaseInfo.setIsAudit(0); //设置未审核
            purchaseInfo.setIsDesign(0); //设置未设计
            purchaseInfo.setIsShipments(0); //设置未发货
            purchaseInfo.setIsDelete(0); //设置未删除
            Integer totalNum = 0; //总数量
            Double totalMoney = 0.0; //总金额
            boolean save = this.save(purchaseInfo);
            //采购添加后添加详情表
            if (save){
                for (PurchaseDetailInfo purchaseDetail : purchaseInfo.getPurchaseDetails()) {
                    //设置详情表的父id
                    purchaseDetail.setPid(purchaseInfo.getId());
                    //根据供应商维护表id查询维护信息
                    SupplierSupplyOfGoods supply = supplyService.queryById(purchaseDetail.getSupplyOrderId());
                    //设置采购详情表单价
                    purchaseDetail.setShopPrice(supply.getSupplierPrice());
                    //设置采购详情表总价
                    purchaseDetail.setTotalPrice(purchaseDetail.getShopNum()*purchaseDetail.getShopPrice());
                    //设置未删除状态
                    purchaseDetail.setIsDelete(0);
                    //设置设计状态
                    purchaseDetail.setIsDesign(0);
                    //保存
                    purchaseDetailMapper.insert(purchaseDetail);
                    totalNum += purchaseDetail.getShopNum();
                    totalMoney += purchaseDetail.getShopNum() * supply.getSupplierPrice();
                }
            }
            purchaseInfo.setTotalNum(totalNum);
            purchaseInfo.setTotalMoney(totalMoney);
            //通过修改设置总数量和总价格
            boolean b = this.updateById(purchaseInfo);
            if (b){
                map.put("code",1);
                map.put("msg","创建订单成功");
            }
        }*/
        return null;
    }
}
