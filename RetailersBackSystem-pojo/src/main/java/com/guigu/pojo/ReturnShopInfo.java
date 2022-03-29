package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 退货申请表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ReturnShopInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 4位年份+6位流水号
     */
    private String returnNumber;

    /**
     * 订单id
     */
    private Integer oId;

    /**
     * 商品id
     */
    private Integer gId;

    /**
     * 退货图片1
     */
    private String returnImg1;

    /**
     * 退货图片1
     */
    private String returnImg2;

    /**
     * 退货图片1
     */
    private String returnImg3;

    /**
     * 退货图片1
     */
    private String returnImg4;

    /**
     * 退货图片1
     */
    private String returnImg5;

    /**
     * 退货图片1
     */
    private LocalDate returnTime;

    /**
     * 退货理由
     */
    private String remark;

    /**
     * 0:等待审核 1:通过审核,2:未通过审核
     */
    @TableField("Is_audit")
    private Integer isAudit;

    /**
     * 1：等待用户将货物送到商户，商户等待确认
2：商户确认收货，等待总店取货
3：总店成功取货，送到退货仓库
4：总店退货到供应商，供应商给钱到总店，总店退钱给用户，退货结束
(默认为null，当通过审核就将状态改为1)
     */
    private Integer goodsState;

    /**
     * 0:正常,1:删除
     */
    @TableField("Is_delete")
    private Integer isDelete;


}
