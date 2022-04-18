package com.guigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseClassification implements Serializable {

    /**
     * 关联仓库表id
     */
    private Integer pId;

    /**
     * 关联商品表
     */
    private Integer shopClassId;


}
