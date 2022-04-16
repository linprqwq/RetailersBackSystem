package com.guigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
public class Reviews {
    //商品评论评分表

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 内容
     */
    private String content;

    /**
     * 上传图片
     */
    private String img;

    /**
     * 商品评分
     */
    private Integer cscore;

    /**
     * 服务评分
     */
    private Integer sscore;

    /**
     * 时效评分
     */
    private Integer pscore;

    /**
     * 总评分
     */
    private Integer tscore;

    /**
     * 评论时间
     */
    private Date commenttime;

    /**
     * 赞
     */
    private Integer zan;

    /**
     * 踩
     */
    private Integer cai;

    /**
     * 商品id
     */
    private Integer cid;


    /**
     * 商品详情id
     */

    private Integer orddid;

}
