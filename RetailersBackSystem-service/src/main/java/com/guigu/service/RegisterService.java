package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Userinfo;

public interface RegisterService extends IService<Userinfo> {
    //检查昵称是否重复
    Integer CheckUserName(String usernameqwq);

    //检查登录账号是否重复
    Integer CheckLoginName(String loginnameqwq);
}
