package com.mhq0123.officialwebsite.edgeservice.customer;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerClient;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.login.CustomerLogin;
import org.mhq0123.springleaf.common.utils.CipherUtils;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.mhq0123.springleaf.common.utils.ThreadLocalUtils;
import org.mhq0123.springleaf.core.SpringleafCoreConstants;
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
 * date:    2017/1/10.
 * desc:
 */
@RestController
public class CustomerRestful {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestful.class);

    @Autowired
    private MicroServiceCustomerClient microServiceCustomerClient;

    /**
     * 检查用户名是否已存在
     * @param accountName
     * @return
     */
    @PostMapping(CustomerPath.CHECK_ACCOUNT_NAME)
    public boolean checkAccountName(@RequestParam("accountName") String accountName) {
        // 校验
        OvalUtils.validate(new CustomerAccount().setAccountName(accountName), "accountName");

        CustomerAccount selectBean = microServiceCustomerClient.accountSelectByName(accountName);
        if(null != selectBean) {
            throw new IllegalArgumentException("用户名已存在");
        }
        return true;
    }

    @PostMapping(CustomerPath.REGISTER)
    public boolean register(@RequestBody CustomerAccount registerBean) {
        // 校验
        if(null == registerBean) {
            throw new IllegalArgumentException("注册对象不可为空");
        }
        // 栏位校验
        OvalUtils.validate(registerBean, "insert");
        // 验证码校验 TODO
        // 写入数据库
        microServiceCustomerClient.accountInsert(registerBean);
        // 返回结果
        return true;
    }

    @PostMapping(CustomerPath.LOGIN)
    public boolean login(@RequestBody CustomerLogin loginBean) {
        // 校验
        if(null == loginBean) {
            throw new IllegalArgumentException("登陆对象不可为空");
        }
        // 框架校验
        OvalUtils.validate(loginBean, "insert");
        // 查询用户
        CustomerAccount selectBean = microServiceCustomerClient.accountSelectByName(loginBean.getAccountName());
        if(null == selectBean) {
            throw new IllegalArgumentException("用户名不存在");
        }
        // 校验密码
        if(!CipherUtils.encryptPassword(loginBean.getAccountName(), loginBean.getPassword()).equals(selectBean.getPassword())) {
            throw new IllegalArgumentException("密码不正确");
        }
        // 写入登陆表 TODO
        loginBean.setAccountId(selectBean.getAccountId());
        loginBean.setNetworkAddress(ThreadLocalUtils.get(SpringleafCoreConstants.Request.IP, String.class));

        // 返回结果
        return true;
    }
}
