package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.Orderinfo;
import com.guigu.service.CommodityService;
import com.guigu.service.CommthinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Userinfo;
import com.guigu.service.OrdderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-04-12
 */
@RestController
public class CommthinfoController {
    @Autowired
    CommthinfoService commthinfoService;
    @Autowired
    OrdderdetailsService ordderdetailsService;
    @PostMapping("queryreturnstop.action")
    @CrossOrigin
    //查询商户退货
    public Page<Commthinfo> queryreturnstop(Commthinfo commthinfo, @RequestParam(value = "pageno", defaultValue = "1") int pageno,
                                           @RequestParam(value = "pagesize", defaultValue = "5") int pagesize){
        return commthinfoService.queryreturnstop(commthinfo, pageno, pagesize);
    }


    @PostMapping("queryordd.action")
    @CrossOrigin
    public Ordderdetails queryordd(Ordderdetails ordderdetails){
      return   ordderdetailsService.queryordd(ordderdetails);
    }

    /**
     *
     * @param  commthinfo
     * @param file  新的上传文件
     * @param request  请求对象
     * @return
     * @throws IOException
     */
    @RequestMapping("addgoods.action")
    @CrossOrigin
    public Map<String,String> RegisterUser(Commthinfo commthinfo , MultipartFile[] file, HttpServletRequest request) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < file.length; i++) {
            String path = request.getServletContext().getRealPath("/img"); //路径名
            String name = file[i].getOriginalFilename();  //文件名
            File savefile = new File(path,name);
            file[i].transferTo(savefile);

            list.add("img/"+name);
        }
        if (commthinfo.getImg()==null){
            commthinfo.setImg(list.get(0));
        } if(commthinfo.getImg2()==null){
            commthinfo.setImg2(list.get(1));
        } if(commthinfo.getImg3()==null){
            commthinfo.setImg3(list.get(2));
        }
        //等待审核
        commthinfo.setAudit(0);
        //等待商户确认
        commthinfo.setCommstate(1);
        //状态
        commthinfo.setState(0);
        //退货时间
        //商户id
        commthinfo.setSid(1);
        commthinfo.setThtime(new Date());
        System.out.println(commthinfo);


        return ordderdetailsService.addgoods(commthinfo);
    }


        return commthinfoService.queryreturnstop(commthinfo, pageno, pagesize);
    }
    @PostMapping("uptcommstate.action")
    @CrossOrigin
    //查询商户退货
    public Map uptcommstate(Commthinfo commthinfo){

        return commthinfoService.uptcommstate(commthinfo);
    }
}

