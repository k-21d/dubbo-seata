package com.k21d.springboot.account.provider.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.k21d.springboot.account.provider.entity.Account;
import com.k21d.springboot.account.provider.mapper.AccountMapper;
import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.enums.RspStatusEnum;
import com.k21d.springboot.api.response.ObjectResponse;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalLock;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;

    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        int account = accountMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (account > 0){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
    @GlobalLock
    @Transactional(rollbackFor = {Throwable.class})
    public void testGlobalLock() {
        accountMapper.testGlobalLock("1");
        System.out.println("Hi, i got lock, i will do some thing with holding this lock.");
    }
}
