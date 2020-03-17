package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IStorageDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
@Slf4j
public class StorageController {
    @Reference
    private IStorageDubboService storageService;

    /**
     * 扣减库存
     */
    @PostMapping("dec_storage")
    ObjectResponse decreaseStorage(@RequestBody CommodityDTO commodityDTO){
        log.info("请求库存微服务：{}",commodityDTO.toString());
        return storageService.decreaseStorage(commodityDTO);
    }
}
