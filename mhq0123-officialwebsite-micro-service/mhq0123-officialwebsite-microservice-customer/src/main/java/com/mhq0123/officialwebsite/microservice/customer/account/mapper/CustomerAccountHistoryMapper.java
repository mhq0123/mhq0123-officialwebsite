package com.mhq0123.officialwebsite.microservice.customer.account.mapper;

import com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean.CustomerAccountHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/9.
 * desc:
 */
@Mapper
public interface CustomerAccountHistoryMapper {

    /**
     * 单个写入
     * @param insertBean
     * @return
     */
    int insert(CustomerAccountHistory insertBean);
}
