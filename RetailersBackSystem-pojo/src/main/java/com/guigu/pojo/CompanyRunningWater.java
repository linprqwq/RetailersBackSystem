package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CompanyRunningWater {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发钱者
     */
    private Integer accountId;

    /**
     * 收钱者
     */
    private Integer uid;

    /**
     * 产生的账单id
     */
    private Integer oid;

    /**
     * 流水金额
     */
    private double rmoney;
    /**
     * 流水日期年月日时分秒
     */
    private Date rdate;

    /**
     * 1. 订单付款 2. 订单退款 3. 商户营收 4. 采购商品
     */
    private Integer rtype;

    /**
     * 是否删除0正常 1删除
     */
    private double isDelete;


}
