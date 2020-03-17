package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.BusinessDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IBusinessDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
@Slf4j
public class BusinessController {
    @Reference(retries = 0)
    IBusinessDubboService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    ObjectResponse handleBusiness(@RequestBody BusinessDTO businessDTO){
        log.info("请求参数：{}",businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }
}
