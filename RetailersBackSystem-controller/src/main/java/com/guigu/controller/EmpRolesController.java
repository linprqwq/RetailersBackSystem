package com.guigu.controller;

import com.guigu.pojo.EmpRoles;
import com.guigu.pojo.SysEmployees;
import com.guigu.service.EmpRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmpRolesController {
    @Autowired
    EmpRolesService empRolesService;

    @PostMapping("addroloemp.action")
    @CrossOrigin
    public Map addroloemp(EmpRoles empRoles, SysEmployees sysEmployees,Integer[] rids){
        for(Integer i : rids){
            System.out.println("i:"+i);
        }
        System.out.println(empRoles);
        System.out.println(sysEmployees);
        return  empRolesService.addemproles(empRoles,sysEmployees,rids);
    }
}
