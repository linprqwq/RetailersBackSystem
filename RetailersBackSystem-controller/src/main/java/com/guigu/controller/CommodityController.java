package com.guigu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Commodity;
import com.guigu.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @RequestMapping("/queryspid.action")
    @CrossOrigin
    //查询商品id
    public Commodity querycommodityid(Integer id){
        System.out.println(id);
        return commodityService.querycommodityid(id);
    }


    @GetMapping("queryCommids.action")
    @CrossOrigin
    //查询商品id
    public List<Commodity> queryCommids(String cids){
        String[] ids = cids.split(",");
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<Commodity>();
        List<Commodity> list1=new ArrayList<Commodity>();
        queryWrapper.in("id",ids);
        list1 = commodityService.list(queryWrapper);
        return list1;
    }

    @RequestMapping("queryAllcom.action")
    @CrossOrigin
    //查询所有水果
    public List<Commodity>QueryAllCommodity(){

        return commodityService.QueryAllCommodity();
    }
    @PostMapping("queryAllCommodity.action")
    @CrossOrigin
    //查询所有
    public Page<Commodity> QueryAllCommoditybycond(Commodity commodity,
                                                   @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                                   @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize){
        return commodityService.page(new Page<Commodity>(pageno,pagesize));
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
