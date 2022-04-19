package com.guigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.pojo.Userinfo;
import com.guigu.service.EmploService;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class EmployeeController {
    @Autowired
    EmploService emploService;

    @RequestMapping("/sysemplogin.action")
    @CrossOrigin
    public SysEmployees sysemplogin(SysEmployees sysEmployees,HttpServletRequest request){
        QueryWrapper<SysEmployees> queryWrapper=new QueryWrapper<>();
        System.out.println(sysEmployees);
        queryWrapper.eq("emp_loginname",sysEmployees.getEmpLoginname());
        queryWrapper.eq("emp_password",sysEmployees.getEmpPassword());
        SysEmployees sysEmployees1=emploService.getOne(queryWrapper);
        if(sysEmployees1!=null){
            request.getSession().setAttribute("emp",sysEmployees1);
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
    @GetMapping("/queryempbyid.action/{id}")
    @CrossOrigin
    public SysEmployees queryempbyid(@PathVariable Integer id){
        return emploService.getById(id);

    }
}
