package com.mhq0123.officialwebsite.microservice.sms.email.service;

import com.mhq0123.officialwebsite.microservice.sms.invoker.bean.SmsEmail;
import org.mhq0123.springleaf.common.utils.EnumCommentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

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

    /**
     * 发送简单邮箱
     * @param smsEmail
     */
    public void sendSimple(SmsEmail smsEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(smsEmail.getEmailFrom());
        simpleMailMessage.setTo(smsEmail.getEmailTo());
        simpleMailMessage.setSubject(EnumCommentUtils.getDesc(smsEmail.getSubject()));
        simpleMailMessage.setText(smsEmail.getText());

        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 发送附件邮件
     * @param smsEmail
     * @throws Exception
     */
    public void sendAttachmentsMail(SmsEmail smsEmail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(smsEmail.getEmailFrom());
            helper.setTo(smsEmail.getEmailTo());
            helper.setSubject(EnumCommentUtils.getDesc(smsEmail.getSubject()));
            helper.setText(smsEmail.getText());

            // 附件
            Map<String, File> attachmentMap = smsEmail.getAttachmentMap();
            if(null != attachmentMap) {
                for(String fileName : attachmentMap.keySet()) {
                    helper.addAttachment(fileName, attachmentMap.get(fileName));
                }
            }
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>发送邮件异常:{}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    /**
     * 发送带静态资源、附件的邮件
     * @param smsEmail
     * @throws Exception
     */
    public void sendInlineMail(SmsEmail smsEmail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(smsEmail.getEmailFrom());
            helper.setTo(smsEmail.getEmailTo());
            helper.setSubject(EnumCommentUtils.getDesc(smsEmail.getSubject()));
            helper.setText(smsEmail.getText(), true);
            // 静态资源
            Map<String, File> inlineMap = smsEmail.getInlineMap();
            if(null != inlineMap) {
                for(String fileName : inlineMap.keySet()) {
                    helper.addInline(fileName, inlineMap.get(fileName));
                }
            }
            // 附件
            Map<String, File> attachmentMap = smsEmail.getAttachmentMap();
            if(null != attachmentMap) {
                for(String fileName : attachmentMap.keySet()) {
                    helper.addAttachment(fileName, attachmentMap.get(fileName));
                }
            }

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>发送邮件异常:{}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 发送模板、带静态、带附件
     * @param smsEmail
     * @throws Exception
     */
    public void sendTemplateMail(SmsEmail smsEmail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(smsEmail.getEmailFrom());
            helper.setTo(smsEmail.getEmailTo());
            helper.setSubject(EnumCommentUtils.getDesc(smsEmail.getSubject()));

            String text = ThymeleafViewResolver.
                    velocityEngine, "template.vm", "UTF-8", model);
            helper.setText(text, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>发送邮件异常:{}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
