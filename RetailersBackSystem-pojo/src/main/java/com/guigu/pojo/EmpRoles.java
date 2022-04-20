package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpRoles {
    @TableId(value = "ID", type = IdType.AUTO)
    private  Integer id;
   /* 用户id*/
    private  Integer pid;
    /*角色id*/
    private  Integer rid;
}
