package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

//供应商停供商品表
public class Goodsupplied {

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    //用户id
    private Integer pId;
    //商品id
    private String gId;
    //供应货物价格
    private Double supplierPrice;



}
