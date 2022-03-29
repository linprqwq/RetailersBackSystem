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
import java.util.Date;

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
public class SPay implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("AMOUNT_SUM")
    private Integer amountSum;

    @TableField("COST_PRICE_SUM")
    private Integer costPriceSum;

    @TableField("PAID_AMOUNT_SUM")
    private Integer paidAmountSum;

    private String remark;

    @TableField("REGISTER")
    private String register;

    @TableField("REGISTER_TIME")
    private Date registerTime;

    @TableField("CHECKER")
    private String checker;

    @TableField("CHECK_TIME")
    private Date checkTime;

    @TableField("CHECK_TAG")
    private String checkTag;

    @TableField("DJ_TAG")
    private String djTag;


}
