package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//商品分类
public class ShopTypeInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;//分类名

    private Integer isDelete;//是否删除

}