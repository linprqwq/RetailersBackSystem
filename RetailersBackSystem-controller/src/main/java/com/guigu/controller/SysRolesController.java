package com.guigu.controller;


import com.guigu.pojo.EmpRole;
import com.guigu.pojo.SysRoles;
import com.guigu.service.EmpRolerService;
import com.guigu.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@RestController
public class SysRolesController {
    @Autowired
    SysRolesService sysRolesService;
    @Autowired
    EmpRolerService empRolerService;

    @RequestMapping("queryroleoption.action")
    @CrossOrigin
    public List<SysRoles> queryroleoption(){
        return sysRolesService.list();
    }
}

