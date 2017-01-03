package com.mhq0123.officialwebsite.microservice.customer.account.mapper;

import com.mhq0123.officialwebsite.microservice.customer.account.bean.CustomerAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 */
@Mapper
public interface CustomerAccountMapper {

    /**
     * 单个写入
     * @param insertBean
     * @return
     */
    int insert(CustomerAccount insertBean);

    /**
     * 根据索引编号删除
     * @param accountId
     * @return
     */
    int deleteById(int accountId);

    /**
     * 根据索引编号修改
     * @param updateBean
     * @return
     */
    int updateById(CustomerAccount updateBean);

    /**
     * 根据唯一栏位查询
     * @param selectBean
     * @return
     */
    CustomerAccount selectByUniqueField(CustomerAccount selectBean);

}