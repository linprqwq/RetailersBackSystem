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
    private Double prodetails;
    private Double prosprice;
    private Integer quantity;
    private Date status;
    private Date createtime;
}
