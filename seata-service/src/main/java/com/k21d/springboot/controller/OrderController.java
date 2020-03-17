package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IOrderDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Reference
    private IOrderDubboService orderService;

    @PostMapping("/create_order")
    ObjectResponse<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        log.info("请求订单微服务：{}",orderDTO.toString());
        return orderService.createOrder(orderDTO);
    }
}
