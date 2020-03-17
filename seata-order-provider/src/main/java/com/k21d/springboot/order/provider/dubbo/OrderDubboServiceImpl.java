package com.k21d.springboot.order.provider.dubbo;

import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IOrderDubboService;
import com.k21d.springboot.order.provider.service.IOrderService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderDubboServiceImpl implements IOrderDubboService {
    @Autowired
    private IOrderService orderService;

    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return orderService.createOrder(orderDTO);
    }
}
