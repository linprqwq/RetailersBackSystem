package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.EmployeeMapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.service.EmploService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmploServiceImpl extends ServiceImpl<EmployeeMapper, SysEmployees> implements EmploService {

    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public PageVo<SysEmployees> querysysemp(SysEmployees sysEmployees, Integer pageno, Integer pagesize) {
        Page<SysEmployees> page = new Page<SysEmployees>(pageno,pagesize);
        //条件查询
        QueryWrapper<SysEmployees> queryWrapper =new QueryWrapper<SysEmployees>();
        if(StringUtils.isNotBlank(sysEmployees.getEmpName())){
            queryWrapper.like("emp_name",sysEmployees.getEmpName());
        }
        Page<SysEmployees> page1 = this.page(page,queryWrapper);
        PageVo<SysEmployees> pageVo = new PageVo<SysEmployees>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }
}
