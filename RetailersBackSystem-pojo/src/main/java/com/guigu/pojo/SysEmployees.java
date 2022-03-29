package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysEmployees {
    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;
    private String empName;
    private String empLoginname;
    private String empPassword;
    private String empPhone;
    private Integer empMoney;
    private String empAddress;
    private String empImg;
    private Integer empState;
}
