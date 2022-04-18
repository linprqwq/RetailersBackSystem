package com.guigu.service;

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

    Map addPurchaseInfo(List<PurchaseInfo> purchaseList);
}
