package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//商品表
public class Commodity {
    @TableId(value = "id",type = IdType.AUTO)
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
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date updatetime;
}
