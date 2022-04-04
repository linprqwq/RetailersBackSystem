package com.guigu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface UserinfoService extends IService<Userinfo> {
    //用户登录
    Userinfo userlogin(Userinfo userinfo);
    public Map update(Userinfo userinfo);

    PageVo<Userinfo> querybyconduser(Userinfo userinfo, Integer pageno, Integer pagesize);


    Map updstate(Userinfo userinfo);

    Map updstatebtg(Userinfo userinfo);

    PageVo<Userinfo> querybyconduser2(Userinfo userinfo, Integer pageno, Integer pagesize);

    PageVo<Userinfo> queryallGysJl(Userinfo userinfo, Integer pageno, Integer pagesize);
}
