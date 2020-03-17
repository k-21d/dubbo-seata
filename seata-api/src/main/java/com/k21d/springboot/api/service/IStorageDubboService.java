package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.CommodityDTO;
import com.k21d.springboot.api.response.ObjectResponse;

public interface IStorageDubboService {
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
