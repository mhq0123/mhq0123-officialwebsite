package com.mhq0123.officialwebsite.microservice.sms.email;

import com.mhq0123.officialwebsite.microservice.sms.email.repository.SmsEmailRepository;
import com.mhq0123.officialwebsite.microservice.sms.email.service.SmsEmailService;
import com.mhq0123.officialwebsite.microservice.sms.invoker.MicroServiceSmsDictionary;
import com.mhq0123.officialwebsite.microservice.sms.invoker.bean.SmsEmail;
import org.mhq0123.springleaf.common.utils.EnumCommentUtils;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/13.
 * desc:    邮箱服务
 */
@RestController
public class SmsEmailController {

    @Autowired
    private SmsEmailService smsEmailService;
    @Autowired
    private SmsEmailRepository smsEmailRepository;

    /**
     * 存储并发送
     * @param smsEmail
     * @return
     */
    @PostMapping(MicroServiceSmsDictionary.PathEmail.STORAGE_AND_SEND)
    public boolean storageAndSend(@RequestBody SmsEmail smsEmail) {
        // 校验
        OvalUtils.validate(smsEmail, "insert");
        // 写入数据库 要组装内容跟模板
        if(smsEmail.isUseTemplate()) {
            String template = EnumCommentUtils.getCode(smsEmail.getSubject());
            smsEmail.setTemplate(template);
            smsEmail.setText(smsEmailRepository.getTemplateText(template, smsEmail.getTemplateVariableMap()));
        }
        smsEmail.setStatus(MicroServiceSmsDictionary.EmailStatus.EXCEPTION);
        int emailId = smsEmailService.insert(smsEmail);
        // 发送邮件
        smsEmailService.sendMimeMail(smsEmail);
        // 成功后更新邮件状态
        smsEmailService.updateStatusById(emailId, MicroServiceSmsDictionary.EmailStatus.SUCCESS);

        return true;
    }

    /**
     * 不存储直接发送
     * @param smsEmail
     * @return
     */
    @PostMapping(MicroServiceSmsDictionary.PathEmail.SEND)
    public boolean send(@RequestBody SmsEmail smsEmail) {
        // 校验
        OvalUtils.validate(smsEmail, "insert");
        // 发送邮件
        smsEmailService.sendMimeMail(smsEmail);

        return true;
    }
}
