package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.EmpRoleMapper;
import com.guigu.mapper.EmployeeMapper;
import com.guigu.pojo.EmpRole;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.service.EmpRolerService;
import com.guigu.service.EmploService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpRoleServiceImpl extends ServiceImpl<EmpRoleMapper, EmpRole> implements EmpRolerService {


}
