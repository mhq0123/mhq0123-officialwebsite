package com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean;

import com.mhq0123.officialwebsite.microservice.customer.invoker.account.type.CustomerAccountType;

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
    private CustomerAccountType.OperateType operateType;
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
    private CustomerAccountType.Sex sex;
    /** 个人号码*/
    private String phoneNo;
    /** 状态：待验证INIT/生效VALID/冻结FREEZE/注销INVALID*/
    private CustomerAccountType.Status status;
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

    public CustomerAccountType.OperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(CustomerAccountType.OperateType operateType) {
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

    public CustomerAccountType.Sex getSex() {
        return sex;
    }

    public void setSex(CustomerAccountType.Sex sex) {
        this.sex = sex;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public CustomerAccountType.Status getStatus() {
        return status;
    }

    public void setStatus(CustomerAccountType.Status status) {
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
