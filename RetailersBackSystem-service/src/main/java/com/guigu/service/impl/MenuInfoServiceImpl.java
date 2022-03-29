package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.MenuInfoMapper;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.SysMenus;
import com.guigu.pojo.Userinfo;
import com.guigu.service.MenuInfoService;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuInfoServiceImpl extends ServiceImpl<MenuInfoMapper, SysMenus> implements MenuInfoService {
    @Autowired
    MenuInfoMapper menuInfoMapper;
    @Override
    public List<SysMenus> querymenusbyrid(int i, Integer rid) {
        List<SysMenus> list = new ArrayList<SysMenus>();

        //  先查询pid=0的数据   可以查到所有的一级菜单
        list = menuInfoMapper.querymenusbypidandrid(i, rid);

        //循环一级菜单   拿着一级菜单的id，当成pid，找下二级菜单
        for (SysMenus sysMenus : list) {
            List<SysMenus> childmenus =
                    menuInfoMapper.querymenusbypidandrid(sysMenus.getId(), rid);
            sysMenus.setChildMenu(childmenus);
            for (SysMenus obj : childmenus) {
                List<SysMenus> menus3 = menuInfoMapper.querymenusbypidandrid(obj.getId(), rid);
                obj.setChildMenu(menus3);
            }
        }
        return list;
    }
}
