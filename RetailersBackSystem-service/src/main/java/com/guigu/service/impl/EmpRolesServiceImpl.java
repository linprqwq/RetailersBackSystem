package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.EmpRolesMapper;
import com.guigu.mapper.SysEmployeesMapper;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.EmpRoles;
import com.guigu.pojo.SysEmployees;
import com.guigu.service.EmpRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmpRolesServiceImpl extends ServiceImpl<EmpRolesMapper, EmpRoles> implements EmpRolesService {
    @Autowired
    EmpRolesMapper empRolesMapper;
    @Autowired
    SysEmployeesMapper sysEmployeesMapper;
    @Override
    public Map addemproles(EmpRoles empRoles, SysEmployees sysEmployees,Integer[] rids) {
        Map map=new HashMap<String,Object>();
        int  pid=sysEmployeesMapper.querysysemployeespid(sysEmployees.getEmpLoginname(),sysEmployees.getEmpPassword());
        System.out.println("111111111111"+pid);
        for(Integer rid : rids){
            EmpRoles empRoles2=new EmpRoles();
            empRoles2.setPid(pid);
            empRoles2.setRid(rid);
            empRolesMapper.insert(empRoles2);
        }
        map.put("msg","添加成功");
        return map;
    }
}
