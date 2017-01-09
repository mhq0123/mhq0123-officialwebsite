package com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotBlank;

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
    private int accountId;
    /** 账号*/
    @NotBlank
    @MaxLength(20)
    private String accountName;
    /** 密码*/
    @NotBlank
    @MaxLength(30)
    private String password;
    /** 个人邮箱*/
    @Email
    @MaxLength(50)
    private String email;
    /** 昵称*/
    @NotBlank
    @MaxLength(30)
    private String nickName;
    /** 真实姓名*/
    @MaxLength(20)
    private String realName;
    /** 性别：MEN男/WOMEN女*/
    private MicroServiceCustomerDictionary.Sex sex;
    /** 个人号码*/
    @MatchPattern(pattern = {"^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\\\d{8}$"})
    private String phoneNo;
    /** 状态：待验证INIT/生效VALID/冻结FREEZE/注销INVALID*/
    private MicroServiceCustomerDictionary.AccountStatus status;
    /** 初始写入日期*/
    private String instDate;
    /** 初始写入时间*/
    private Date instDatetime;
    /** 最后更新时间*/
    private Date lupdDatetime;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getInstDate() {
        return instDate;
    }

    public void setInstDate(String instDate) {
        this.instDate = instDate;
    }

    public Date getInstDatetime() {
        return instDatetime;
    }

    public void setInstDatetime(Date instDatetime) {
        this.instDatetime = instDatetime;
    }

    public Date getLupdDatetime() {
        return lupdDatetime;
    }

    public void setLupdDatetime(Date lupdDatetime) {
        this.lupdDatetime = lupdDatetime;
    }

    public MicroServiceCustomerDictionary.Sex getSex() {
        return sex;
    }

    public void setSex(MicroServiceCustomerDictionary.Sex sex) {
        this.sex = sex;
    }

    public MicroServiceCustomerDictionary.AccountStatus getStatus() {
        return status;
    }

    public void setStatus(MicroServiceCustomerDictionary.AccountStatus status) {
        this.status = status;
    }

    public static void main(String[] args) {
        System.out.println("---");
    }
}
