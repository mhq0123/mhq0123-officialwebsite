package com.mhq0123.officialwebsite.microservice.customer.invoker;

import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:    接口定义
 */
@FeignClient(value = MicroServiceCustomerDictionary.SERVICE_ID, fallback = MicroServiceCustomerHystrix.class)
public interface MicroServiceCustomerClient {

    /**
     * 账号操作 - 新增账号
     * @param insertBean
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.INSERT)
    int accountInsert(CustomerAccount insertBean);

    /**
     * 账号操作 - 根据唯一字段查询账号
     * @param accountUniqueField
     * @param fieldValue
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.SELECT_BY_UNIQUE_FIELD)
    CustomerAccount accountSelectByUniqueField(MicroServiceCustomerDictionary.AccountUniqueField accountUniqueField, String fieldValue);

    /**
     * 账号操作 - 根据索引编号修改账号
     * @param updateBean
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.UPDATE_BY_ID)
    int accountUpdateById(CustomerAccount updateBean);

    /**
     * 账号操作 - 根据索引编号冻结账号
     * @param accountId
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.FREEZE_BY_ID)
    int accountFreezeById(int accountId);

    /**
     * 账号操作 - 根据索引编号解冻账号
     * @param accountId
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.UNFREEZE_BY_ID)
    int accountUnfreezeById(int accountId);

    /**
     * 账号操作 - 根据索引编号注销账号
     * @param accountId
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.CANCEL_BY_ID)
    int accountCancelById(int accountId);
}
