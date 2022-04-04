package com.guigu.controller;

import com.guigu.pojo.PageVo;
import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Userinfo login(Userinfo userinfo){
       return userinfoService.userlogin(userinfo);
    }

    @RequestMapping("/selsid.action")
    @CrossOrigin
    public Userinfo selsid(int id) {
        return userinfoService.getById(id);
    }

    @RequestMapping("/updatesh.action")
    @CrossOrigin
    public Map updatesh(Userinfo userinfo) {
        return userinfoService.update(userinfo);
    }

    @RequestMapping("/queryallUser.action")
    @CrossOrigin
    public PageVo<Userinfo> queryallUser(Userinfo userinfo,
                                     @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                     @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return userinfoService.querybyconduser(userinfo, pageno, pagesize);
    }
    @RequestMapping("/queryallUser2.action")
    @CrossOrigin
    public PageVo<Userinfo> queryallUser2(Userinfo userinfo,
                                     @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                     @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return userinfoService.querybyconduser2(userinfo, pageno, pagesize);
    }
    @RequestMapping("/queryallGysJl.action")
    @CrossOrigin
    public PageVo<Userinfo> queryallGysJl(Userinfo userinfo,
                                     @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                     @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return userinfoService.queryallGysJl(userinfo, pageno, pagesize);
    }
    @PutMapping("/updstatetg.action")
    @CrossOrigin
    public Map updstate(@RequestBody Userinfo userinfo) {
        System.out.println(userinfo);
        return userinfoService.updstate(userinfo);
    }
    @PutMapping("/updstatebtg.action")
    @CrossOrigin
    public Map updstatebtg(@RequestBody Userinfo userinfo) {
        return userinfoService.updstatebtg(userinfo);
    }


    //统计用户购物车数量
    @RequestMapping("/cartcount.action")
    @CrossOrigin
    public int CartCount(Integer id) {
        return userinfoService.CartCount(id);
    }
}
