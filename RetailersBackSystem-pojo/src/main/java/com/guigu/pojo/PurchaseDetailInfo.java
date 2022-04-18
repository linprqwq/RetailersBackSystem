package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 采购详情表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetailInfo implements Serializable {



    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购单id
     */
    private Integer pid;

    /**
     * 供货商的商品id
     */
    private Integer shopId;

    /**
     * 供应商的商品价格
     */
    private Double shopPrice;

    /**
     * 商品数量
     */
    private Integer shopNum;

    /**
     * 商品总价格
     */
    private Double totalPrice;

    /**
     * 是否已设计
     */
    private Integer isDesign;
    /**
     * 0:正常,1删除
     */
    @TableField("Is_delete")
    private Integer isDelete;
    @TableField(exist = false)
    private  Goodsupplied goodsupplied;

}
