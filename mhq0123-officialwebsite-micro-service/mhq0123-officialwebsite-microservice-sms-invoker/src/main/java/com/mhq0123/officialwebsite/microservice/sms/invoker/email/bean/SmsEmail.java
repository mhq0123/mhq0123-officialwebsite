package com.mhq0123.officialwebsite.microservice.sms.invoker.email.bean;

import com.alibaba.fastjson.JSONObject;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.type.SmsEmailType;
import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/10.
 * desc:
 */
public class SmsEmail implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 索引编号*/
    private int emailId;
    /** 主题*/
    @NotNull(message = "邮件主题不能为空", profiles = {"insert", "subject"})
    private SmsEmailType.Subject subject;
    /** from mapper*/
    private String emailFrom;
    /** to mapper*/
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
    /** 模板变量*/
    private String templateVariables;
    /** 附件列表*/
    private String attachments;
    /** 静态资源列表*/
    private String inlines;
    /** 邮件状态*/
    @NotNull(message = "状态不能为空", profiles = {"status"})
    private SmsEmailType.Status status;
    /** 结果描述*/
    private String resultDesc;
    /** 初始写入日期*/
    private String instDate;
    /** 初始写入时间*/
    private Date instDatetime;
    /** 最后更新时间*/
    private Date lupdDatetime;

    // --------------表外字段
    /** 是否使用模板*/
    private boolean useTemplate;
    /** 是否是html*/
    private boolean isHtml;
    /** 附件列表*/
    @NotNull(message = "附件列表不能为空", profiles = {"attachmentMap"})
    private Map<String, File> attachmentMap;
    /** 静态资源列表*/
    @NotNull(message = "静态资源列表不能为空", profiles = {"inlineMap"})
    private Map<String, File> inlineMap;
    /** 模板变量*/
    @NotNull(message = "模板变量列表不能为空", profiles = {"modelMap"})
    private Map<String, Object> templateVariableMap;

    public SmsEmail mapToJsonString() {
        if(null != templateVariableMap && templateVariableMap.size() > 0) {
            this.setTemplateVariables(JSONObject.toJSONString(templateVariableMap));
        }
        if(null != attachmentMap && attachmentMap.size() > 0) {
            this.setAttachments(JSONObject.toJSONString(attachmentMap));
        }
        if(null != inlineMap && inlineMap.size() > 0) {
            this.setInlines(JSONObject.toJSONString(inlineMap));
        }
        return this;
    }

    public SmsEmail jsonStringToMap() {
        if(StringUtils.isNotBlank(this.templateVariables)) {
            this.setTemplateVariableMap(JSONObject.parseObject(this.templateVariables, Map.class));
        }
        if(StringUtils.isNotBlank(this.attachments)) {
            this.setAttachmentMap(JSONObject.parseObject(this.attachments, Map.class));
        }
        if(StringUtils.isNotBlank(this.inlines)) {
            this.setInlineMap(JSONObject.parseObject(this.inlines, Map.class));
        }
        return this;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public SmsEmail setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
        return this;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public SmsEmail setHtml(boolean html) {
        isHtml = html;
        return this;
    }

    public boolean isUseTemplate() {
        return useTemplate;
    }

    public SmsEmail setUseTemplate(boolean useTemplate) {
        this.useTemplate = useTemplate;
        return this;
    }

    public int getEmailId() {
        return emailId;
    }

    public SmsEmail setEmailId(int emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getTemplateVariables() {
        return templateVariables;
    }

    public SmsEmail setTemplateVariables(String templateVariables) {
        this.templateVariables = templateVariables;
        return this;
    }

    public String getAttachments() {
        return attachments;
    }

    public SmsEmail setAttachments(String attachments) {
        this.attachments = attachments;
        return this;
    }

    public String getInlines() {
        return inlines;
    }

    public SmsEmail setInlines(String inlines) {
        this.inlines = inlines;
        return this;
    }

    public SmsEmailType.Status getStatus() {
        return status;
    }

    public SmsEmail setStatus(SmsEmailType.Status status) {
        this.status = status;
        return this;
    }

    public String getInstDate() {
        return instDate;
    }

    public SmsEmail setInstDate(String instDate) {
        this.instDate = instDate;
        return this;
    }

    public Date getInstDatetime() {
        return instDatetime;
    }

    public SmsEmail setInstDatetime(Date instDatetime) {
        this.instDatetime = instDatetime;
        return this;
    }

    public Date getLupdDatetime() {
        return lupdDatetime;
    }

    public SmsEmail setLupdDatetime(Date lupdDatetime) {
        this.lupdDatetime = lupdDatetime;
        return this;
    }

    public SmsEmailType.Subject getSubject() {
        return subject;
    }

    public SmsEmail setSubject(SmsEmailType.Subject subject) {
        this.subject = subject;
        return this;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public SmsEmail setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
        return this;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public SmsEmail setEmailTo(String emailTo) {
        this.emailTo = emailTo;
        return this;
    }

    public String getText() {
        return text;
    }

    public SmsEmail setText(String text) {
        this.text = text;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public SmsEmail setTemplate(String template) {
        this.template = template;
        return this;
    }

    public Map<String, File> getAttachmentMap() {
        return attachmentMap;
    }

    public SmsEmail setAttachmentMap(Map<String, File> attachmentMap) {
        this.attachmentMap = attachmentMap;
        return this;
    }

    public Map<String, File> getInlineMap() {
        return inlineMap;
    }

    public SmsEmail setInlineMap(Map<String, File> inlineMap) {
        this.inlineMap = inlineMap;
        return this;
    }

    public Map<String, Object> getTemplateVariableMap() {
        return templateVariableMap;
    }

    public SmsEmail setTemplateVariableMap(Map<String, Object> templateVariableMap) {
        this.templateVariableMap = templateVariableMap;
        return this;
    }
}
