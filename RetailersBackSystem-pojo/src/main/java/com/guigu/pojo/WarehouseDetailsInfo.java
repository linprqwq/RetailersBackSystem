package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class WarehouseDetailsInfo implements Serializable {

    private static final long serialVersionUID=1L;

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
当出库选择仓库内的商品时，显示该条数据
     */
    private Integer lockStock;

    /**
     * 0:等待审核 1:通过;2未通过
     */
    private Integer isCheck;


}
