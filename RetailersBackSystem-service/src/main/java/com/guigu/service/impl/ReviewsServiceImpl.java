package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.mapper.OrdderdetailsMapper;
import com.guigu.mapper.ReviewsMapper;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Reviews;
import com.guigu.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Service
public class ReviewsServiceImpl extends ServiceImpl<ReviewsMapper, Reviews> implements ReviewsService {

    @Autowired
    ReviewsMapper reviewsMapper;

    @Autowired
    OrdderdetailsMapper ordderdetailsMapper;

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Map<String, String> orderpj(Reviews reviews) {
        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","请重新评价");
        System.out.println(reviews);
        reviews.setTscore((reviews.getPscore()+reviews.getCscore()+reviews.getSscore())/3);
        //评论时间
        reviews.setCommenttime(new Date());

        //评价表添加
         int insert = reviewsMapper.insert(reviews);
        if (insert>=1){
            //修改订单详情评价 1
            Ordderdetails ordderdetails= ordderdetailsMapper.selectById(reviews.getOrddid());
            ordderdetails.setEvaluatea(1);
            int a =  ordderdetailsMapper.updateById(ordderdetails);
            if (a>=1){
                map.put("code","1");
                map.put("msg","评价成功");
            }
        }


        return map;
    }

    @Override
    public Page<Reviews> plallbyid(Reviews reviews,Integer pageno,Integer pagesize) {
        QueryWrapper<Reviews> queryWrapper=new QueryWrapper<Reviews>();
        queryWrapper.eq("cid",reviews.getCid());

        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Reviews> page=this.page(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<Reviews>(pageno,pagesize),queryWrapper);

        for (Reviews record : page.getRecords()) {
            record.setUserinfo(userinfoMapper.selectById(record.getUid()));
        }
        return  page;
    }
}
