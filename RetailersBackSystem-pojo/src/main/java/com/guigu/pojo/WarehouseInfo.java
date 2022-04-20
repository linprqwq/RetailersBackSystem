package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
public class WarehouseInfo implements Serializable {

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 添加仓库时，需检查仓库名是否有重复，页面要做验证
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
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

    /**
     * 查询仓库分类
     */
    @TableField(exist = false)
    private List<WarehouseClassification> warefenlei;

    /**
     * 仓库分类名
     */

    @TableField(exist = false)
    private  String shoptypename;
}
