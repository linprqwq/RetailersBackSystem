package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 购物车
public class Cart {
    /**
     * 购物车id
     */
    @TableId(value = "cartid", type = IdType.AUTO)
    private Integer cartid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品编号
     */
    private Integer cid;

    /**
     * 商品数量
     */
    private Integer quantity;
    @TableField(exist = false)
    //商品查询
    private Commodity commodity;
}
