package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
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
}
