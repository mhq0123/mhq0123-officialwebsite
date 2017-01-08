package com.mhq0123.officialwebsite.microservice.customer.account;

import com.alibaba.fastjson.JSONObject;
import com.mhq0123.officialwebsite.microservice.customer.account.service.CustomerAccountService;
import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.INSERT)
    public int insert(CustomerAccount insertBean) {
        logger.info(">>>>>>>>>>>>>>接收参数insertBean:{}", JSONObject.toJSONString(insertBean, true));

        return customerAccountService.accountInsert(insertBean);
    }

    /**
     * 账号操作 - 根据唯一字段查询账号
     * @param accountUniqueField
     * @param fieldValue
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.SELECT_BY_UNIQUE_FIELD)
    public CustomerAccount selectByUniqueField(MicroServiceCustomerDictionary.EnumAccountUniqueField accountUniqueField, String fieldValue) {

    }

    /**
     * 账号操作 - 根据索引编号修改账号
     * @param updateBean
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.UPDATE_BY_ID)
    public int updateById(CustomerAccount updateBean) {

    }

    /**
     * 账号操作 - 根据索引编号冻结账号
     * @param accountId
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.FREEZE_BY_ID)
    public int freezeById(String accountId) {

    }

    /**
     * 账号操作 - 根据索引编号解冻账号
     * @param accountId
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.UNFREEZE_BY_ID)
    public int unfreezeById(String accountId) {

    }

    /**
     * 账号操作 - 根据索引编号注销账号
     * @param accountId
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathAccount.CANCEL_BY_ID)
    public int cancelById(String accountId) {

    }

}
