package com.guigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.pojo.EmpRole;
import com.guigu.pojo.SysMenus;
import com.guigu.service.EmpRolerService;
import com.guigu.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuInfoController {
    @Autowired
    MenuInfoService menuInfoService;
    @Autowired
    EmpRolerService empRolerService;

    @RequestMapping("querymenuspidandrid.action")
    @CrossOrigin
    public List<SysMenus> querymenusbypidandrid(){

        QueryWrapper<EmpRole> queryWrapper= new QueryWrapper<EmpRole>();
        queryWrapper.eq("eid",1);
        EmpRole empRole=empRolerService.getOne(queryWrapper);
        //获取所有菜单数据
        List<SysMenus> list = menuInfoService.querymenusbyrid(0,empRole.getRid());

        return list;
    }
}
