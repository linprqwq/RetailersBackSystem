package com.guigu.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseClassification implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 关联仓库表id
     */
    private Integer pId;

    /**
     * 关联商品表
     */
    private Integer shopClassId;


}
