package com.k21d.springboot.api.service;

import com.k21d.springboot.api.entity.AccountDTO;

public interface IAccountService {
    String decreaseAccount(AccountDTO accountDTO);

    void testGlobalLock();
}
