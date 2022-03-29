package com.guigu.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 浏览记录表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BrowsingHistory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 序号
     */
    private Integer id;

    /**
     * 用户id(供应商id)
     */
    private Integer pId;

    /**
     * 商品id
     */
    private Integer gId;

    /**
     * 浏览时间
     */
    private LocalDateTime browsingDate;


}
