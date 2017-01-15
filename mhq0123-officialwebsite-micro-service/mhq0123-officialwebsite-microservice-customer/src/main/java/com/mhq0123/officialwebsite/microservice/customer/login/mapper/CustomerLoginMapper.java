package com.mhq0123.officialwebsite.microservice.customer.login.mapper;

import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/15.
 * desc:    登陆表操作
 */
@Mapper
public interface CustomerLoginMapper {

    /**
     * 写入
     * @param insertBean
     * @return
     */
    int insert(CustomerLogin insertBean);

    /**
     * 根据索引编号查询
     * @param loginId
     * @return
     */
    CustomerLogin selectById(@Param("loginId") int loginId);

    /**
     * 根据索引编号删除
     * @param loginId
     * @return
     */
    int deleteById(@Param("loginId") int loginId);
}
