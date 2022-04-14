package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface CartMapper extends BaseMapper<Cart> {

    List<Cart> selectusergwc(@Param("list") int[] list, @Param("cart") Cart cart);

    Cart selectcartone(@Param("i")int i,@Param("uid") Integer uid);

    boolean scbyid(@Param("i")int i, @Param("uid")Integer uid);
}
