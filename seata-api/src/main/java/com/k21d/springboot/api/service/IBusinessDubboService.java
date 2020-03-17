package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.BusinessDTO;
import com.k21d.springboot.api.response.ObjectResponse;

public interface IBusinessDubboService {
    ObjectResponse handleBusiness(BusinessDTO businessDTO);
}
