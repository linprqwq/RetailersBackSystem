package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.pojo.SysRoles;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
public interface SysEmployeesService extends IService<SysEmployees> {
    Page<SysEmployees>  querysysemp2(SysEmployees sysEmployees, Integer pageno, Integer pagesize);
    public Map<String,String> addSysemployees(Integer [] rids, SysEmployees sysEmployees, MultipartFile file, HttpServletRequest request )throws IOException;
    public Map deleteemployees(int id);
    public SysEmployees quertsempliyeesbyid(int id);
    public Map updateemplouees(SysEmployees sysEmployees);
    public List<SysRoles> querysysempliyeesrolebyid(SysRoles sysRoles);



}
