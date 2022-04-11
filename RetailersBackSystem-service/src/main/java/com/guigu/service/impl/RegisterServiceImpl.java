package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.RegisterMapper;
import com.guigu.pojo.Userinfo;
import com.guigu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Userinfo> implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    @Override
    public Integer CheckUserName(String usernameqwq) {
        int i=0;
        if(registerMapper.CheckUserName(usernameqwq)!=null){
            i=1;
            return i;
        }
        return i;
    }

    @Override
    public Integer CheckLoginName(String loginnameqwq) {
        int i=0;
        if(registerMapper.CheckLoginName(loginnameqwq)!=null){
            i=1;
            return i;
        }
        return i;
    }

    @Override
    public Integer RegisterUser(Userinfo userinfo) {
        int i=0;
        if(registerMapper.RegisterUser(userinfo)!=null){
            i=1;
            return i;
        }
        return i;
    }


}
