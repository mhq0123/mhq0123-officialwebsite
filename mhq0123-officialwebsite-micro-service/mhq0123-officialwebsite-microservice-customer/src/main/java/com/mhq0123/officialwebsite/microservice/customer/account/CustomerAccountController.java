package com.mhq0123.officialwebsite.microservice.customer.account;

import com.mhq0123.officialwebsite.microservice.customer.account.service.CustomerAccountService;
import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public int insert(@RequestBody CustomerAccount insertBean) {
        // 校验
        if(null == insertBean) {
            throw new IllegalArgumentException("insertBean对象不可为空");
        }
        // 栏位校验 TODO 引入校验框架
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(insertBean);
        if(null != violations && !violations.isEmpty()) {
            ConstraintViolation constraintViolation = violations.get(0);
            logger.error(">>>>>>>>>>>>>>field:{},value:{},errorMessage:{}", constraintViolation.getCheckName(), constraintViolation.getInvalidValue(), constraintViolation.getMessage());
            throw new IllegalArgumentException(constraintViolation.getMessage());
        }

        return customerAccountService.insert(insertBean);
    }

    /**
     * 根据唯一字段查询账号
     * @param uniqueField
     * @param fieldValue
     * @return
     */
    @GetMapping(MicroServiceCustomerDictionary.PathAccount.SELECT_BY_UNIQUE_FIELD)
    public CustomerAccount selectByUniqueField(@RequestParam("accountUniqueField") MicroServiceCustomerDictionary.AccountUniqueField uniqueField, @RequestParam("fieldValue") String fieldValue) {
        // 校验
        if(null == uniqueField) {
            throw new IllegalArgumentException("校验字段类型不能为空");
        }
        if(StringUtils.isEmpty(fieldValue)) {
            throw new IllegalArgumentException("字段值不能为空");
        }
        return customerAccountService.selectByUniqueField(uniqueField, fieldValue);
    }

    /**
     * 账号操作 - 根据索引编号修改账号
     * @param updateBean
     * @return
     */
    @GetMapping(MicroServiceCustomerDictionary.PathAccount.UPDATE_BY_ID)
    public int updateById(@RequestBody CustomerAccount updateBean) {
        // 校验
        if(null == updateBean) {
            throw new IllegalArgumentException("updateBean对象不可为空");
        }
        if(updateBean.getAccountId() < 1) {
            throw new IllegalArgumentException("用户索引编号不可为空");
        }
        return customerAccountService.updateById(updateBean);
    }

    /**
     * 账号操作 - 根据索引编号冻结账号
     * @param accountId
     * @return
     */
    @GetMapping(MicroServiceCustomerDictionary.PathAccount.FREEZE_BY_ID)
    public int freezeById(@RequestParam("accountId") int accountId) {
        // 校验
        if(accountId < 1) {
            throw new IllegalArgumentException("用户索引编号不可为空");
        }
        return customerAccountService.freezeById(accountId);
    }

    /**
     * 账号操作 - 根据索引编号解冻账号
     * @param accountId
     * @return
     */
    @GetMapping(MicroServiceCustomerDictionary.PathAccount.UNFREEZE_BY_ID)
    public int unfreezeById(@RequestParam("accountId") int accountId) {
        // 校验
        if(accountId < 1) {
            throw new IllegalArgumentException("用户索引编号不可为空");
        }
        return customerAccountService.unfreezeById(accountId);
    }

    /**
     * 账号操作 - 根据索引编号注销账号
     * @param accountId
     * @return
     */
    @GetMapping(MicroServiceCustomerDictionary.PathAccount.CANCEL_BY_ID)
    public int cancelById(@RequestParam("accountId") int accountId) {
        // 校验
        if(accountId < 1) {
            throw new IllegalArgumentException("用户索引编号不可为空");
        }
        return customerAccountService.cancelById(accountId);
    }

}
