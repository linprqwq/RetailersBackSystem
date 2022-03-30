package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.SysMenus;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface SysMenusService extends IService<SysMenus> {

    List<SysMenus> querymenusleft(Integer roleId);
}
