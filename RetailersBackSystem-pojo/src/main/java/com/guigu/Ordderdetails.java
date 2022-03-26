package com.guigu;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//订单详情表
public class Ordderdetails {

    private Integer id;
    private Integer orderid;
    private Integer uid;
    private Integer proid;
    private String proname;
    private String proimage;
    private Double prosprice;
    private Integer quantity;
    private Double totalpirce;
    private Date createtime;
    private Date updatetime;
}
