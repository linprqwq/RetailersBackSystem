package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.SysRolesMapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysRoles;
import com.guigu.service.SysRolesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Service
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements SysRolesService {

    @Override
    public PageVo<SysRoles> querysyroles(SysRoles sysRoles, Integer pageno, Integer pagesize) {
        Page<SysRoles> page=new Page<SysRoles>(pageno,pagesize);
        QueryWrapper<SysRoles> queryWrapper=new QueryWrapper<SysRoles>();

        return null;
    }
}
