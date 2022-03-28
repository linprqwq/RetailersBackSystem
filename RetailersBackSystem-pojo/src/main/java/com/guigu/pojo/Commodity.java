package com.guigu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//商品表
public class Commodity {
    private Integer id;
    private Integer cateid;
    private String proname;
    private String prosubtitle;
    private String prozimg;
    private String proimage;
    private String prodetails;
    private Double prosprice;
    private Double quantity;
    private Integer status;
    private Date createtime;
    private Date updatetime;
}
