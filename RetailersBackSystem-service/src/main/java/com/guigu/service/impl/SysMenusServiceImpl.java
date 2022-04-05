package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.MenuRolerMapper;
import com.guigu.mapper.SysMenusMapper;
import com.guigu.pojo.MenuRole;
import com.guigu.pojo.SysMenus;
import com.guigu.service.SysMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Service
public class SysMenusServiceImpl extends ServiceImpl<SysMenusMapper, SysMenus> implements SysMenusService {

    @Autowired
    MenuRolerMapper menuRolerMapper;
    @Override
    public List<SysMenus> querymenusleft(Integer roleId) {
        //菜单角色关联表
        List<MenuRole> sysMenuRoleList = new ArrayList<MenuRole>();
        QueryWrapper<MenuRole> sysMenuRoleWrapper = new QueryWrapper<MenuRole>();
        sysMenuRoleWrapper.eq("rid", roleId);
        sysMenuRoleList = menuRolerMapper.selectList(sysMenuRoleWrapper);
        System.out.println("该角色有的菜单"+sysMenuRoleList);
        List<SysMenus> list = new ArrayList<SysMenus>();
        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<SysMenus>();
        queryWrapper.eq("PARENT_ID", 0);
        list = this.list(queryWrapper); //获取所有一级的
        //循环一级菜单
        for (SysMenus sysMenus : list) {
            //检查是否有子菜单
            queryWrapper = new QueryWrapper<SysMenus>();
            queryWrapper.eq("PARENT_ID", sysMenus.getId());
            List<SysMenus> list2 = this.list(queryWrapper); //获取所有二级的
            sysMenus.setChildMenu(list2);
            if(list2.size()>0){
                //有子菜单，循环二级菜单
                for(SysMenus sysMenus2 : list2){
                    //检查是否有子菜单
                    queryWrapper = new QueryWrapper<SysMenus>();
                    queryWrapper.eq("PARENT_ID", sysMenus2.getId());
                    List<SysMenus> list3 = this.list(queryWrapper); //获取所有三级的
                    sysMenus2.setChildMenu(list3);
                    if(list3.size()>0){
                        //有子菜单，循环三级菜单
                        for(SysMenus sysMenus3 : list3){
                            for (MenuRole menuRole : sysMenuRoleList) {
                                if (sysMenus3.getId() == menuRole.getMid()) {
                                    sysMenus3.setIscheck(true);
                                    break;
                                }
                            }
                        }
                    }else {
                        //没有子菜单，说明是二级菜单
                        for (MenuRole menuRole : sysMenuRoleList) {
                            if (sysMenus2.getId() == menuRole.getMid()) {
                                sysMenus2.setIscheck(true);
                                break;
                            }
                        }
                    }
                }
            }else{
                //没有子菜单，说明是一级菜单
                for (MenuRole menuRole : sysMenuRoleList) {
                    if (sysMenus.getId() == menuRole.getMid()) {
                        sysMenus.setIscheck(true);
                        break;
                    }
                }
            }
        }
        System.out.println("结果"+list);
        return list;
    }
}
