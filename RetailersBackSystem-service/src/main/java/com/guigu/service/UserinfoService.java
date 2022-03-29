package com.guigu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface UserinfoService extends IService<Userinfo> {
    //用户登录
    Userinfo userlogin(Userinfo userinfo);


}
