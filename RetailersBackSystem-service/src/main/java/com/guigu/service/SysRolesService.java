package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysRoles;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface SysRolesService extends IService<SysRoles> {
    PageVo<SysRoles> querysyroles(SysRoles sysRoles,Integer pageno,Integer pagesize);
    public Map addsysrole(SysRoles sysRoles);
    public SysRoles querysysrolebyid(int id);
    public Map updatasysrole(SysRoles sysRoles);
    public Map deletesysrole(int id);

}
