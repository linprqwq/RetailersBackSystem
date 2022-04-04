package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//商品表
public class Commodity {
    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     //商品类型id
     */
    private Integer shopType;

    /**
     * 商品名
     */
    private String proname;

    /**
     * 商品副标题
     */
    private String prosubtitle;

    /**
     * 商品主图
     */
    private String prozimg;

    /**
     * 商品图片
     */
    private String proimage;

    /**
     * 商品详情
     */
    private String prodetails;

    /**
     * 商品单价
     */
    private Double prosprice;

    /**
     * 商品库存数量
     */
    private Double quantity;

    /**
     * 商品状态 1.在售 2.下架
     */
    private Integer status;

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

}
