package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper extends BaseMapper<Userinfo> {
    Userinfo userlogin(@Param("userinfo") Userinfo userinfo);
}
