package com.guigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.pojo.MenuRole;
import com.guigu.pojo.SysMenus;
import com.guigu.service.MenuRoleService;
import com.guigu.service.SysMenusService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthcController {
    @Autowired
    SysMenusService sysMenusService;
    @Autowired
    MenuRoleService menuRoleService;
    //权限页面
    @GetMapping("querymenuforleft.action/{roleId}")
    @CrossOrigin
    public List<SysMenus> showauthc(@PathVariable Integer roleId) throws ServletException, IOException {
             System.out.println(roleId);
        return sysMenusService.querymenusleft(roleId);
    }
    @RequestMapping("setauthc.action")
    @CrossOrigin
    public boolean setauthc(String menuId,Integer roleId){

        String[] mids = menuId.split(",");

        //防止权限表有重复数据，先根据角色id，将
        //权限表中相同角色id的数据全部删除，然后在批量添加
        QueryWrapper<MenuRole> queryWrapper = new QueryWrapper<MenuRole>();
        queryWrapper.eq("rid",roleId);
        menuRoleService.remove(queryWrapper);
        boolean res = false;
        //组装权限表数据  多条  放入集合中
        List<MenuRole> list = new ArrayList<MenuRole>();
        if(mids!=null) {
            for (String mid : mids) {
                //循环每一个菜单id，组装一个权限表数据
                MenuRole menuRole = new MenuRole(Integer.parseInt(mid),roleId);

                list.add(menuRole);
            }
            //批量操作  dao.add(List<MenuRoleInfo>  list)
            res = menuRoleService.saveBatch(list);
        }
        return res;
    }
}
