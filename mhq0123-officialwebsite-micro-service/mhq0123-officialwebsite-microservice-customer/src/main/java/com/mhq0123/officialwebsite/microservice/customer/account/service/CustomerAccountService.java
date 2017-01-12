package com.mhq0123.officialwebsite.microservice.customer.account.service;

import com.mhq0123.officialwebsite.microservice.customer.account.mapper.CustomerAccountHistoryMapper;
import com.mhq0123.officialwebsite.microservice.customer.account.mapper.CustomerAccountMapper;
import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccountHistory;
import org.mhq0123.springleaf.common.utils.CipherUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@Service
public class CustomerAccountService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountService.class);

    @Autowired
    private CustomerAccountMapper customerAccountMapper;
    @Autowired
    private CustomerAccountHistoryMapper customerAccountHistoryMapper;

    /**
     * 写入
     * @param insertBean
     * @return
     */
    public int insert(CustomerAccount insertBean) {
        // 唯一性校验用户名
        CustomerAccount accountNameBean = customerAccountMapper.selectByName(insertBean.getAccountName());
        if(null != accountNameBean) {
            throw new IllegalArgumentException("用户名已存在");
        }
        // 唯一性校验邮箱
        CustomerAccount emailBean = customerAccountMapper.selectByEmail(insertBean.getEmail());
        if(null != emailBean) {
            throw new IllegalArgumentException("邮箱已存在");
        }
        // 加密密码
        insertBean.setPassword(CipherUtils.encryptPassword(insertBean.getAccountName(), insertBean.getPassword()));
        // 状态赋值
        insertBean.setStatus(MicroServiceCustomerDictionary.AccountStatus.VALID);
        // 写入
        return customerAccountMapper.insert(insertBean);
    }

    /**
     * 根据索引编号查询
     * @param accountId
     * @return
     */
    public CustomerAccount selectById(int accountId) {
        // 查询
        return customerAccountMapper.selectById(accountId);
    }

    /**
     * 根据用户名查询
     * @param accountName
     * @return
     */
    public CustomerAccount selectByName(String accountName) {
        // 查询
        return customerAccountMapper.selectByName(accountName);
    }

    /**
     * 根据邮箱查询
     * @param email
     * @return
     */
    public CustomerAccount selectByEmail(String email) {
        // 查询
        return customerAccountMapper.selectByEmail(email);
    }

    /**
     * 修改
     * @param updateBean
     * @return
     */
    @Transactional
    public int updateById(CustomerAccount updateBean) {
        // 查询修改对象
        CustomerAccount selectBean = customerAccountMapper.selectById(updateBean.getAccountId());
        if(null == selectBean) {
            throw new IllegalArgumentException("用户不存在");
        }

        // 写入历史表
        CustomerAccountHistory insertBean = new CustomerAccountHistory();
        BeanUtils.copyProperties(selectBean, insertBean);
        insertBean.setOperateType(MicroServiceCustomerDictionary.AccountOperateType.UPDATE);
        customerAccountHistoryMapper.insert(insertBean);

        // 更新当前表
        return customerAccountMapper.updateById(updateBean);
    }

    /**
     * 冻结用户
     * @param accountId
     * @return
     */
    @Transactional
    public int freezeById(int accountId) {
        // 查询冻结对象
        CustomerAccount selectBean = customerAccountMapper.selectById(accountId);
        if(null == selectBean) {
            throw new IllegalArgumentException("用户不存在");
        }

        // 写入历史表
        CustomerAccountHistory insertBean = new CustomerAccountHistory();
        BeanUtils.copyProperties(selectBean, insertBean);
        insertBean.setOperateType(MicroServiceCustomerDictionary.AccountOperateType.FREEZE);
        customerAccountHistoryMapper.insert(insertBean);

        // 冻结bean
        CustomerAccount freezeBean = new CustomerAccount();
        freezeBean.setAccountId(accountId);
        freezeBean.setStatus(MicroServiceCustomerDictionary.AccountStatus.FREEZE);

        return customerAccountMapper.updateById(freezeBean);
    }

    /**
     * 解冻用户
     * @param accountId
     * @return
     */
    @Transactional
    public int unfreezeById(int accountId) {
        // 查询解冻对象
        CustomerAccount selectBean = customerAccountMapper.selectById(accountId);
        if(null == selectBean) {
            throw new IllegalArgumentException("用户不存在");
        }

        // 写入历史表
        CustomerAccountHistory insertBean = new CustomerAccountHistory();
        BeanUtils.copyProperties(selectBean, insertBean);
        insertBean.setOperateType(MicroServiceCustomerDictionary.AccountOperateType.UNFREEZE);
        customerAccountHistoryMapper.insert(insertBean);

        // 解冻bean
        CustomerAccount unfreezeBean = new CustomerAccount();
        unfreezeBean.setAccountId(accountId);
        unfreezeBean.setStatus(MicroServiceCustomerDictionary.AccountStatus.VALID);

        return customerAccountMapper.updateById(unfreezeBean);
    }

    /**
     * 注销用户
     * @param accountId
     * @return
     */
    @Transactional
    public int cancelById(int accountId) {
        // 查询注销对象
        CustomerAccount selectBean = customerAccountMapper.selectById(accountId);
        if(null == selectBean) {
            throw new IllegalArgumentException("用户不存在");
        }

        // 写入历史表
        CustomerAccountHistory insertBean = new CustomerAccountHistory();
        BeanUtils.copyProperties(selectBean, insertBean);
        insertBean.setOperateType(MicroServiceCustomerDictionary.AccountOperateType.CANCEL);
        customerAccountHistoryMapper.insert(insertBean);

        // 注销bean
        CustomerAccount cancelBean = new CustomerAccount();
        cancelBean.setAccountId(accountId);
        cancelBean.setStatus(MicroServiceCustomerDictionary.AccountStatus.CANCEL);

        return customerAccountMapper.updateById(cancelBean);
    }

}
