package com.k21d.springboot.storage.provider.service;

import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.service.IStorageService;
import com.k21d.springboot.storage.provider.mapper.StorageMapper;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StorageServiceImpl implements IStorageService {
    @Autowired
    private StorageMapper storageMapper;
    public String decreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        int storage = storageMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        if (storage > 0){
            return "ok";
        }
        return "fail";
    }
}
