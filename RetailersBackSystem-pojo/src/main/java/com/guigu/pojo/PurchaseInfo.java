package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * 采购申请表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PurchaseInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购订单编号 4位年份+6位流水号
     */
    private String buyNumber;

    /**
     * 根据商品选择对应的供应商
     */
    private Integer supplyId;

    /**
     * 采购时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ptime;

    /**
     * 总数量
     */
    private Integer totalNum;

    /**
     * 总金额
     */
    private Double totalMoney;

    /**
     * 	 0:未发货，1:发货 2:到达总店
     */
    private Integer isShipments;

    /**
     * 0:未审核,   1:审核通过 2 审核未通过
     */
    @TableField("Is_audit")
    private Integer isAudit;

    /**
     * 什么情况采购
     */
    private String premark;
    /**
     * 0未设计，1已设计
     */
    private Integer isDesign;

    /**
     * 0:正常,1:删除
     */
    @TableField("Is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private List<PurchaseDetailInfo> purchaseDetailInfoList;

    @TableField(exist = false)
    private Userinfo userinfo;
}
