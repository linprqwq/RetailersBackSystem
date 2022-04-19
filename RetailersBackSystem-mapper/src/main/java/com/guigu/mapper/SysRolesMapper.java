package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.SysRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface SysRolesMapper extends BaseMapper<SysRoles> {
    public List<SysRoles> querysysrole(@Param("sysroles") SysRoles sysRoles);

}
