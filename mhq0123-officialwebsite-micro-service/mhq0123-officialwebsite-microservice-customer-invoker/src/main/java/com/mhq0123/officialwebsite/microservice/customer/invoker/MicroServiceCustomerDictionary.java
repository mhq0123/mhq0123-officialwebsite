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
    public static final String SERVICE_ID = "mhq0123-officialwebsite-customer-service";

    /** 请求路径 - 账号操作*/
    public static class PathAccount {

        /** 新增账号*/
        public final static String INSERT = "/insert";
        /** 根据唯一字段查询账号*/
        public final static String SELECT_BY_UNIQUE_FIELD = "/selectByUniqueField";
        /** 根据索引编号修改账号*/
        public final static String UPDATE_BY_ID = "/updateById";
        /** 根据索引编号冻结账号*/
        public final static String FREEZE_BY_ID = "/freezeById";
        /** 根据索引编号解冻账号*/
        public final static String UNFREEZE_BY_ID = "/unfreezeById";
        /** 根据索引编号注销账号*/
        public final static String CANCEL_BY_ID = "/cancelById";

    }

    /** 性别*/
    public enum EnumSex {
        MEN, WOMEN
    }

    /** 账户状态*/
    public enum EnumAccountStatus {
        INIT, VALID, FREEZE, INVALID
    }

    public enum EnumAccountUniqueField {
        ID, NAME, EMAIL
    }
}
