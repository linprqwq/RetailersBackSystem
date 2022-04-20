package com.guigu.controller;


import com.guigu.service.GatherDetailInfoService;
import com.guigu.service.GatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
@RestController
@RequestMapping("/gatherDetailInfo")
public class GatherDetailInfoController {
    @Autowired
    GatherDetailInfoService gatherDetailInfoService;

}

