package com.mhq0123.officialwebsite.microservice.customer.invoker.account;

import com.mhq0123.officialwebsite.microservice.customer.invoker.CustomerInvokerConstant;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean.CustomerAccount;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.hystrix.CustomerAccountHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:    接口定义 这里必须主动申明方法名 TODO 不能写成GetMapping
 */
@FeignClient(value = CustomerInvokerConstant.SERVICE_ID, fallback = CustomerAccountHystrix.class)
public interface CustomerAccountClient {

    /**
     * 账号操作 -账号
     * @param insertBean
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.INSERT, method = RequestMethod.POST)
    int insert(@RequestBody CustomerAccount insertBean);

    /**
     * 账号操作 - 根据索引编号查询账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.SELECT_BY_ID, method = RequestMethod.POST)
    CustomerAccount selectById(@RequestParam("accountId") int accountId);

    /**
     * 账号操作 - 根据用户名查询账号
     * @param accountName
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.SELECT_BY_NAME, method = RequestMethod.POST)
    CustomerAccount selectByName(@RequestParam("accountName") String accountName);

    /**
     * 账号操作 - 根据邮箱查询账号
     * @param email
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.SELECT_BY_EMAIL, method = RequestMethod.POST)
    CustomerAccount selectByEmail(@RequestParam("mapper") String email);

    /**
     * 账号操作 - 根据索引编号修改账号
     * @param updateBean
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.UPDATE_BY_ID, method = RequestMethod.POST)
    int updateById(@RequestBody CustomerAccount updateBean);

    /**
     * 账号操作 - 根据用户名修改账号
     * @param updateBean
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.UPDATE_BY_NAME, method = RequestMethod.POST)
    int updateByName(@RequestBody CustomerAccount updateBean);

    /**
     * 账号操作 - 根据索引编号冻结账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.FREEZE_BY_ID, method = RequestMethod.POST)
    int freezeById(@RequestParam("accountId") int accountId);

    /**
     * 账号操作 - 根据索引编号解冻账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.UNFREEZE_BY_ID, method = RequestMethod.POST)
    int unfreezeById(@RequestParam("accountId") int accountId);

    /**
     * 账号操作 - 根据索引编号注销账号
     * @param accountId
     * @return
     */
    @RequestMapping(value = CustomerAccountPath.CANCEL_BY_ID, method = RequestMethod.POST)
    int cancelById(@RequestParam("accountId") int accountId);
}
