package com.guigu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    //商品评论评分表
    private Integer id;
    private String content;
    private String img;
    private Integer cscore;
    private Integer sscore;
    private Integer pscore;
    private Integer tscore;
    private Date commenttime;
    private Integer zan;
    private Integer cai;
    private Integer cid;


}
