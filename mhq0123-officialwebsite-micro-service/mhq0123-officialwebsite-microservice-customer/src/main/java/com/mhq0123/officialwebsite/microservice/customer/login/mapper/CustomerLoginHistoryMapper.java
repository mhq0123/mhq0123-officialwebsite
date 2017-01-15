package com.mhq0123.officialwebsite.microservice.customer.login.mapper;

import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLoginHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/15.
 * desc:    登陆历史表
 */
@Mapper
public interface CustomerLoginHistoryMapper {

    /**
     * 写入单个
     * @param insertBean
     * @return
     */
    int insert(CustomerLoginHistory insertBean);
}
