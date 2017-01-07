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

    /** 请求路径*/
    public static class Path {

        /** 账号操作 - 新增账号*/
        public final static String ACCOUNT_INSERT = "/accountInsert";
        /** 账号操作 - 根据唯一字段查询账号*/
        public final static String ACCOUNT_SELECT_BY_UNIQUE_FIELD = "/accountSelectByUniqueField";
        /** 账号操作 - 根据索引编号修改账号*/
        public final static String ACCOUNT_UPDATE_BY_ID = "/accountUpdateById";
        /** 账号操作 - 根据索引编号冻结账号*/
        public final static String ACCOUNT_FREEZE_BY_ID = "/accountFreezeById";
        /** 账号操作 - 根据索引编号解冻账号*/
        public final static String ACCOUNT_UNFREEZE_BY_ID = "/accountUnfreezeById";
        /** 账号操作 - 根据索引编号注销账号*/
        public final static String ACCOUNT_CANCEL_BY_ID = "/accountCancelById";

    }

    /** 性别*/
    public enum Sex {
        MEN, WOMEN
    }

    /** 账户状态*/
    public enum AccountStatus {
        INIT, VALID, FREEZE, INVALID
    }

}
