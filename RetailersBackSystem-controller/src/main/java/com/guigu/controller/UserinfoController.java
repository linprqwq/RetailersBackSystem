package com.guigu.controller;

import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserinfoController {
    @Autowired
    UserinfoService userinfoService;

    @RequestMapping("/login.action")
    public int login(Userinfo userinfo, HttpServletRequest request){
        int i=0;
        Userinfo userinfo1=userinfoService.userlogin(userinfo);
        HttpSession session=request.getSession();
        session.setAttribute("userinfo1",userinfo1);
        if(userinfo1!=null){
            i=1;
        }
        return i;
    }
}
