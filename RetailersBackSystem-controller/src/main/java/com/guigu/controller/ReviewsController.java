package com.guigu.controller;


import com.guigu.pojo.Reviews;
import com.guigu.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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

}

