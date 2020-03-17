package com.k21d.springboot.account.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.k21d.springboot.account.provider.entity.Account;
import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.response.ObjectResponse;

public interface IAccountService extends IService<Account> {

    /**
     * 扣用户钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);

    void testGlobalLock();
}

