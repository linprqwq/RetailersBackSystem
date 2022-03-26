package com.guigu;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户余额变动表
public class Customerbalancelog {

    private Integer ID;
    private Integer uid;
    private Integer source;
    private Date ctime;
    private Double amount;
}
