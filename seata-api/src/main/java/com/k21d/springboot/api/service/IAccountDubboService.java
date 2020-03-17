package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.response.ObjectResponse;

public interface IAccountDubboService {
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
