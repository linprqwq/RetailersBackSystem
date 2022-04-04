package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shop_type_info_copy")
//商品类型分类
public class ShopTypeInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;//分类名

    @TableField(value = "is_delete")
    private Integer isDelete;//是否删除

}