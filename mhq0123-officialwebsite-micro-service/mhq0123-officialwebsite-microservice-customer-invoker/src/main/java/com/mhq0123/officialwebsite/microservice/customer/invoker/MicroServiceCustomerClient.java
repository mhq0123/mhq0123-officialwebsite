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
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.Path.ACCOUNT_INSERT)
    int accountInsert();

    /**
     * 账号操作 - 根据唯一字段查询账号
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.Path.ACCOUNT_SELECT_BY_UNIQUE_FIELD)
    CustomerAccount accountSelectByUniqueField();

    /**
     * 账号操作 - 根据索引编号修改账号
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.Path.ACCOUNT_UPDATE_BY_ID)
    int accountUpdateById();

    /**
     * 账号操作 - 根据索引编号冻结账号
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.Path.ACCOUNT_FREEZE_BY_ID)
    int accountFreezeById();

    /**
     * 账号操作 - 根据索引编号解冻账号
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.Path.ACCOUNT_UNFREEZE_BY_ID)
    int accountUnfreezeById();

    /**
     * 账号操作 - 根据索引编号注销账号
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.Path.ACCOUNT_CANCEL_BY_ID)
    int accountCancelById();
}
