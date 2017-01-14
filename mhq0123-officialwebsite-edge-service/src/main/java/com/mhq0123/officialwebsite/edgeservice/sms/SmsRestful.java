package com.mhq0123.officialwebsite.edgeservice.sms;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerClient;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import org.apache.commons.lang3.RandomStringUtils;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.mhq0123.springleaf.core.utils.EhcacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/12.
 * desc:
 */
@RestController
public class SmsRestful {

    private static final Logger logger = LoggerFactory.getLogger(SmsRestful.class);

    @Autowired
    private MicroServiceCustomerClient microServiceCustomerClient;
    @Autowired
    private CacheManager ehCacheCacheManager;


    /**
     * 检查邮箱是否存在并发送
     * @param email
     * @param isCheck
     * @return
     */
    @PostMapping(SmsPath.SEND_VERIFICATION_CODE_BY_EMAIL)
    public boolean sendVerificationCodeByEmail(@RequestParam("mapper") String email, @RequestParam("isCheck") boolean isCheck) {
        // 检验
        OvalUtils.validate(new CustomerAccount().setEmail(email), "mapper");
        // 检查邮箱是否已存在
        if(isCheck) {
            CustomerAccount selectBean = microServiceCustomerClient.accountSelectByEmail(email);
            if(null != selectBean) {
                throw new IllegalArgumentException("邮箱已存在");
            }
        }
        // 生成验证码、并缓存 随机产生6位数字
        EhcacheUtils.instance().cachePut("VerificationCode", "email_" + email, RandomStringUtils.randomNumeric(6));
        // 发送

        return true;
    }

    /**
     * 校验验证码
     * @param email
     * @param verificationCode
     * @return
     */
    @PostMapping(SmsPath.CHECK_VERIFICATION_CODE_BY_EMAIL)
    public boolean checkVerificationCodeByEmail(@RequestParam("mapper") String email, @RequestParam("verificationCode") String verificationCode) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setEmail(email).setVerificationCode(verificationCode), "mapper", "verificationCode");
        String cacheVerificationCode = EhcacheUtils.instance().cacheGet("VerificationCode", "email_" + email, String.class);
        if(null == cacheVerificationCode) {
            throw new IllegalArgumentException("验证码已失效");
        }
        if(!cacheVerificationCode.equals(verificationCode)) {
            throw new IllegalArgumentException("验证码不正确");
        }
        return true;
    }

}
