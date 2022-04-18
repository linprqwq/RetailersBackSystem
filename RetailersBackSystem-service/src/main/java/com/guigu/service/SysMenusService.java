package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysMenus;
import com.guigu.pojo.SysRoles;
import jdk.nashorn.internal.ir.IdentNode;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface SysMenusService extends IService<SysMenus> {
    PageVo<SysMenus> querysysmenus(SysMenus sysMenus, Integer pageno,Integer pagesize);
    public Map addsysysmenus(SysMenus sysMenus);
    public SysMenus querysysmenusbyid(int id);
    public Map updatasysmenus(SysMenus sysMenus);
    public Map deletesysmenus(int id);

    List<SysMenus> querymenusleft(Integer roleId);
}
