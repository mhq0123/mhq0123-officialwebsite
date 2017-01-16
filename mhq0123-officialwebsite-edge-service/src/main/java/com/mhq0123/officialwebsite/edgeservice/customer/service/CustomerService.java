package com.mhq0123.officialwebsite.edgeservice.customer.service;

import com.mhq0123.officialwebsite.microservice.customer.invoker.account.CustomerAccountClient;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean.CustomerAccount;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.CustomerLoginClient;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLogin;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.SmsEmailClient;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.bean.SmsEmail;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.type.SmsEmailType;
import org.apache.commons.lang3.RandomStringUtils;
import org.mhq0123.springleaf.common.utils.CipherUtils;
import org.mhq0123.springleaf.common.utils.ThreadLocalUtils;
import org.mhq0123.springleaf.core.SpringleafCoreConstants;
import org.mhq0123.springleaf.core.utils.EhcacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/15.
 * desc:
 */
@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerAccountClient customerAccountClient;
    @Autowired
    private CustomerLoginClient customerLoginClient;
    @Autowired
    private SmsEmailClient smsEmailClient;

    /**
     * 校验并发送验证码
     * @param accountName
     * @param email
     */
    public void checkExistAndSendVerificationCode(String accountName, String email) {
        // 业务逻辑校验
        CustomerAccount selectNameBean = customerAccountClient.selectByName(accountName);
        if(null != selectNameBean) {
            throw new IllegalArgumentException("用户名已存在");
        }
        CustomerAccount selectEmailBean = customerAccountClient.selectByEmail(email);
        if(null != selectEmailBean) {
            throw new IllegalArgumentException("邮箱已存在");
        }
        // 生成验证码、并缓存 随机产生6位数字
        String verificationCode = RandomStringUtils.randomNumeric(6);
        EhcacheUtils.instance().cachePut("VerificationCode", "name_" + accountName + "email_" + email, verificationCode);
        // 发送邮箱
        SmsEmail smsEmail = new SmsEmail();
        smsEmail.setSubject(SmsEmailType.Subject.VERIFICATION_CODE);
        smsEmail.setEmailTo(email);
        smsEmail.setUseTemplate(true);
        smsEmail.setHtml(true);

        Map<String, Object> templateVariableMap = new HashMap<>();
        templateVariableMap.put("verificationCode", verificationCode);
        smsEmail.setTemplateVariableMap(templateVariableMap);

        smsEmailClient.storageAndSend(smsEmail);
    }

    /**
     * 注册
     * @param registerBean
     */
    public void register(CustomerAccount registerBean) {
        // 验证码校验
        String verificationCode = (String)EhcacheUtils.instance().cacheGet("VerificationCode", "name_" + registerBean.getAccountName() + "email_" + registerBean.getEmail());
        if(null == verificationCode) {
            throw new IllegalArgumentException("验证码已过期");
        }
        if(!verificationCode.equals(registerBean.getVerificationCode())) {
            throw new IllegalArgumentException("验证码有误");
        }
        // 写入数据库
        customerAccountClient.insert(registerBean);
    }

    /**
     * 登陆
     * @param loginBean
     * @return
     */
    public CustomerAccount login(CustomerLogin loginBean) {
        // 查询用户
        CustomerAccount selectBean = customerAccountClient.selectByName(loginBean.getAccountName());
        if(null == selectBean) {
            throw new IllegalArgumentException("用户名不存在");
        }
        // 校验密码
        if(!CipherUtils.encryptPassword(loginBean.getAccountName(), loginBean.getPassword()).equals(selectBean.getPassword())) {
            throw new IllegalArgumentException("密码不正确");
        }
        // 写入登陆表
        loginBean.setAccountId(selectBean.getAccountId());
        loginBean.setNetworkAddress(ThreadLocalUtils.get(SpringleafCoreConstants.Request.IP, String.class));

        int loginId = customerLoginClient.login(loginBean);
        // 返回用户对象
        return selectBean.setLoginId(loginId);
    }

    /**
     * 登出
     * @param logoutBean
     */
    public void logout(CustomerLogin logoutBean) {
        // 查询登陆对象
        customerLoginClient.logout(logoutBean);
    }

    /**
     * 校验并发送验证码
     * @param accountName
     * @param email
     */
    public void checkMatchAndSendVerificationCode(String accountName, String email) {
        // 业务逻辑校验
        CustomerAccount selectNameBean = customerAccountClient.selectByName(accountName);
        if(null == selectNameBean) {
            throw new IllegalArgumentException("用户名不存在");
        }
        if(!email.equals(selectNameBean.getEmail())) {
            throw new IllegalArgumentException("邮箱与账号不匹配");
        }
        // 生成验证码、并缓存 随机产生6位数字
        String verificationCode = RandomStringUtils.randomNumeric(6);
        EhcacheUtils.instance().cachePut("VerificationCode", "name_" + accountName + "email_" + email, verificationCode);
        // 发送邮箱
        SmsEmail smsEmail = new SmsEmail();
        smsEmail.setSubject(SmsEmailType.Subject.VERIFICATION_CODE);
        smsEmail.setEmailTo(email);
        smsEmail.setUseTemplate(true);
        smsEmail.setHtml(true);

        Map<String, Object> templateVariableMap = new HashMap<>();
        templateVariableMap.put("verificationCode", verificationCode);
        smsEmail.setTemplateVariableMap(templateVariableMap);

        smsEmailClient.storageAndSend(smsEmail);
    }

    /**
     * 重设密码
     * @param resetBean
     * @return
     */
    public int resetPassword(CustomerAccount resetBean) {
        // 验证码校验
        String verificationCode = (String)EhcacheUtils.instance().cacheGet("VerificationCode", "name_" + resetBean.getAccountName() + "email_" + resetBean.getEmail());
        if(null == verificationCode) {
            throw new IllegalArgumentException("验证码已过期");
        }
        if(!verificationCode.equals(resetBean.getVerificationCode())) {
            throw new IllegalArgumentException("验证码有误");
        }
        // 修改密码
        CustomerAccount updateBean = new CustomerAccount();
        updateBean.setAccountName(resetBean.getAccountName());
        updateBean.setPassword(CipherUtils.encryptPassword(resetBean.getAccountName(), resetBean.getPassword()));

        return customerAccountClient.updateByName(updateBean);
    }
}
