package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.EmpRole;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.pojo.SysRoles;
import com.guigu.service.EmpRolerService;
import com.guigu.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    @GetMapping("querysysrole.action")
    @CrossOrigin
    public PageVo<SysRoles> querysysroles(SysRoles sysRoles,
                                          @RequestParam(value = "pageno", defaultValue = "1")Integer pageno,
                                          @RequestParam(value = "pagesize", defaultValue = "5")Integer pagesize){
        System.out.println(sysRolesService.querysyroles(sysRoles,pageno,pagesize));
        return sysRolesService.querysyroles(sysRoles,pageno,pagesize);
    }
    @PostMapping("addsysrole.action")
    @CrossOrigin
    public Map addsysrole(SysRoles sysRoles){
        return sysRolesService.addsysrole(sysRoles);
    }
    @RequestMapping("quersysrolebyid.action/{id}")
    @CrossOrigin
    public SysRoles quersysrolebyid(@PathVariable int id, HttpServletRequest request){

        return sysRolesService.querysysrolebyid(id);
    }
    @PostMapping("updatasysrole.action")
    @CrossOrigin
    public Map updatasysrole(SysRoles sysRoles){
        return sysRolesService.updatasysrole(sysRoles);
    }
    @PostMapping("/deletesysrole.action/{id}")
    @CrossOrigin
    public Map deletesysrole(@PathVariable int id) {
        return sysRolesService.deletesysrole(id);

    }
}

