package com.guigu.controller;


import com.guigu.service.GatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
@RestController
@RequestMapping("/gatherInfo")
@CrossOrigin
public class GatherInfoController {
    @Autowired
    GatherInfoService gatherInfoService;
    @GetMapping("addGatherInfoandDetailPurchaseInfo.action/{id}")
    public Map addGatherInfoandDetailPurchaseInfo(@PathVariable Integer id){
        return gatherInfoService.addGatherInfoandDetailPurchaseInfo(id);
    }
}

