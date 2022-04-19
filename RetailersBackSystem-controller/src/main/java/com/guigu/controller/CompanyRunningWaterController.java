package com.guigu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.CompanyRunningWater;
import com.guigu.service.CompanyRunningWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyRunningWaterController {
@Autowired
    CompanyRunningWaterService companyRunningWaterService;

    @PostMapping("qeruyshys.action")
    @CrossOrigin
    //查询商户退货
    public List<CompanyRunningWater> qeruyshys(CompanyRunningWater companyRunningWater){
        return companyRunningWaterService.qeruyshys(companyRunningWater);
    }
}
