package com.guigu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.guigu.mapper.*;

import com.guigu.pojo.*;
import com.guigu.service.SysEmployeesService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Service
public class SysEmployeesServiceImpl extends ServiceImpl<SysEmployeesMapper, SysEmployees>
        implements SysEmployeesService {
    @Autowired
    SysEmployeesMapper sysEmployeesMapper;
    @Autowired
    SysRolesMapper sysRolesMapper;
    @Autowired
   EmpRoleMapper empRoleMapper;

    @Override
    public Page<SysEmployees> querysysemp2(SysEmployees sysEmployees, Integer pageno, Integer pagesize) {
        //条件查询
        QueryWrapper<SysEmployees> queryWrapper =new QueryWrapper<SysEmployees>();
        if(StringUtils.isNotBlank(sysEmployees.getEmpName())){
            queryWrapper.like("emp_name",sysEmployees.getEmpName());
        }
        Page<SysEmployees> page = new Page<SysEmployees>(pageno,pagesize);
        page.setTotal(pageno);
        page.setSize(pagesize);
        return sysEmployeesMapper.selectPage(page,queryWrapper);
    }

    public Map<String,String> addSysemployees(Integer [] rids, SysEmployees sysEmployees, MultipartFile file, HttpServletRequest request )throws IOException{
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","添加失败");
        if(file!=null){
            String path = request.getServletContext().getRealPath("/img"); //路径名
            String name = file.getOriginalFilename();  //文件名
            File savefile = new File(path,name);
            file.transferTo(savefile);
            Sysemployeesimgs sysemployeesimgs=new Sysemployeesimgs();
            sysEmployees.setEmpImg("img/"+name);}
        boolean result = this.save(sysEmployees);
        if (result) {
            EmpRole empRole=new EmpRole();
            for (Integer ridss : rids) {
                empRole.setEid(sysEmployees.getId());
                empRole.setRid(ridss);
                empRoleMapper.insert(empRole);
            }
            map.put("msg","添加成功");
        }
        return map;
   /* Map map = new HashMap();
        map.put("msg","添加失败");

        if ( sysEmployeesMapper.insert(sysEmployees)>0){
            System.out.println(sysEmployees);
            map.put("msg","添加成功");
        }

        return map;*/

    }
    public Map deleteemployees(int id){
        boolean num=this.removeById(id);
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","删除失败");
        if(num){
            map.put("code","1");
            map.put("msg","删除成功");

        }
        return map;
    }

    @Override
    public SysEmployees quertsempliyeesbyid(int id){
        SysEmployees sysEmployees=this.getById(id);

      return sysEmployees;
    }

    public Map updateemplouees(SysEmployees sysEmployees){
        boolean num=this.updateById(sysEmployees);
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","修改失败");
        if(num){
            map.put("code","1");
            map.put("msg","修改成功");
        }
        return map;
    }

    @Override
    public List<SysRoles> querysysempliyeesrolebyid(SysRoles sysRoles) {
        return sysRolesMapper.querysysrole(sysRoles);
    }

}
