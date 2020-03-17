package com.k21d.springboot.storage.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.storage.provider.entity.Storage;

public interface IStorageService extends IService<Storage> {
    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
