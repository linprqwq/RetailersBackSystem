package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class WarehouseInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 添加仓库时，需检查仓库名是否有重复，页面要做验证
     */
    private String warName;

    /**
     * 注意点：
1:仓库详情表的当前存储量不能超过仓库最大库存
2:仓库详情的最大值总和不能超过仓库最大库存
     */
    private String warMaxStock;

    /**
     * 0:等待审核 1通过; 2未通过
     */
    private Integer isCheck;

    /**
     * 0:正常;1:删除
     */
    private Integer isDelete;


}
