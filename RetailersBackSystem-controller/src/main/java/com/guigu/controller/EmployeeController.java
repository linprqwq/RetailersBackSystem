package com.guigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.pojo.Userinfo;
import com.guigu.service.EmploService;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class EmployeeController {
    @Autowired
    EmploService emploService;

    @RequestMapping("/sysemplogin.action")
    @CrossOrigin
    public SysEmployees sysemplogin(SysEmployees sysEmployees){
        QueryWrapper<SysEmployees> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("emp_loginname",sysEmployees.getEmpLoginname());
        queryWrapper.eq("emp_password",sysEmployees.getEmpPassword());
        SysEmployees sysEmployees1=emploService.getOne(queryWrapper);
        if(sysEmployees1!=null){
            return sysEmployees1;
        }
        else{
            return null;
        }

    }
    @RequestMapping("/queryallsysemp.action")
    @CrossOrigin
    public PageVo<SysEmployees> queryallsysemp(SysEmployees sysEmployees,
                                               @RequestParam(value = "pageno",defaultValue = "1") Integer pageno,
                                               @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize){
        return emploService.querysysemp(sysEmployees,pageno,pagesize);

    }
}
