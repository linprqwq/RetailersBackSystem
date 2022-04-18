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



    @RequestMapping("queryAllSheng.action")
    @CrossOrigin
    public List<Provinces> queryAllSheng(Provinces provinces){
        return provincesService.queryAllSheng(provinces);
    }


    @RequestMapping("queryChinaByShi.action")
    @CrossOrigin
    public List<Provinces> queryChinaByShi(String id){
        return provincesService.queryChinaByShi(id);
    }

    @RequestMapping("queryChinaByQu.action")
    @CrossOrigin
    public List<Provinces> queryChinaByQu(String id){
        return provincesService.queryChinaByQu(id);
    }
}
