package com.k21d.springboot.storage.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.k21d.springboot.storage.provider.entity.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper extends BaseMapper<Storage> {

    /**
     * 扣减商品库存
     * @Param: commodityCode 商品code  count扣减数量
     * @Return:
     */
    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
