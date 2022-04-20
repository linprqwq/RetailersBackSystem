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
 * @since 2022-04-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDetailsInfo implements Serializable {


    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 关联仓库表id
     */
    private Integer pId;

    /**
     * 关联商品表
     */
    private Integer shopId;

    /**
     * 供应商id
     */
    private Integer uId;

    /**
     * 存储量不能大于最大值
     */
    private Integer maxNum;

    /**
     * 当前存储量少于最小值警告
     */
    private Integer minNum;

    /**
     * 默认为0
     */
    private Integer amount;

    /**
     * 默认为0
     * 当出库选择仓库内的商品时，显示该条数据
     */
    private Integer lockStock;

    /**
     * 0:等待审核 1:通过;2未通过
     */
    private Integer isCheck;

    /**
     * 商品
     */
    @TableField(exist = false)
    private Commodity commodity;

    /**
     * 供应商信息
     */
    @TableField(exist = false)
    private Userinfo userinfo;
}
