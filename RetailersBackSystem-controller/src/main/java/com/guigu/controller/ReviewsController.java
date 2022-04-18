package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Reviews;
import com.guigu.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@RestController
public class ReviewsController {

    @Autowired
    ReviewsService reviewsService;

    @RequestMapping("orderpj.action")
    @CrossOrigin
    public Map<String,String> orderpj(Reviews reviews)
    {
        return reviewsService.orderpj(reviews);
    }

    //评论查询
    @RequestMapping("plallbyid.action")
    @CrossOrigin
    public Page<Reviews> plallbyid(Reviews reviews,@RequestParam(value="pageno",defaultValue = "1")Integer pageno,
                                   @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize){
        return reviewsService.plallbyid(reviews,pageno,pagesize);
    }

}

