package com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;

import java.io.Serializable;
import java.util.Date;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/9.
 * desc:
 */
public class CustomerAccountHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 历史索引编号*/
    private int historyId;
    /** 操作类型*/
    private MicroServiceCustomerDictionary.AccountOperateType operateType;
    /** 账户表索引编号*/
    private int accountId;
    /** 账号*/
    private String accountName;
    /** 密码*/
    private String password;
    /** 个人邮箱*/
    private String email;
    /** 昵称*/
    private String nickName;
    /** 真实姓名*/
    private String realName;
    /** 性别：MEN男/WOMEN女*/
    private MicroServiceCustomerDictionary.Sex sex;
    /** 个人号码*/
    private String phoneNo;
    /** 状态：待验证INIT/生效VALID/冻结FREEZE/注销INVALID*/
    private MicroServiceCustomerDictionary.AccountStatus status;
    /** 操作备注*/
    private String memo;
    /** 初始写入时间*/
    private Date instDatetime;

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public MicroServiceCustomerDictionary.AccountOperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(MicroServiceCustomerDictionary.AccountOperateType operateType) {
        this.operateType = operateType;
    }

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

    public MicroServiceCustomerDictionary.Sex getSex() {
        return sex;
    }

    public void setSex(MicroServiceCustomerDictionary.Sex sex) {
        this.sex = sex;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public MicroServiceCustomerDictionary.AccountStatus getStatus() {
        return status;
    }

    public void setStatus(MicroServiceCustomerDictionary.AccountStatus status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getInstDatetime() {
        return instDatetime;
    }

    public void setInstDatetime(Date instDatetime) {
        this.instDatetime = instDatetime;
    }
}
