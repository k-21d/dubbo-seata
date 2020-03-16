package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.CommodityDTO;

public interface IStorageService {
    String decreaseStorage(CommodityDTO commodityDTO);
}
