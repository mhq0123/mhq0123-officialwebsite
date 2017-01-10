package com.mhq0123.officialwebsite.microservice.customer.invoker;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 *
 * 类型字典
 *
 */
public class MicroServiceCustomerDictionary {

    /** 服务id*/
    public static final String SERVICE_ID = "mhq0123-officialwebsite-microservice-customer";

    /** 请求路径 - 账号操作*/
    public static class PathAccount {
        /** base*/
        public final static String BASE                     = "/account";
        /** 新增账号*/
        public final static String INSERT                   = BASE + "/insert";
        /** 根据唯一字段查询账号*/
        public final static String SELECT_BY_UNIQUE_FIELD   = BASE + "/selectByUniqueField";
        /** 根据索引编号修改账号*/
        public final static String UPDATE_BY_ID             = BASE + "/updateById";
        /** 根据索引编号冻结账号*/
        public final static String FREEZE_BY_ID             = BASE + "/freezeById";
        /** 根据索引编号解冻账号*/
        public final static String UNFREEZE_BY_ID           = BASE + "/unfreezeById";
        /** 根据索引编号注销账号*/
        public final static String CANCEL_BY_ID             = BASE + "/cancelById";
    }

    public static class Account {
        /** 校验标记*/
        public final static String PROFILE_INSERT = "insert";
        public final static String PROFILE_UPDATE = "update";
    }

    /** 性别*/
    public enum Sex {
        MEN, WOMEN
    }

    /** 账户状态*/
    public enum AccountStatus {
        INIT, VALID, FREEZE, CANCEL
    }

    /** 账户表唯一字段*/
    public enum AccountUniqueField {
        ID, NAME, EMAIL
    }

    /** 账户操作类型*/
    public enum AccountOperateType {
        UPDATE, FREEZE, UNFREEZE, CANCEL
    }
}
