package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date paymenttime;

    /**
     * 发货时间
     */
    private Date sendtime;

    /**
     * 订单完成时间
     */
    private Date endtime;

    /**
     * 交易关闭时间
     */
    private Date colsetime;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 订单状态:1.已取消 - 2.未付款  3.已付款 4.待取货
     */
    private Integer status;

    /**
     * 商户id
     */
    private Integer sid;
}
