package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class PayInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 存放订单单号或退货申请表单号
     */
    private String trackingNumber;

    /**
     *  0 发货出库 1退货出库
     */
    @TableField("Pay_type")
    private Integer payType;

    /**
     * 出库时间
     */
    @TableField("Ptime")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime Ptime;

    /**
     * 审核  0 等待审核 1通过审核 2 未通过
     */
    @TableField("Is_check")
    private Integer isCheck;

    /**
     * 状态 是否删除 0正常 1删除
     */
    @TableField("Is_delete")
    private Integer isDelete;


}
