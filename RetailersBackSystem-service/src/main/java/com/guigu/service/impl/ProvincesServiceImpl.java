package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.OrderinfoMapper;
import com.guigu.mapper.ProvincesMapper;
import com.guigu.pojo.Orderinfo;
import com.guigu.pojo.Provinces;
import com.guigu.pojo.SysRoles;
import com.guigu.service.OrderinfoService;
import com.guigu.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvincesServiceImpl extends ServiceImpl<ProvincesMapper, Provinces> implements ProvincesService {
    @Autowired
    ProvincesMapper provincesMapper;
    @Override
    public List<Provinces> queryAllChina(Provinces provinces) {
        List<Provinces> list1=new ArrayList<Provinces>();
        QueryWrapper<Provinces> queryWrapper =new QueryWrapper<Provinces>();
       queryWrapper.eq("pid",provinces.getPid());
        list1=this.list(queryWrapper);
        return list1;
    }

    @Override
    public List<Provinces> queryChinaByPid(Provinces provinces) {
        List<Provinces> list1=new ArrayList<Provinces>();
        QueryWrapper<Provinces> queryWrapper =new QueryWrapper<Provinces>();
        queryWrapper.eq("pid",provinces.getPid());
        list1=this.list(queryWrapper);
        return list1;
    }

    @Override
    public List<Provinces> queryChinaByshi(Provinces provinces) {
        List<Provinces> list1=new ArrayList<Provinces>();
        QueryWrapper<Provinces> queryWrapper =new QueryWrapper<Provinces>();
        queryWrapper.eq("pid",provinces.getPid());
        list1=this.list(queryWrapper);
        return list1;
    }
}
