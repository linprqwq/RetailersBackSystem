package com.guigu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageVo<T> {

    //总数量
    private Long total;

    //当前页的集合数据
    private List<T> rows;

}
