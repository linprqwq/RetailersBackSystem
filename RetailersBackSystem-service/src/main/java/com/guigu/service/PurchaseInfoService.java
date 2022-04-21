package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PurchaseInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
public interface PurchaseInfoService extends IService<PurchaseInfo> {


    //查询供应订单
    Page<PurchaseInfo> selectgyorder(PurchaseInfo purchaseInfo,Integer pageno,Integer pagesize);

    Map addPurchaseInfo(List<PurchaseInfo> purchaseList);

    List<String> getIds(String str);

    Page<PurchaseInfo> queryAllPurchase(PurchaseInfo purchase, Integer pageno, Integer pagesize);

    Map changeIsAudit(PurchaseInfo purchase);
}
