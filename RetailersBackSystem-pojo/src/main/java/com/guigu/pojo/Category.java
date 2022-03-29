package com.guigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//商品类别表
public class Category {

    /**
     * 类型编号
     */
    private Integer cateid;

    /**
     * 父类别根号  0根节点
     */
    private Integer parentid;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别状态 ：0.弃用   1.可用
     */
    private Integer state;

    /**
     * 类别排序
     */
    private String sortorder;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;


}
