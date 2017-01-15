package com.mhq0123.officialwebsite.microservice.customer.invoker.account.type;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 *
 * 类型字典
 *
 */
public class CustomerAccountType {

    /** 性别*/
    public enum Sex {
        MEN, WOMEN
    }

    /** 账户状态*/
    public enum Status {
        VALID, FREEZE, CANCEL
    }

    /** 账户操作类型*/
    public enum OperateType {
        UPDATE, FREEZE, UNFREEZE, CANCEL
    }
}
