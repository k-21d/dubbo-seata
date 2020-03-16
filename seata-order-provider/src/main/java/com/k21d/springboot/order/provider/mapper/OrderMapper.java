package com.k21d.springboot.order.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.k21d.springboot.order.provider.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 创建订单
     * @Param:  order 订单信息
     * @Return:
     */
    void createOrder(@Param("order") Order order);
}