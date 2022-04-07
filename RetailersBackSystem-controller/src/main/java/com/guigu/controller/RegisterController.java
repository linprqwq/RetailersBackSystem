package com.guigu.controller;

import com.guigu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("/checkusername.action")
    @CrossOrigin
    public int checkusername(String username){
        return registerService.CheckUserName(username);
    }

    @RequestMapping("/checkloginname.action")
    @CrossOrigin
    public int checkloginname(String loginname){
        return registerService.CheckLoginName(loginname);
    }
}
