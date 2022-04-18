package com.guigu.controller;


import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysMenus;
import com.guigu.pojo.SysRoles;
import com.guigu.service.SysMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
public class SysMenusController {
    @Autowired
    SysMenusService sysMenusService;
    @GetMapping("querysysmenus.action")
    @CrossOrigin
    public PageVo<SysMenus> querysysmenus(SysMenus sysMenus,
                                          @RequestParam(value = "pageno", defaultValue = "1")Integer pageno,
                                          @RequestParam(value = "pagesize", defaultValue = "5")Integer pagesize){
        System.out.println(sysMenus);

        return sysMenusService.querysysmenus(sysMenus,pageno,pagesize);
    }
    @PostMapping("addsymenus.action")
    @CrossOrigin
    public Map addsymenus(SysMenus sysMenus){
        return sysMenusService.addsysysmenus(sysMenus);
    }
    @RequestMapping("quersysmenusbyid.action/{id}")
    @CrossOrigin
    public SysMenus quersysmenusbyid(@PathVariable int id, HttpServletRequest request){

        return sysMenusService.querysysmenusbyid(id);
    }
    @PostMapping("updatasysmenus.action")
    @CrossOrigin
    public Map updatasysmenus(@RequestBody SysMenus sysMenus){

        return sysMenusService.updatasysmenus(sysMenus);
    }
    @PostMapping("/deletesysmenus.action/{id}")
    @CrossOrigin
    public Map deletesysmenus(@PathVariable int id) {
        return sysMenusService.deletesysmenus(id);

    }

}

