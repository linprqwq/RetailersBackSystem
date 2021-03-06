package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PurchaseDetailInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
public interface PurchaseDetailInfoService extends IService<PurchaseDetailInfo> {

    Page<PurchaseDetailInfo> queryPurchaseDetails(PurchaseDetailInfo detail, Integer pageno, Integer pagesize);
}
