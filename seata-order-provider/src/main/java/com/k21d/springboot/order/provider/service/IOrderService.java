package com.k21d.springboot.order.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.order.provider.entity.Order;

public interface IOrderService extends IService<Order> {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}

