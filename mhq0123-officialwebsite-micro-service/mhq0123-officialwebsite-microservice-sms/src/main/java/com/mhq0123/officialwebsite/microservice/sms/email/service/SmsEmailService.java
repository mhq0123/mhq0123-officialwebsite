package com.mhq0123.officialwebsite.microservice.sms.email.service;

import com.mhq0123.officialwebsite.microservice.sms.email.mapper.SmsEmailMapper;
import com.mhq0123.officialwebsite.microservice.sms.email.repository.SmsEmailRepository;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.bean.SmsEmail;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.type.SmsEmailType;
import org.apache.commons.lang3.StringUtils;
import org.mhq0123.springleaf.common.utils.EnumCommentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/13.
 * desc:
 */
@Service
public class SmsEmailService {

    private static final Logger logger = LoggerFactory.getLogger(SmsEmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SmsEmailRepository smsEmailRepository;
    @Autowired
    private SmsEmailMapper smsEmailMapper;
    @Value("${spring.mail.username}")
    private String emailFrom;

    /**
     * 存储并发送邮箱
     * @param smsEmail
     */
    public boolean storageAndSend(SmsEmail smsEmail) {
        // 返回结果-默认失败
        boolean returnResult = false;
        // 默认发送者
        smsEmail.setEmailFrom(emailFrom);
        // 写入数据库 要组装内容跟模板
        if(smsEmail.isUseTemplate()) {
            String template = EnumCommentUtils.getCode(smsEmail.getSubject());
            smsEmail.setTemplate(template);
            smsEmail.setText(smsEmailRepository.getTemplateText(template, smsEmail.getTemplateVariableMap()));
        }
        // 转成存储字典
        smsEmail.mapToJsonString();
        // 初始异常
        smsEmail.setStatus(SmsEmailType.Status.EXCEPTION);
        smsEmailMapper.insert(smsEmail);
        // 组装更新信息
        SmsEmail updateBean = new SmsEmail().setEmailId(smsEmail.getEmailId());
        try {
            // 发送邮件
            javaMailSender.send(smsEmailRepository.createMimeMessage(smsEmail));
            // 发送成功
            returnResult = true;
            updateBean.setStatus(SmsEmailType.Status.SUCCESS);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>发送邮件异常:{}", e.getMessage(), e);
            updateBean.setStatus(SmsEmailType.Status.FAILURE);
            updateBean.setResultDesc(StringUtils.substring(e.getMessage(), 0, 200));
        }
        // 成功后更新邮件状态
        smsEmailMapper.updateById(updateBean);

        return returnResult;
    }

    /**
     * 发送邮箱
     * @param smsEmail
     */
    public boolean send(SmsEmail smsEmail) {
        // 返回结果-默认失败
        boolean returnResult = false;
        // 默认发送者
        smsEmail.setEmailFrom(emailFrom);
        // 模板信息
        if(smsEmail.isUseTemplate()) {
            String template = EnumCommentUtils.getCode(smsEmail.getSubject());
            smsEmail.setTemplate(template);
            smsEmail.setText(smsEmailRepository.getTemplateText(template, smsEmail.getTemplateVariableMap()));
        }
        try {
            // 发送邮件
            javaMailSender.send(smsEmailRepository.createMimeMessage(smsEmail));
            // 执行成功
            returnResult = true;
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>发送邮件异常:{}", e.getMessage(), e);
        }
        return returnResult;
    }
}
