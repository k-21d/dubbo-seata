package com.k21d.springboot.storage.provider.dubbo;

import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IStorageDubboService;
import com.k21d.springboot.storage.provider.service.IStorageService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StorageDubboDubboServiceImpl implements IStorageDubboService {
    @Autowired
    private IStorageService storageService;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }



}
