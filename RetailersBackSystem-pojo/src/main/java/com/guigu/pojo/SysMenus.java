package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenus {
    private static final long serialVersionUID=1L;
    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;
    @TableField("PARENT_ID")
    private Integer parentId;
    private String name;
    @TableField("LINK_URL")
    private String linkUrl;
    @TableField("ICON_URL")
    private String iconUrl;
    @TableField("STATUS")
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
