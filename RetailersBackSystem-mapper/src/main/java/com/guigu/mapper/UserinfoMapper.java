package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoMapper extends BaseMapper<Userinfo> {
    //用户登录
    Userinfo userlogin(@Param("userinfo") Userinfo userinfo);

    //个人购物车商品数量
    Integer CartCount(Integer id);

    //商户地址
    List<Userinfo> QueryLikeSh(Userinfo userinfo);

    Userinfo QueryshID(Userinfo userinfo);

    Userinfo QueryshIDd(Userinfo userinfo);
}
