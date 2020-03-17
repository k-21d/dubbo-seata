package com.k21d.springboot.storage.provider.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.enums.RspStatusEnum;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.storage.provider.entity.Storage;
import com.k21d.springboot.storage.provider.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        int storage = storageMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ObjectResponse<Object> response = new ObjectResponse<>();

        if (storage > 0){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }


}
