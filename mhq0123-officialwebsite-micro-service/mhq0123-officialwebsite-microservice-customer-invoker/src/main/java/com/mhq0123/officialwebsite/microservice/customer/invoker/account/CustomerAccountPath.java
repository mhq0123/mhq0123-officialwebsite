package com.mhq0123.officialwebsite.microservice.customer.invoker.account;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 *
 * 类型字典
 *
 */
public class CustomerAccountPath {

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
    /** 根据用户名修改账号*/
    public final static String UPDATE_BY_NAME      = BASE + "/updateByName";
    /** 根据索引编号冻结账号*/
    public final static String FREEZE_BY_ID      = BASE + "/freezeById";
    /** 根据索引编号解冻账号*/
    public final static String UNFREEZE_BY_ID    = BASE + "/unfreezeById";
    /** 根据索引编号注销账号*/
    public final static String CANCEL_BY_ID      = BASE + "/cancelById";
}
