package com.mhq0123.officialwebsite.microservice.customer.account;

import com.mhq0123.officialwebsite.microservice.customer.account.service.CustomerAccountService;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.CustomerAccountPath;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean.CustomerAccount;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/7.
 * desc:    客户账户
 */
@RestController
public class CustomerAccountController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountController.class);

    @Autowired
    private CustomerAccountService customerAccountService;

    /**
     * 账号操作 - 新增账号
     * @param insertBean
     * @return
     */
    @PostMapping(CustomerAccountPath.INSERT)
    public int insert(@RequestBody CustomerAccount insertBean) {
        // 校验
        if(null == insertBean) {
            throw new IllegalArgumentException("新增对象不可为空");
        }
        // 栏位校验
        OvalUtils.validate(insertBean, "insert");

        return customerAccountService.insert(insertBean);
    }

    /**
     * 根据索引编号查询账号
     * @param accountId
     * @return
     */
    @PostMapping(CustomerAccountPath.SELECT_BY_ID)
    public CustomerAccount selectById(@RequestParam("accountId") int accountId) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setAccountId(accountId), "accountId");

        return customerAccountService.selectById(accountId);
    }

    /**
     * 根据用户名查询账号
     * @param accountName
     * @return
     */
    @PostMapping(CustomerAccountPath.SELECT_BY_NAME)
    public CustomerAccount selectByName(@RequestParam("accountName") String accountName) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setAccountName(accountName), "accountName");

        return customerAccountService.selectByName(accountName);
    }

    /**
     * 根据邮箱查询账号
     * @param email
     * @return
     */
    @PostMapping(CustomerAccountPath.SELECT_BY_EMAIL)
    public CustomerAccount selectByEmail(@RequestParam("mapper") String email) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setEmail(email), "mapper");

        return customerAccountService.selectByEmail(email);
    }

    /**
     * 账号操作 - 根据索引编号修改账号
     * @param updateBean
     * @return
     */
    @PostMapping(CustomerAccountPath.UPDATE_BY_ID)
    public int updateById(@RequestBody CustomerAccount updateBean) {
        // 校验
        if(null == updateBean) {
            throw new IllegalArgumentException("修改对象不可为空");
        }
        OvalUtils.validate(updateBean, "accountId");

        return customerAccountService.updateById(updateBean);
    }

    /**
     * 账号操作 - 根据用户名修改账号
     * @param updateBean
     * @return
     */
    @PostMapping(CustomerAccountPath.UPDATE_BY_NAME)
    public int updateByName(@RequestBody CustomerAccount updateBean) {
        // 校验
        if(null == updateBean) {
            throw new IllegalArgumentException("修改对象不可为空");
        }
        OvalUtils.validate(updateBean, "accountName");

        return customerAccountService.updateByName(updateBean);
    }

    /**
     * 账号操作 - 根据索引编号冻结账号
     * @param accountId
     * @return
     */
    @PostMapping(CustomerAccountPath.FREEZE_BY_ID)
    public int freezeById(@RequestParam("accountId") int accountId) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setAccountId(accountId), "accountId");

        return customerAccountService.freezeById(accountId);
    }

    /**
     * 账号操作 - 根据索引编号解冻账号
     * @param accountId
     * @return
     */
    @PostMapping(CustomerAccountPath.UNFREEZE_BY_ID)
    public int unfreezeById(@RequestParam("accountId") int accountId) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setAccountId(accountId), "accountId");

        return customerAccountService.unfreezeById(accountId);
    }

    /**
     * 账号操作 - 根据索引编号注销账号
     * @param accountId
     * @return
     */
    @PostMapping(CustomerAccountPath.CANCEL_BY_ID)
    public int cancelById(@RequestParam("accountId") int accountId) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setAccountId(accountId), "accountId");

        return customerAccountService.cancelById(accountId);
    }

}
