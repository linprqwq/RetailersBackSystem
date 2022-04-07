package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
//订单表
public class Orderinfo {

    /**
     * 订单id
     */
    @TableId(value = "orderid", type = IdType.AUTO)
    private Integer orderid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 实付金额
     */
    private Integer payment;

    /**
     * 付款类型:1.余额 2.支付宝 3.微信
     */
    private Integer paymenttype;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date paymenttime;

    /**
     * 发货时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date sendtime;

    /**
     * 订单完成时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date endtime;

    /**
     * 交易关闭时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date colsetime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date updatetime;

    /**
     * 订单状态:1.已取消 - 2.未付款-3.待取货-4.已提货
     */
    private Integer status;

    /**
     * 商户id
     */
    private Integer sid;


    /**
     * 订单显示: -1显示 -0隐藏
     */
    private Integer state;
    /**
     * 订单详情
     */
    @TableField(exist = false)
    private List<Ordderdetails> ordderdetails;
}
