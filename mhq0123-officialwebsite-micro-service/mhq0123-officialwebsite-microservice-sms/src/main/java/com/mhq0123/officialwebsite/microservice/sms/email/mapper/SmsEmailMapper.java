package com.mhq0123.officialwebsite.microservice.sms.email.mapper;

import com.mhq0123.officialwebsite.microservice.sms.invoker.bean.SmsEmail;
import org.apache.ibatis.annotations.Mapper;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/14.
 * desc:
 */
@Mapper
public interface SmsEmailMapper {

    /**
     * 新增单个
     * @param insertBean
     * @return
     */
    int insert(SmsEmail insertBean);

    /**
     * 更新
     * @param updateBean
     * @return
     */
    int updateById(SmsEmail updateBean);
}
