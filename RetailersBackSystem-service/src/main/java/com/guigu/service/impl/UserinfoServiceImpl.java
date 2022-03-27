package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService{
    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Userinfo userlogin(Userinfo userinfo) {
        return userinfoMapper.userlogin(userinfo);
    }
}
