package com.mhq0123.officialwebsite.microservice.customer.invoker;

import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:    接口定义 这里必须主动申明方法名 TODO 不能写成GetMapping
 */
@FeignClient(value = MicroServiceCustomerDictionary.SERVICE_ID, fallback = MicroServiceCustomerHystrix.class)
public interface MicroServiceCustomerClient {

    /**
     * 账号操作 -账号
     * @param insertBean
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.INSERT, method = RequestMethod.POST)
    int accountInsert(@RequestBody CustomerAccount insertBean);

    /**
     * 账号操作 - 根据索引编号查询账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.SELECT_BY_ID, method = RequestMethod.POST)
    CustomerAccount accountSelectById(@RequestParam("accountId") int accountId);

    /**
     * 账号操作 - 根据用户名查询账号
     * @param accountName
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.SELECT_BY_NAME, method = RequestMethod.POST)
    CustomerAccount accountSelectByName(@RequestParam("accountName") String accountName);

    /**
     * 账号操作 - 根据邮箱查询账号
     * @param email
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.SELECT_BY_EMAIL, method = RequestMethod.POST)
    CustomerAccount accountSelectByEmail(@RequestParam("mapper") String email);

    /**
     * 账号操作 - 根据索引编号修改账号
     * @param updateBean
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.UPDATE_BY_ID, method = RequestMethod.POST)
    int accountUpdateById(@RequestBody CustomerAccount updateBean);

    /**
     * 账号操作 - 根据索引编号冻结账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.FREEZE_BY_ID, method = RequestMethod.POST)
    int accountFreezeById(@RequestParam("accountId") int accountId);

    /**
     * 账号操作 - 根据索引编号解冻账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.UNFREEZE_BY_ID, method = RequestMethod.POST)
    int accountUnfreezeById(@RequestParam("accountId") int accountId);

    /**
     * 账号操作 - 根据索引编号注销账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = MicroServiceCustomerDictionary.PathAccount.CANCEL_BY_ID, method = RequestMethod.POST)
    int accountCancelById(@RequestParam("accountId") int accountId);
}
