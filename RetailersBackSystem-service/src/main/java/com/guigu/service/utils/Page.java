package com.guigu.service.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private List<T> records;//分页之后的数据
    private List<T> originalData;//原始数据，分页前的所有数据都在这里
    private Integer total;//总页数

    public Page pageList(List<T> records, Integer pageNum, Integer pageSize){
        //检查是否有数据
        Page page=new Page();
        page.setRecords(records);
        page.setOriginalData(records);
        if(records.size()>0){
            List<T> list=page.getRecords();
            //总页数
            int total=list.size()%pageSize==0?list.size()/pageSize:list.size()/pageSize+1;
            //计算页码
            pageNum=pageNum<=0?1:pageNum;
            pageNum=pageNum>=total?total:pageNum;
            //开始索引
            int begin=0;
            //结束索引
            int end=0;
            if(pageNum!=total){
                begin=(pageNum-1)*pageSize;
                end=begin+pageSize;
            }else {
                begin=(pageNum-1)*pageSize;
                end=list.size();
            }
            page.setRecords(list.subList(begin,end));
            page.setTotal(total);
        }else{
            //没有数据，设置默认值
            page.setRecords(new ArrayList());
            page.setTotal(1);
        }
        return page;
    }
}
