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

import java.util.ArrayList;
import java.util.List;

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

        List<SysMenus> list = new ArrayList<SysMenus>();

        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<SysMenus>();
        queryWrapper.eq("PARENT_ID", 0);

        list = this.list(queryWrapper); //获取所有一级的
        for (SysMenus sysMenus : list) {
            queryWrapper = new QueryWrapper<SysMenus>();
            queryWrapper.eq("PARENT_ID", sysMenus.getId());
            List<SysMenus> list2 = this.list(queryWrapper); //获取所有二级的
            sysMenus.setChildMenu(list2);

            for (SysMenus menus : list2) {
                queryWrapper = new QueryWrapper<SysMenus>();
                queryWrapper.eq("PARENT_ID", menus.getId());
                List<SysMenus> list3 = this.list(queryWrapper); //获取所有三级的
                menus.setChildMenu(list3);
                //三级是否要选中
                for (SysMenus sysMenus1 : list3) {
                    for (MenuRole menuRole : sysMenuRoleList) {
                        if (sysMenus1.getId() == menuRole.getMid()) {
                            sysMenus1.setIscheck(true);
                            break;
                        }
                    }
                }
            }
            //上面代码  把菜单表所有 1,2,3级全部取出来
            //将三级有权限的  设置true
            //你刚才只取到自己角色有权限的菜单数据 所有只有2个 1级
        }
        return list;
    }
}
