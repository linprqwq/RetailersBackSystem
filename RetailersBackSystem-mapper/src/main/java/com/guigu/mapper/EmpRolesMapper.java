package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.EmpRoles;

public interface EmpRolesMapper  extends BaseMapper<EmpRoles> {
    public int addemproles(EmpRoles empRoles);
}
