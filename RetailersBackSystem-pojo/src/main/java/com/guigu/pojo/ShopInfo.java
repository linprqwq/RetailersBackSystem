package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShopInfo {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //商品编号
    private String shopNumber;

    //商品名称
    private String shopName;
    //商品价格
    private Integer shopPrice;

    //商品类型id
    private Integer shopType;

    //商品产地
    private String shopUnit;

    //商品规格
    private String shopRemark;
    //商品描述
    private Integer shopUpnum;
    //上架数量
    private Integer isUp;

    //是否上架
    private Integer isGather;

    //是否配置
    private Integer isDelete;

    @TableField(exist = false)
    private ShopTypeInfo type;//商品类型对象

    @TableField(exist = false)
    private List<ShopImags> imags;//图片集合
}
