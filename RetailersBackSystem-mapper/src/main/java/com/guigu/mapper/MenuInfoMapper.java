package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.SysMenus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuInfoMapper extends BaseMapper<SysMenus> {
    List<SysMenus> querymenusbypidandrid(@Param("menuId") int i, @Param("rid") Integer rid);
}
