package com.mhq0123.officialwebsite.edgeservice.customer;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerClient;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/10.
 * desc:
 */
@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private MicroServiceCustomerClient microServiceCustomerClient;

    @PostMapping(CustomerPath.REGISTER)
    public boolean register(@ModelAttribute CustomerAccount registerBean) {
        // 校验
        if(null == registerBean) {
            throw new IllegalArgumentException("registerBean对象不可为空");
        }
        // 栏位校验 TODO 引入校验框架
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(registerBean);
        if(null != violations && !violations.isEmpty()) {
            ConstraintViolation constraintViolation = violations.get(0);
            logger.error(">>>>>>>>>>>>>>field:{},value:{},errorMessage:{}", constraintViolation.getCheckName(), constraintViolation.getInvalidValue(), constraintViolation.getMessage());
            throw new IllegalArgumentException(constraintViolation.getMessage());
        }
        // 写入数据库
        microServiceCustomerClient.accountInsert(registerBean);

        // 邮件通知

        // 返回结果
        return true;
    }
}
