package com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import net.sf.oval.constraint.*;

import java.io.Serializable;
import java.util.Date;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
public class CustomerAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 表索引编号*/
    @MinSize(value = 1, profiles = {"accountId"})
    private int accountId;
    /** 账号*/
    @NotBlank(message = "账号不能为空", profiles = {"insert", "accountName"})
    @MaxLength(value = 20, message = "账号不能超过20位", profiles = {"insert", "accountName"})
    private String accountName;
    /** 密码*/
    @NotBlank(message = "密码不能为空", profiles = {"insert", "password"})
    @MaxLength(value = 30, message = "密码不能超过30位", profiles = {"insert", "password"})
    private String password;
    /** 个人邮箱*/
    @Email(message = "邮箱格式不正确", profiles = {"insert", "mapper"})
    @MaxLength(value = 50, message = "邮箱不能超过50位", profiles = {"insert", "mapper"})
    private String email;
    /** 昵称*/
    @NotBlank(message = "昵称不能为空", profiles = {"insert", "nickName"})
    @MaxLength(value = 30, message = "昵称不能超过30位", profiles = {"insert", "nickName"})
    private String nickName;
    /** 真实姓名*/
    @MaxLength(value = 20, message = "真实姓名不能超过20位", profiles = {"insert", "realName"})
    private String realName;
    /** 性别：MEN男/WOMEN女*/
    private MicroServiceCustomerDictionary.Sex sex;
    /** 个人号码*/
    @MatchPattern(pattern = {"^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\\\d{8}$"}, message = "手机号格式不正确", profiles = {"insert", "phoneNo"})
    private String phoneNo;
    /** 状态：待验证INIT/生效VALID/冻结FREEZE/注销INVALID*/
    private MicroServiceCustomerDictionary.AccountStatus status;
    /** 初始写入日期*/
    private String instDate;
    /** 初始写入时间*/
    private Date instDatetime;
    /** 最后更新时间*/
    private Date lupdDatetime;

    // ------------------表外字段
    @Length(min = 6, max = 6, message = "请输入6位验证码", profiles = {"insert", "verificationCode"})
    private String verificationCode;

    public String getVerificationCode() {
        return verificationCode;
    }

    public CustomerAccount setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public CustomerAccount setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public CustomerAccount setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomerAccount setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerAccount setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public CustomerAccount setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public CustomerAccount setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public CustomerAccount setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public String getInstDate() {
        return instDate;
    }

    public CustomerAccount setInstDate(String instDate) {
        this.instDate = instDate;
        return this;
    }

    public Date getInstDatetime() {
        return instDatetime;
    }

    public CustomerAccount setInstDatetime(Date instDatetime) {
        this.instDatetime = instDatetime;
        return this;
    }

    public Date getLupdDatetime() {
        return lupdDatetime;
    }

    public CustomerAccount setLupdDatetime(Date lupdDatetime) {
        this.lupdDatetime = lupdDatetime;
        return this;
    }

    public MicroServiceCustomerDictionary.Sex getSex() {
        return sex;
    }

    public CustomerAccount setSex(MicroServiceCustomerDictionary.Sex sex) {
        this.sex = sex;
        return this;
    }

    public MicroServiceCustomerDictionary.AccountStatus getStatus() {
        return status;
    }

    public CustomerAccount setStatus(MicroServiceCustomerDictionary.AccountStatus status) {
        this.status = status;
        return this;
    }
}
