package com.guigu.controller;


import com.guigu.pojo.PurchaseInfo;
import com.guigu.service.PurchaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
@Controller
@RequestMapping("/purchaseInfo")
public class PurchaseInfoController {
    @Autowired
    PurchaseInfoService purchaseInfoService;
    //添加采购单
    @PostMapping("purchase.action")
    public Map addPurchaseInfo(@RequestBody List<PurchaseInfo> purchaseList) {
        return purchaseInfoService.addPurchaseInfo(purchaseList);
    }
}

