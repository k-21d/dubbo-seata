package com.k21d.springboot.controller;

import com.k21d.springboot.api.entity.AccountDTO;
import com.k21d.springboot.api.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {
    @Reference
    private IAccountService accountService;

    @PostMapping("/dec_account")
    String decreaseAccount(@RequestBody AccountDTO accountDTO) {
        log.info("请求账户微服务：{}",accountDTO.toString());
        return accountService.decreaseAccount(accountDTO);
    }

    @GetMapping("/test_global_lock")
    void testGlobalLock() {
        log.info("testGlobalLock");
        accountService.testGlobalLock();
    }
}
