package com.guigu.controller;

import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.util.Map;

@RestController

public class UserinfoController {

    @Autowired
    UserinfoService userinfoService;

    @RequestMapping("/login.action")
    @CrossOrigin
    //用户登录
    public int login(Userinfo userinfo){
        int i=0;
        Userinfo userinfo1=userinfoService.userlogin(userinfo);
        if(userinfo1!=null){
            i=1;
        }
        return i;
    }
    @RequestMapping("/selsid.action")
    @CrossOrigin
    public Userinfo selsid(int id){
        return userinfoService.getById(id);
    }
    @RequestMapping("/updatesh.action")
    @CrossOrigin
    public Map updatesh(Userinfo userinfo){
        return userinfoService.update(userinfo);
    }
}
