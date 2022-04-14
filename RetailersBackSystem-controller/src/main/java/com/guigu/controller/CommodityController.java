package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Commodity;
import com.guigu.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class CommodityController {

    @Autowired
    CommodityService commodityService;


    //添加商品
    @PostMapping("addsp.action")
    @CrossOrigin
    public  Map add(Commodity commodity,
                    MultipartFile image,
                    HttpServletRequest request){

        return  commodityService.addsp(commodity,image,request.getServletContext().getRealPath("/image/"));
    }




    //分页查询
    @GetMapping("/querysp.action")
    @CrossOrigin
    public Page<Commodity> querysp(Commodity commodity,
                                   @RequestParam(value="pageno",defaultValue = "1")Integer pageno,
                                   @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize){


        return  commodityService.queryAllshop(commodity,pageno,pagesize);
    }

    @GetMapping("queryspid.action")
    @CrossOrigin
    //查询商品id
    public Commodity querycommodityid(Integer id){
        System.out.println(id);
        return commodityService.querycommodityid(id);
    }

    @RequestMapping("queryAllcom.action")
    @CrossOrigin
    //查询所有水果
    public List<Commodity>QueryAllCommodity(){

        return commodityService.QueryAllCommodity();
    }


    @RequestMapping("queryAllcomhs.action")
    @CrossOrigin
    //查询所有海鲜
    public List<Commodity>QueryAllCommodityHS(){
        return commodityService.QueryAllCommodityHS();
    }


    @RequestMapping("queryAllcomrl.action")
    @CrossOrigin
    //查询所有海鲜
    public List<Commodity>QueryAllCommodityRL(){
        return commodityService.QueryAllCommodityRL();
    }
}
