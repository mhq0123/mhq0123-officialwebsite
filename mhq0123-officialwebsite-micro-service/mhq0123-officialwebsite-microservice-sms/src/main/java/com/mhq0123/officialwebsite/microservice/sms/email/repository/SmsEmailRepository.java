package com.mhq0123.officialwebsite.microservice.sms.email.repository;

import com.mhq0123.officialwebsite.microservice.sms.invoker.bean.SmsEmail;
import org.mhq0123.springleaf.common.utils.EnumCommentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/14.
 * desc:
 */
@Repository
public class SmsEmailRepository {

    private static final Logger logger = LoggerFactory.getLogger(SmsEmailRepository.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    /** *
     * 创建mail
     * @param smsEmail
     * @return
     */
    public SimpleMailMessage createSimpleMailMessage(SmsEmail smsEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(smsEmail.getEmailFrom());
        simpleMailMessage.setTo(smsEmail.getEmailTo());
        simpleMailMessage.setSubject(EnumCommentUtils.getDesc(smsEmail.getSubject()));
        simpleMailMessage.setText(smsEmail.getText());

        return simpleMailMessage;
    }

    /**
     * 创建、带附件、静态资源的邮件
     * @param smsEmail
     * @return
     */
    public MimeMessage createMimeMessage(SmsEmail smsEmail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(smsEmail.getEmailFrom());
            helper.setTo(smsEmail.getEmailTo());
            helper.setSubject(EnumCommentUtils.getDesc(smsEmail.getSubject()));

            // 内容
            helper.setText(smsEmail.getText(), smsEmail.isHtml());

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

            return mimeMessage;
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>创建邮件异常:{}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取模板文本
     * @param template
     * @param templateVariableMap
     * @return
     */
    public String getTemplateText(String  template, Map templateVariableMap) {
        Context context = new Context();
        context.setVariables(templateVariableMap);
        return templateEngine.process(template, context);
    }
}
