package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.MenuRolerMapper;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.MenuRole;
import com.guigu.pojo.Userinfo;
import com.guigu.service.MenuRoleService;
import com.guigu.service.UserinfoService;
import org.springframework.stereotype.Service;

@Service
public class MenuRoleServiceImpl  extends ServiceImpl<MenuRolerMapper, MenuRole> implements MenuRoleService {
}
