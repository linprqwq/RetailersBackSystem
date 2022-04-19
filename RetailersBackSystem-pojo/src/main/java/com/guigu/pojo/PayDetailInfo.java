package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PayDetailInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出库id
     */
    private Integer payId;

    /**
     * 仓库id
     */
    private Integer warId;

    /**
     * 商品维护id 供应商提供的商品表id
     */
    @TableField("supply_orderId")
    private Integer supplyOrderid;

    /**
     * 商品数量 获取出库商品的数量
     */
    @TableField("Shop_num")
    private Integer shopNum;

    /**
     * 状态 是否删除 0正常 1删除
     */
    @TableField("Is_delete")
    private Integer isDelete;


}
