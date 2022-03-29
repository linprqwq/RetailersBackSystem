package com.guigu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;


public interface EmploService extends IService<SysEmployees> {

    PageVo<SysEmployees> querysysemp(SysEmployees sysEmployees, Integer pageno, Integer pagesize);
}
