package com.guigu;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户表
public class Userinfo {

    @TableId(value = "id",type = IdType.AUTO)
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
