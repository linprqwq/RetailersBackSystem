package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenus {
    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;
    private Integer parentId;
    private String name;
    private String linkUrl;
    private String iconUrl;
    private String status;
    /*子级菜单*/
    @TableField(exist = false)
    List<SysMenus> childMenu;
    @TableField(exist = false)
    boolean ischecked;
    @TableField(exist = false)
    private boolean ischeck;
    @TableField(exist = false)
    private EmpRole empRole;
}
