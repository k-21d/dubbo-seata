package com.k21d.springboot.account.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.k21d.springboot.account.provider.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends BaseMapper<Account> {
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);

    int testGlobalLock(@Param("userId") String userId);
}
