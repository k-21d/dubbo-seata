package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.response.ObjectResponse;

public interface IOrderDubboService {
    ObjectResponse createOrder(OrderDTO orderDTO);
}
