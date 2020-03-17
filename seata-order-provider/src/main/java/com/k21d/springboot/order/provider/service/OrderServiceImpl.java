package com.k21d.springboot.order.provider.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.enums.RspStatusEnum;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IAccountDubboService;
import com.k21d.springboot.order.provider.entity.Order;
import com.k21d.springboot.order.provider.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Reference
    IAccountDubboService accountDubboService;

    @Autowired
    private OrderMapper orderMapper;

    public ObjectResponse createOrder(OrderDTO orderDTO) {
        ObjectResponse<OrderDTO> response = new ObjectResponse<>();
        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        ObjectResponse objectResponse = accountDubboService.decreaseAccount(accountDTO);
        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        order.setCount(orderDTO.getOrderCount());
        order.setAmount(orderDTO.getOrderAmount());

        try {
            orderMapper.insert(order);
        }catch (Exception e){
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }
        if (objectResponse.getStatus() != 200) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.SUCCESS.getCode());
        response.setMessage(RspStatusEnum.SUCCESS.getMessage());
        return response;
    }
}
