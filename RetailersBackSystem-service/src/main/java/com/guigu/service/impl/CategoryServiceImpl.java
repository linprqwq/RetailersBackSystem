package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CategoryMapper;
import com.guigu.pojo.Category;
import com.guigu.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
