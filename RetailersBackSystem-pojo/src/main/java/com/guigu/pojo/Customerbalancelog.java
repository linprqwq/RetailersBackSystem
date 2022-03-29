package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户余额变动表
public class Customerbalancelog {

    /**
     * 余额日志id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 记录来源：0默认 1订单，2退货单’,3充值
     */
    private Integer source;

    /**
     * 记录生成时间
     */
    private Date ctime;

    /**
     * 变动金额
     */
    private Double amount;
}
