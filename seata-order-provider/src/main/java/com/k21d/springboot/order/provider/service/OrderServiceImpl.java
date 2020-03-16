package com.k21d.springboot.order.provider.service;

import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.service.IAccountService;
import com.k21d.springboot.api.service.IOrderService;
import com.k21d.springboot.order.provider.entity.Order;
import com.k21d.springboot.order.provider.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {
    @Reference(check = false)
    IAccountService accountService;

    @Autowired
    private OrderMapper orderMapper;

    public String createOrder(OrderDTO orderDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        String decreaseAccount = accountService.decreaseAccount(accountDTO);
        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        order.setCount(orderDTO.getOrderCount());
        order.setAmount(orderDTO.getOrderAmount());

        try {
            orderMapper.createOrder(order);
        }catch (Exception e){
            return "fail";
        }
        return decreaseAccount;
    }
}
