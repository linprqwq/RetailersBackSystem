package com.guigu.controller;

import com.guigu.pojo.SysMenus;
import com.guigu.service.SysMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@RestController
public class AuthcController {
    @Autowired
    SysMenusService sysMenusService;
    //权限页面
    @GetMapping("querymenuforleft.action/{roleId}")
    @CrossOrigin
    public List<SysMenus> showauthc(@PathVariable Integer roleId) throws ServletException, IOException {
        return sysMenusService.querymenusleft(roleId);

    }
}
