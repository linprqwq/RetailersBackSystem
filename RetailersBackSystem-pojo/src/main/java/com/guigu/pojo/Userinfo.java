package com.guigu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//用户表
@TableName("userinfo")
public class Userinfo {

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录名
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户余额
     */
    private Double umoney;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户头像
     */
    @TableField("img")
    private String imgpath;

    /**
     * 身份:1.普通用户 2.商户3.供应商
     */
    private Integer identity;

    /**
     * 状态
     */
    private Integer ustate;

    /**
     * 商户地址（关联省市表）
     */
    private String shaddress;
    /**
     * 注册商户状态
     */
    private String shState;
    /**
     * 注册供应商状态
     */
    private String gysState;


    @TableField(exist = false)
    private List<Cart> carts;
}
