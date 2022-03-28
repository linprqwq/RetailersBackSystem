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
 * <p>
 * 
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class GoodsSupplied implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("Goods_details")
    private String goodsDetails;

    @TableField("Supplier_name")
    private String supplierName;

    private Integer price;

    @TableField("Cid")
    private Integer Cid;

    @TableField("gImage")
    private String gImage;


}
