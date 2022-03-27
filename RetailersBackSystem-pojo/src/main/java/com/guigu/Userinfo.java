package com.guigu;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户表
public class Userinfo {

    private Integer ID;
    private String username;
    private String loginname;
    private String password;
    private String phone;
    private Double umoney;
    private String address;
    private String img;
    private Integer identity;
    private Integer ustate;
    private String shaddress;
}
