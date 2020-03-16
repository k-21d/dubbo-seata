package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.BusinessDTO;

public interface IBusinessService {
    Object handleBusiness(BusinessDTO businessDTO);
}
