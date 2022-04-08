package com.guigu.controller;

import com.guigu.pojo.Orderinfo;
import com.guigu.pojo.Provinces;
import com.guigu.service.OrderinfoService;
import com.guigu.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProvincesController {
    @Autowired
    ProvincesService provincesService;
    @RequestMapping("queryAllChina.action")
    @CrossOrigin
    public List<Provinces> queryAllChina(Provinces provinces){

        return provincesService.queryAllChina(provinces);
    }
    @RequestMapping("queryChinaByPid.action")
    @CrossOrigin
    public List<Provinces> queryChinaByPid(Provinces provinces){

        return provincesService.queryChinaByPid(provinces);
    }
    @RequestMapping("queryChinaByshi.action")
    @CrossOrigin
    public List<Provinces> queryChinaByshi(Provinces provinces){

        return provincesService.queryChinaByshi(provinces);
    }
}
