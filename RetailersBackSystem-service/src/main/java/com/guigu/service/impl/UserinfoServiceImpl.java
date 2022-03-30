package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService{
    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    //用户登录
    public Userinfo userlogin(Userinfo userinfo) {
        return userinfoMapper.userlogin(userinfo);
    }

    @Override
    public Map update(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","修改失败");
        if(num){
            map.put("code","1");
            map.put("msg","修改成功");
        }
        return map;
    }

    @Override
    public PageVo<Userinfo> querybyconduser(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno,pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper =new QueryWrapper<Userinfo>();
        if(StringUtils.isNotBlank(userinfo.getUsername())){
            queryWrapper.like("username",userinfo.getUsername());
        }
        Page<Userinfo> page1 = this.page(page,queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }
}
