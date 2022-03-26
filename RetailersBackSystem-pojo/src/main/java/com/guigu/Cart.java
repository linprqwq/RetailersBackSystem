package com.guigu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 购物车
public class Cart {

    private Integer cartid;
    private Integer uid;
    private Integer pid;
    private Integer quantity;
}
