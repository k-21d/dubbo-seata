package com.k21d.springboot.account.provider.dubbo;

import com.k21d.springboot.account.provider.service.IAccountService;
import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.response.ObjectResponse;
import com.k21d.springboot.api.service.IAccountDubboService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AccountDubboServiceImpl implements IAccountDubboService {
    @Autowired
    private IAccountService accountService;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return accountService.decreaseAccount(accountDTO);
    }

}
