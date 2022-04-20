package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.EmpRoles;
import com.guigu.pojo.SysEmployees;

import java.util.List;
import java.util.Map;

public interface EmpRolesService extends IService<EmpRoles> {
    public Map addemproles(EmpRoles empRoles, SysEmployees sysEmployees,Integer[] rids);
}
