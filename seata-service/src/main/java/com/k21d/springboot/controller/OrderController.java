package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.service.IOrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference
    private IOrderService orderService;

    @PostMapping("/create_order")
    String createOrder(@RequestBody OrderDTO orderDTO){
        System.out.printf("请求订单微服务：{$s}",orderDTO.toString());
        return orderService.createOrder(orderDTO);
    }
}
