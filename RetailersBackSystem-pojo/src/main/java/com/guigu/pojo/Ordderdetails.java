package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
//订单详情表
public class Ordderdetails {

    /**
     * 订单详情id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品编号
     */
    private Integer proid;

    /**
     * 商品名称
     */
    private String proname;

    /**
     * 商品图片地址
     */
    private String proimage;

    /**
     * 商品单价
     */
    private Double prosprice;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品总价
     */
    private Double totalpirce;

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
     * 退款 0.未进行退款 2.待退款 3.退款完成
     */
    private Integer refund;
}
