package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.PurchaseInfo;
import com.guigu.service.PurchaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RequestMapping("/purchaseInfo/")
@RestController
public class PurchaseInfoController {

    @Autowired
    PurchaseInfoService purchaseInfoService;
    //添加采购单
    @PostMapping("addpurchase.action")
    public Map addPurchaseInfo(@RequestBody List<PurchaseInfo> purchaseList) {
        return purchaseInfoService.addPurchaseInfo(purchaseList);
    }
    //审核采购单
    @PutMapping("purchase.action")
    public Map changeIsAudit(@RequestBody PurchaseInfo purchase){
        return purchaseInfoService.changeIsAudit(purchase);
    }
    //分页及所有
    @GetMapping("purchase.action")
    public Page<PurchaseInfo> queryAllPurchase(PurchaseInfo purchase,
                                               @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                               @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return purchaseInfoService.queryAllPurchase(purchase,pageno,pagesize);
    }
}

