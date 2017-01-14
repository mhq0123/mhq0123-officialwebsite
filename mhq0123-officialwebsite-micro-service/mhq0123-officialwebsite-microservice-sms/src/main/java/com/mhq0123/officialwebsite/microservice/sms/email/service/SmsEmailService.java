package com.mhq0123.officialwebsite.microservice.sms.email.service;

import com.mhq0123.officialwebsite.microservice.sms.email.mapper.SmsEmailMapper;
import com.mhq0123.officialwebsite.microservice.sms.email.repository.SmsEmailRepository;
import com.mhq0123.officialwebsite.microservice.sms.invoker.MicroServiceSmsDictionary;
import com.mhq0123.officialwebsite.microservice.sms.invoker.bean.SmsEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 发送简单邮箱
     * @param smsEmail
     */
    public void sendSimpleMail(SmsEmail smsEmail) {
        javaMailSender.send(smsEmailRepository.createSimpleMailMessage(smsEmail));
    }

    /**
     * 发送附件、静态资源、模板
     * @param smsEmail
     */
    public void sendMimeMail(SmsEmail smsEmail) {
        javaMailSender.send(smsEmailRepository.createMimeMessage(smsEmail));

    }

    /**
     * 写入邮件
     * @param smsEmail
     * @return 主键
     */
    public int insert(SmsEmail smsEmail) {
        // 转成存储字典
        smsEmail.mapToJsonString();
        // 存表
        smsEmailMapper.insert(smsEmail);
        // 返回主键
        return smsEmail.getEmailId();
    }

    /**
     * 更新编号更新状态
     * @param emailId
     * @param status
     * @return
     */
    public int updateStatusById(int emailId, MicroServiceSmsDictionary.EmailStatus status) {
        return smsEmailMapper.updateStatusById(emailId, status.name());
    }
}
