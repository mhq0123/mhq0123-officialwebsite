package com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean;

import com.mhq0123.officialwebsite.microservice.customer.invoker.login.type.CustomerLoginType;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.MinSize;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/12.
 * desc:
 */
public class CustomerLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 表索引编号*/
    @MinSize(value = 1, message = "登陆索引编号不可为空", profiles = {"logout", "loginId"})
    private int loginId;
    /** 账号索引编号*/
    @MinSize(value = 1, message = "账户索引编号不可为空", profiles = {"logout", "accountId"})
    private int accountId;
    /** 来源系统BLOG/ASSISTANT/FORUM/MICROVIEDO...*/
    @NotNull(message = "登陆系统不能为空", profiles = {"login", "logout", "sourceSystem"})
    private CustomerLoginType.SourceSystem sourceSystem;
    /** 网络地址*/
    private String networkAddress;
    /** 现实地址*/
    private String realPlace;
    /** 登陆终端类型PC/IOS/ANDROID/...*/
    @NotNull(message = "设备类型不能为空", profiles = {"login", "logout", "terminalType"})
    private CustomerLoginType.TerminalType terminalType;
    /** 登陆终端设备号*/
    @NotBlank(message = "设备号不能为空", profiles = {"login", "equipmentIdentity"})
    @MaxLength(value = 30, message = "设备号不能超过30位", profiles = {"login", "equipmentIdentity"})
    private String equipmentIdentity;
    /** 状态：在线ON_LINE/离线OFF_LINE/已登出LOGOUT*/
    private CustomerLoginType.Status status;
    /** 登陆时间*/
    private Date loginDatetime;
    /** 登陆过期时间*/
    private Date invalidDatetime;

    // ---------------表外字段
    /** 账号*/
    @NotBlank(message = "账号不能为空", profiles = {"accountName"})
    @MaxLength(value = 20, message = "账号不能超过20位", profiles = {"accountName"})
    private String accountName;
    /** 密码*/
    @NotBlank(message = "密码不能为空", profiles = {"password"})
    @MaxLength(value = 30, message = "密码不能超过30位", profiles = {"password"})
    private String password;


    public int getLoginId() {
        return loginId;
    }

    public CustomerLogin setLoginId(int loginId) {
        this.loginId = loginId;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public CustomerLogin setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public CustomerLoginType.SourceSystem getSourceSystem() {
        return sourceSystem;
    }

    public CustomerLogin setSourceSystem(CustomerLoginType.SourceSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    public String getNetworkAddress() {
        return networkAddress;
    }

    public CustomerLogin setNetworkAddress(String networkAddress) {
        this.networkAddress = networkAddress;
        return this;
    }

    public String getRealPlace() {
        return realPlace;
    }

    public CustomerLogin setRealPlace(String realPlace) {
        this.realPlace = realPlace;
        return this;
    }

    public CustomerLoginType.TerminalType getTerminalType() {
        return terminalType;
    }

    public CustomerLogin setTerminalType(CustomerLoginType.TerminalType terminalType) {
        this.terminalType = terminalType;
        return this;
    }

    public String getEquipmentIdentity() {
        return equipmentIdentity;
    }

    public CustomerLogin setEquipmentIdentity(String equipmentIdentity) {
        this.equipmentIdentity = equipmentIdentity;
        return this;
    }

    public CustomerLoginType.Status getStatus() {
        return status;
    }

    public CustomerLogin setStatus(CustomerLoginType.Status status) {
        this.status = status;
        return this;
    }

    public Date getLoginDatetime() {
        return loginDatetime;
    }

    public CustomerLogin setLoginDatetime(Date loginDatetime) {
        this.loginDatetime = loginDatetime;
        return this;
    }

    public Date getInvalidDatetime() {
        return invalidDatetime;
    }

    public CustomerLogin setInvalidDatetime(Date invalidDatetime) {
        this.invalidDatetime = invalidDatetime;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomerLogin setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public CustomerLogin setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }
}
