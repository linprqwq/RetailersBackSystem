package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.SysEmployees;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface SysEmployeesMapper extends BaseMapper<SysEmployees> {
    public int addSysemployees(SysEmployees sysEmployees);
    public int deleteemployees(@Param("sys") int id);
    public int updateemplouees(SysEmployees sysEmployees);

}
