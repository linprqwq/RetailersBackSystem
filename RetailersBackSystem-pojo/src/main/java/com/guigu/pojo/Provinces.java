package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//省市区
public class Provinces {
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 省市区名字
     */
    private String name;

    /**
     * 子id
     */
    private Integer pid;


}
