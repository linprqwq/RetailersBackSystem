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
import java.time.LocalDateTime;

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
public class GatherInfo implements Serializable {


    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 查询号 存放采购单号或退货单号
     */
    private String   trackingNumber;


    /**
     * 0 采购入库 1 退货入库
     */
    @TableField("Gather_type")
    private Integer gatherType;

    /**
     * 入库时间
     */
    @TableField("Gtime")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime Gtime;

    /**
     * 审核 0 等待审核 1通过审核 2 未通过
     */
    @TableField("Is_check")
    private Integer isCheck;

    /**
     * 全部指定 详情表是否全部指定了仓库
0未全部指定，1全部指定
     */
    private Integer allSpecified;

    /**
     * 是否删除 0正常 1删除
     */
    @TableField("Is_delete")
    private Integer isDelete;


}
