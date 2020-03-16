package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.service.IStorageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Reference
    private IStorageService storageService;

    /**
     * 扣减库存
     */
    @PostMapping("dec_storage")
    String decreaseStorage(@RequestBody CommodityDTO commodityDTO){
        System.out.printf("请求库存微服务：{%s}",commodityDTO.toString());
        return storageService.decreaseStorage(commodityDTO);
    }
}
