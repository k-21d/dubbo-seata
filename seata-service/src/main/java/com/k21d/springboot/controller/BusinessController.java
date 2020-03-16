package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.BusinessDTO;
import com.k21d.springboot.api.service.IBusinessService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business/dubbo")
public class BusinessController {
    @Reference
    IBusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    Object handleBusiness(@RequestBody BusinessDTO businessDTO){
        return businessService.handleBusiness(businessDTO);
    }
}
