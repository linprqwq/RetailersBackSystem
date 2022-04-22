package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

//供应商提供商品表
@TableName("goods_supplied")  //表名和数据库
public class Goodsupplied {

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    //用户id
    private Integer pId;
    //商品id
    private String gId;


    //供应货物价格
    @TableField(value = "Supplied_price")
    private Double supplierPrice;

    private Integer isConfig;//是否被配置到仓库
    // 0：未配置1：已配置

    private Integer isCheck;//审核状态
    //0:等待审核 1:审核通过 2.审核未通过

    private Integer isDelete; //供应商品状态(删除状态)
    //0：正常供应商品 1：停止供应商品

    @TableField(exist = false) //解决数据中字段未存在
    private  Userinfo userinfo;  //商户详情表

    @TableField(exist = false)
    private ShopInfo shop; //商品对象
    @TableField(exist = false)
    private ShopTypeInfo shopTypeInfo; //商品对象
    @TableField(exist = false)
    private   Commodity commodity; //商品详情表

    @TableField(exist = false)
    private Boolean isDeleteBoolean; //商品对象



}
