package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//商品表
public class Commodity {
    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     //商品类型id
     */
    private Integer shopType;

    /**
     * 商品名
     */
    private String proname;

    /**
     * 商品副标题
     */
    private String prosubtitle;

    /**
     * 商品主图
     */
    private String prozimg;

    /**
     * 商品图片
     */
    private String proimage;

    /**
     * 商品详情
     */
    private String prodetails;

    /**
     * 商品单价
     */
    private Double prosprice;

    /**
     * 商品库存数量
     */
    private Integer quantity;

    /**
     * 商品状态 0.未上架 2.上架
     */
    private Integer status;

    /**
     *
     */
    private Integer isDelete;//是否删除

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date updatetime;

    @TableField(exist = false)
    private Integer num=1;

    @TableField(exist = false)
    private SupplierGoodsCategory supplierGoodsCategory;//商品类型对象
    public Commodity(Integer id){
        this.id=this.id;
    }

    //商品类型
   @TableField(exist = false)
    private  ShopTypeInfo ShopTypeInfo;

}
