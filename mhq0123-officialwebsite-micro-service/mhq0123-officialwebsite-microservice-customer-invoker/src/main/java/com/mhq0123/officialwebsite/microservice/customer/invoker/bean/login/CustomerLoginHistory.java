package com.mhq0123.officialwebsite.microservice.customer.invoker.bean.login;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;

import java.io.Serializable;
import java.util.Date;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/12.
 * desc:
 */
public class CustomerLoginHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 表索引编号*/
    private int historyId;
    /** 登陆索引编号*/
    private int loginId;
    /** 账号索引编号*/
    private int accountId;
    /** 来源系统BLOG/ASSISTANT/FORUM/MICROVIEDO...*/
    private MicroServiceCustomerDictionary.SourceSystem sourceSystem;
    /** 网络地址*/
    private String networkAddress;
    /** 现实地址*/
    private String realPlace;
    /** 登陆终端类型PC/IOS/ANDROID/...*/
    private MicroServiceCustomerDictionary.TerminalType terminalType;
    /** 登陆终端设备号*/
    private String equipmentIdentity;
    /** 状态：在线ON_LINE/离线OFF_LINE/已登出LOGOUT*/
    private MicroServiceCustomerDictionary.LoginStatus status;
    /** 登陆时间*/
    private Date loginDatetime;
    /** 登陆过期时间*/
    private Date invalidDatetime;
    /** 登出时间*/
    private Date logoutDatetime;

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public MicroServiceCustomerDictionary.SourceSystem getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(MicroServiceCustomerDictionary.SourceSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getNetworkAddress() {
        return networkAddress;
    }

    public void setNetworkAddress(String networkAddress) {
        this.networkAddress = networkAddress;
    }

    public String getRealPlace() {
        return realPlace;
    }

    public void setRealPlace(String realPlace) {
        this.realPlace = realPlace;
    }

    public MicroServiceCustomerDictionary.TerminalType getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(MicroServiceCustomerDictionary.TerminalType terminalType) {
        this.terminalType = terminalType;
    }

    public String getEquipmentIdentity() {
        return equipmentIdentity;
    }

    public void setEquipmentIdentity(String equipmentIdentity) {
        this.equipmentIdentity = equipmentIdentity;
    }

    public MicroServiceCustomerDictionary.LoginStatus getStatus() {
        return status;
    }

    public void setStatus(MicroServiceCustomerDictionary.LoginStatus status) {
        this.status = status;
    }

    public Date getLoginDatetime() {
        return loginDatetime;
    }

    public void setLoginDatetime(Date loginDatetime) {
        this.loginDatetime = loginDatetime;
    }

    public Date getInvalidDatetime() {
        return invalidDatetime;
    }

    public void setInvalidDatetime(Date invalidDatetime) {
        this.invalidDatetime = invalidDatetime;
    }

    public Date getLogoutDatetime() {
        return logoutDatetime;
    }

    public void setLogoutDatetime(Date logoutDatetime) {
        this.logoutDatetime = logoutDatetime;
    }
}
