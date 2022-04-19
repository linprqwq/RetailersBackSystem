package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.Provinces;

import java.util.List;

public interface ProvincesMapper extends BaseMapper<Provinces> {
    List<Provinces> queryAllSheng(Provinces provinces);

    List<Provinces> queryChinaByShi(String  id);

    List<Provinces> queryChinaByQu(String  id);
}
