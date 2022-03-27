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

    private Integer cateid;
    private Integer parentid;
    private String name;
    private Integer state;
    private String sortorder;
    private Date createtime;
    private Date updatetime;


}
