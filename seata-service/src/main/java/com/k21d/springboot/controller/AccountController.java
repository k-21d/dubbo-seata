package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.service.IAccountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Reference
    private IAccountService accountService;

    @PostMapping("/dec_account")
    String decreaseAccount(@RequestBody AccountDTO accountDTO) {
        System.out.printf("请求账户微服务：{%s}",accountDTO.toString());
        return accountService.decreaseAccount(accountDTO);
    }

    @GetMapping("/test_global_lock")
    void testGlobalLock() {
        System.out.println("testGlobalLock");
        accountService.testGlobalLock();
    }
}
