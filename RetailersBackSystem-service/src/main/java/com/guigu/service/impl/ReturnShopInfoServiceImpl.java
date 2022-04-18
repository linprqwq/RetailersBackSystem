package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.ReturnShopInfoMapper;
import com.guigu.pojo.ReturnShopInfo;
import com.guigu.service.ReturnShopInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
@Service
public class ReturnShopInfoServiceImpl extends ServiceImpl<ReturnShopInfoMapper, ReturnShopInfo> implements ReturnShopInfoService {

    @Override
    public List<String> getIds(String str) {
        List<String> list = new ArrayList<String>();
        QueryWrapper<ReturnShopInfo> queryWrapper = new QueryWrapper<ReturnShopInfo>();
        queryWrapper.likeRight("return_number", str);
        List<ReturnShopInfo> tempList = this.list(queryWrapper);
        for (ReturnShopInfo obj : tempList) {
            list.add(obj.getReturnNumber());
        }
        return list;
    }
}
