package com.mhq0123.officialwebsite.microservice.sms.invoker.bean;

import com.mhq0123.officialwebsite.microservice.sms.invoker.MicroServiceSmsDictionary;
import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/10.
 * desc:
 */
public class SmsEmail implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主题*/
    @NotNull(message = "邮件主题不能为空", profiles = {"insert", "subject"})
    private MicroServiceSmsDictionary.EmailSubject subject;
    /** from email*/
    @Email(message = "源邮箱格式不正确", profiles = {"insert", "emailFrom"})
    @MaxLength(value = 50, message = "源邮箱不能超过50位", profiles = {"insert", "emailFrom"})
    private String emailFrom;
    /** to email*/
    @Email(message = "目标邮箱格式不正确", profiles = {"insert", "emailTo"})
    @MaxLength(value = 50, message = "目标邮箱不能超过50位", profiles = {"insert", "emailTo"})
    private String emailTo;
    /** 内容*/
    @NotBlank(message = "邮件内容不能为空", profiles = {"text"})
    @MaxLength(value = 500, message = "邮件内容不能超过500字", profiles = {"insert", "text"})
    private String text;
    /** 模板邮件模板名*/
    @NotBlank(message = "模板不能为空", profiles = {"template"})
    private String template;
    /** 附近列表*/
    @NotNull(message = "附近列表不能为空", profiles = {"attachmentMap"})
    private Map<String, File> attachmentMap;
    /** 静态资源列表*/
    @NotNull(message = "静态资源列表不能为空", profiles = {"inlineMap"})
    private Map<String, File> inlineMap;
    /** 模板变量*/
    @NotNull(message = "模板变量列表不能为空", profiles = {"modelMap"})
    private Map<String, Object> modelMap;

    public MicroServiceSmsDictionary.EmailSubject getSubject() {
        return subject;
    }

    public void setSubject(MicroServiceSmsDictionary.EmailSubject subject) {
        this.subject = subject;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, File> getAttachmentMap() {
        return attachmentMap;
    }

    public void setAttachmentMap(Map<String, File> attachmentMap) {
        this.attachmentMap = attachmentMap;
    }

    public Map<String, File> getInlineMap() {
        return inlineMap;
    }

    public void setInlineMap(Map<String, File> inlineMap) {
        this.inlineMap = inlineMap;
    }

    public Map<String, Object> getModelMap() {
        return modelMap;
    }

    public void setModelMap(Map<String, Object> modelMap) {
        this.modelMap = modelMap;
    }
}
