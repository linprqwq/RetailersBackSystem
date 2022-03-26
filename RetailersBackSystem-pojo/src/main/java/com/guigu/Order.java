package com.guigu;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//订单表
public class Order {

    private Integer orderid;
    private Integer uid;
    private Integer payment;
    private Integer paymenttype;
    private Date paymenttime;
    private Date sendtime;
    private Date endtime;
    private Date colsetime;
    private Date createtime;
    private Date updatetime;
    private Integer status;
}
