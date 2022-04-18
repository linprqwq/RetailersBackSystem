package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ShopImags {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;

    private Integer shopId;

    private String imagUrl;
}