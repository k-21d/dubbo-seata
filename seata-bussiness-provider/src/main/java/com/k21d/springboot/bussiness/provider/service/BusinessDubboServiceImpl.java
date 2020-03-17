package com.k21d.springboot.bussiness.provider.service;

import com.k21d.springboot.api.entity.BusinessDTO;
import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.entity.OrderDTO;
import com.k21d.springboot.api.enums.RspStatusEnum;
import com.k21d.springboot.api.exception.DefaultException;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IBusinessDubboService;
import com.k21d.springboot.api.service.IOrderDubboService;
import com.k21d.springboot.api.service.IStorageDubboService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

@Service
@Slf4j
public class BusinessDubboServiceImpl implements IBusinessDubboService {

    @Reference
    private IStorageDubboService storageService;

    @Reference
    private IOrderDubboService orderService;

    private boolean flag;

    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    public ObjectResponse handleBusiness(BusinessDTO businessDTO) {
        log.info("开始全局事务，XID = " + RootContext.getXID());
        ObjectResponse<Object> objectResponse = new ObjectResponse<>();
        //1、扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());


        ObjectResponse storageResponse = storageService.decreaseStorage(commodityDTO);
        //打开注释测试事务发生异常后，全局回滚功能


        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        ObjectResponse<OrderDTO> response = orderService.createOrder(orderDTO);
        if (!flag) {
            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        }

        if (storageResponse.getStatus() != 200 || response.getStatus() != 200) {
            throw new DefaultException(RspStatusEnum.FAIL);
        }

        objectResponse.setStatus(RspStatusEnum.SUCCESS.getCode());
        objectResponse.setMessage(RspStatusEnum.SUCCESS.getMessage());
        objectResponse.setData(response.getData());
        return objectResponse;
    }
}
