package com.k21d.springboot.account.provider.service;

import com.k21d.springboot.account.provider.mapper.AccountMapper;
import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.service.IAccountService;
import io.seata.spring.annotation.GlobalLock;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;

    public String decreaseAccount(AccountDTO accountDTO) {
        int account = accountMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        if (account>0){
            return "ok";
        }
        return "fail";
    }
    @GlobalLock
    @Transactional(rollbackFor = {Throwable.class})
    public void testGlobalLock() {
        accountMapper.testGlobalLock("1");
        System.out.println("Hi, i got lock, i will do some thing with holding this lock.");
    }
}
