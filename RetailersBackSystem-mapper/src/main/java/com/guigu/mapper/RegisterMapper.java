package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.Userinfo;

public interface RegisterMapper extends BaseMapper<Userinfo> {

    //检查昵称是否重复
    Integer CheckUserName(String usernameqwq);

    //检查登录账号是否重复
    Integer CheckLoginName(String loginnameqwq);
}
