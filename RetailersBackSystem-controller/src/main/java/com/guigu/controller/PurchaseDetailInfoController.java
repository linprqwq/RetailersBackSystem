package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.PurchaseDetailInfo;
import com.guigu.service.PurchaseDetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
@RestController
@RequestMapping("/purchaseDetailInfo")
@CrossOrigin
public class PurchaseDetailInfoController {

    @Autowired
    PurchaseDetailInfoService purchaseDetailService;
    //根据采购单id查询采购详情
    @GetMapping("purchaseDetail.action")
    public Page<PurchaseDetailInfo> queryPurchaseDetails(PurchaseDetailInfo detail,
                                                         @RequestParam(value = "pageno",defaultValue = "1")Integer pageno,
                                                         @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize){
        return purchaseDetailService.queryPurchaseDetails(detail,pageno,pagesize);
    }
}

