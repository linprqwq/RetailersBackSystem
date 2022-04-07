package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor //以声明字段参数属性
@NoArgsConstructor  //无声明字段参数属性
@EqualsAndHashCode(callSuper = false) //此注解会生成equals(Object other) 和 hashCode()方法。
@Accessors(chain = true)  //通过该注解可以控制getter和setter方法的形式。

//供应商品分类表
public class SupplierGoodsCategory {

    //序号
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //用户id(供应商id)
    private Integer pId;

    //分类id
    private Integer sortId;


}