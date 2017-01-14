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
        private final static String BASE             = "/account";
        /** 新增账号*/
        public final static String INSERT            = BASE + "/insert";
        /** 根据索引编号查询账号*/
        public final static String SELECT_BY_ID      = BASE + "/selectById";
        /** 根据用户名查询账号*/
        public final static String SELECT_BY_NAME    = BASE + "/selectByName";
        /** 根据邮箱查询账号*/
        public final static String SELECT_BY_EMAIL   = BASE + "/selectByEmail";
        /** 根据索引编号修改账号*/
        public final static String UPDATE_BY_ID      = BASE + "/updateById";
        /** 根据索引编号冻结账号*/
        public final static String FREEZE_BY_ID      = BASE + "/freezeById";
        /** 根据索引编号解冻账号*/
        public final static String UNFREEZE_BY_ID    = BASE + "/unfreezeById";
        /** 根据索引编号注销账号*/
        public final static String CANCEL_BY_ID      = BASE + "/cancelById";
    }

    /** 请求路径 - 登陆操作*/
    public static class PathLogin {
        /** base*/
        private final static String BASE            = "/login";
        /** 登陆*/
        public final static String LOGIN            = BASE + "/login";
        /** 登出*/
        public final static String LOGOUT           = BASE + "/logout";
    }

    /** 性别*/
    public enum Sex {
        MEN, WOMEN
    }

    /** 账户状态*/
    public enum AccountStatus {
        VALID, FREEZE, CANCEL
    }

    /** 账户表唯一字段*/
    public enum AccountUniqueField {
        ID, NAME, EMAIL
    }

    /** 账户操作类型*/
    public enum AccountOperateType {
        UPDATE, FREEZE, UNFREEZE, CANCEL
    }

    /** 登陆系统来源*/
    public enum SourceSystem {
        BLOG, ASSISTANT, FORUM, MICROVIEDO
    }

    /** 登陆设备类型*/
    public enum TerminalType {
        PC, IOS, ANDROID
    }

    /** 登陆状态*/
    public enum LoginStatus {
        ON_LINE, OFF_LINE, LOGOUT
    }
}
