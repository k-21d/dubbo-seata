package com.k21d.springboot.bussiness.provider.service;

import com.k21d.springboot.api.entity.BusinessDTO;
import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.service.IBusinessService;
import com.k21d.springboot.api.service.IOrderService;
import com.k21d.springboot.api.service.IStorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

@Service
public class BusinessServiceImpl implements IBusinessService {

    @Reference
    private IStorageService storageService;

    @Reference
    private IOrderService orderService;

    private boolean flag;

    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    public Object handleBusiness(BusinessDTO businessDTO) {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        //1、扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());

        String storageResult = storageService.decreaseStorage(commodityDTO);
        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        String orderResult = orderService.createOrder(orderDTO);

        //打开注释测试事务发生异常后，全局回滚功能
//        if (!flag) {
//            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
//        }

        if (storageResult.equals("fail") || orderResult.equals("fail")) {
            throw new RuntimeException("bussiness exception");
        }
        return "ok";
    }
}
