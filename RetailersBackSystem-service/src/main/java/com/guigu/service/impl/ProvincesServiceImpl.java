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
    public List<Provinces> queryAllSheng(Provinces provinces) {
        return provincesMapper.queryAllSheng(provinces);
    }

    @Override
    public List<Provinces> queryChinaByShi(String id) {
        return provincesMapper.queryChinaByShi(id);
    }

    @Override
    public List<Provinces> queryChinaByQu(String id) {
        return provincesMapper.queryChinaByQu(id);
    }
}
