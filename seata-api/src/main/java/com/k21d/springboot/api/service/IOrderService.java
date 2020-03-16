package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.OrderDTO;

public interface IOrderService {
    String createOrder(OrderDTO orderDTO);
}
