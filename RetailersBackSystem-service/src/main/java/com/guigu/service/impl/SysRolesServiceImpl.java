package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.SysRolesMapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysRoles;
import com.guigu.service.SysRolesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements SysRolesService {
    @Autowired
    SysRolesMapper sysRolesMapper;

    @Override
    public PageVo<SysRoles> querysyroles(SysRoles sysRoles, Integer pageno, Integer pagesize) {
        Page<SysRoles> page=new Page<SysRoles>(pageno,pagesize);
        QueryWrapper<SysRoles> queryWrapper=new QueryWrapper<SysRoles>();
        if(StringUtils.isNotBlank(sysRoles.getRoleName())){
            queryWrapper.like("role_name",sysRoles.getRoleName());
        }
        Page<SysRoles> page1=this.page(page,queryWrapper);
        PageVo<SysRoles> pageVo=new PageVo<SysRoles>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());

        return pageVo;
    }

    @Override
    public Map addsysrole(SysRoles sysRoles) {
        Map map = new HashMap();
        map.put("msg","添加失败");

        if ( sysRolesMapper.insert(sysRoles)>0){
            map.put("msg","添加成功");
        }

        return map;
    }

    @Override
    public SysRoles querysysrolebyid(int id) {
        SysRoles sysRoles=this.getById(id);
        return sysRoles;
    }

    @Override
    public Map updatasysrole(SysRoles sysRoles) {
        boolean num=this.updateById(sysRoles);
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
    public Map deletesysrole(int id) {
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
}
