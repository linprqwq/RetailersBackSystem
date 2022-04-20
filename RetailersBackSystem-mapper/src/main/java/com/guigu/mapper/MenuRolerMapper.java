package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.MenuRole;
import com.guigu.pojo.SysMenus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuRolerMapper extends BaseMapper<MenuRole> {
    List<MenuRole> querymenuforRoleId(@Param("rid") Integer roleId);
}
