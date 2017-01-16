package com.mhq0123.officialwebsite.edgeservice.customer;

import com.mhq0123.officialwebsite.edgeservice.customer.service.CustomerService;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean.CustomerAccount;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLogin;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/10.
 * desc:
 */
@RestController
public class CustomerRestful {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestful.class);

    @Autowired
    private CustomerService customerService;

    /**
     * 检查邮箱、用户名是否存在，不存在则发送验证码
     * @param customerAccount
     * @return
     */
    @PostMapping(CustomerPath.CHECK_EXIST_AND_SEND_VERIFICATION_CODE)
    public Object checkExistAndSendVerificationCode(@RequestBody CustomerAccount customerAccount) {
        // 校验 用户名跟邮箱
        OvalUtils.validate(customerAccount, "accountName", "email");
        // 服务调用
        customerService.checkExistAndSendVerificationCode(customerAccount.getAccountName(), customerAccount.getEmail());
        // 返回
        return true;
    }

    /**
     * 注册
     * @param registerBean
     * @return
     */
    @PostMapping(CustomerPath.REGISTER)
    public Object register(@RequestBody CustomerAccount registerBean) {
        // 校验
        if(null == registerBean) {
            throw new IllegalArgumentException("注册对象不可为空");
        }
        // 栏位校验
        OvalUtils.validate(registerBean, "insert", "verificationCode");
        // 调用注册服务
        customerService.register(registerBean);
        // 返回结果
        return true;
    }

    /**
     * 登陆
     * @param loginBean
     * @return
     */
    @PostMapping(CustomerPath.LOGIN)
    public Object login(@RequestBody CustomerLogin loginBean) {
        // 校验
        if(null == loginBean) {
            throw new IllegalArgumentException("登陆对象不可为空");
        }
        // 框架校验
        OvalUtils.validate(loginBean, "login");
        // 登陆服务
        return customerService.login(loginBean);
    }

    /**
     * 登出 校验四要素 登陆编号、账户索引编号、来源系统、登陆设备、设备号
     * @param logoutBean
     * @return
     */
    @PostMapping(CustomerPath.LOGOUT)
    public Object logout(@RequestBody CustomerLogin logoutBean) {
        // 校验
        if(null == logoutBean) {
            throw new IllegalArgumentException("登陆对象不可为空");
        }
        // 框架四要素
        OvalUtils.validate(logoutBean, "logout");
        // 登出
        customerService.logout(logoutBean);
        // 返回
        return true;
    }

    /**
     * 检查邮箱、用户名是否匹配，匹配上则发送验证码
     * @param customerAccount
     * @return
     */
    @PostMapping(CustomerPath.CHECK_MATCH_AND_SEND_VERIFICATION_CODE)
    public Object checkMatchAndSendVerificationCode(@RequestBody CustomerAccount customerAccount) {
        // 校验 用户名跟邮箱
        OvalUtils.validate(customerAccount, "accountName", "email");
        // 服务调用
        customerService.checkMatchAndSendVerificationCode(customerAccount.getAccountName(), customerAccount.getEmail());
        // 返回
        return true;
    }

    /**
     * 重设密码
     * @param resetBean
     * @return
     */
    @PostMapping(CustomerPath.RESET_PASSWORD)
    public Object resetPassword(@RequestBody CustomerAccount resetBean) {
        // 校验
        OvalUtils.validate(resetBean, "accountName", "email", "password", "verificationCode");
        // 服务调用
        customerService.resetPassword(resetBean);
        // 返回
        return true;
    }
}
