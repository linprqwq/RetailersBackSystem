package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 童总
 * @since 2022-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Commthinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 流水号
     */
    private Integer nuberid;

    /**
     * 订单详情id
     */
    private Integer orddid;

    /**
     * 退货原因
     */
    private String thyy;

    /**
     * 退货图片1
     */
    private String img;

    /**
     * 退货图片2
     */
    private String img2;

    /**
     * 退货图片3
     */
    private String img3;

    /**
     * 退货时间
     */
    private Date thtime;

    /**
     * 退款金额
     */
    private Integer tmoney;

    /**
     * 后台审核 0.等待审核 2.通过审核 3.未通过审核
     */
    private Integer audit;

    /**
     * 1：等待用户将货物送到商户，商户等待确认
2：商户确认收货，等待总店取货
3：总店成功取货，送到退货仓库
4：总店退货到供应商，供应商给钱到总店，总店退钱给用户，退货结束
(默认为0，当通过审核就将状态改为1)
     */
    private Integer commstate;

    /**
     * 删除 0.正常 1.删除
     */
    private Integer state;
    /**
     * 商户id
     */
    private Integer sid;

}
