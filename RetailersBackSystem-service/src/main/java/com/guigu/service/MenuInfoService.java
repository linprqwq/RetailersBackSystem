package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.SysMenus;

import java.util.List;

public interface MenuInfoService extends IService<SysMenus> {
    List<SysMenus> querymenusbyrid(int i, Integer rid);
}
