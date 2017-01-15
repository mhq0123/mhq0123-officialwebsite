package email;

import com.alibaba.fastjson.JSONObject;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.bean.SmsEmail;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.type.SmsEmailType;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 */
@RunWith(SpringRunner.class)
public class SmsEmailControllerTest {

    @Test
    public void send() {
        try {
            //实例化httpClient
            CloseableHttpClient httpclient = HttpClients.createDefault();
            //实例化post方法
            HttpPost httpPost = new HttpPost("http://127.0.0.1:8010/mapper/storageAndSend");
            //处理参数
            SmsEmail smsEmail = new SmsEmail();
            {
                smsEmail.setSubject(SmsEmailType.Subject.VERIFICATION_CODE);
                smsEmail.setEmailTo("532386274@qq.com");
                smsEmail.setUseTemplate(true);
                smsEmail.setHtml(true);
                Map<String, Object> templateVariableMap = new HashedMap();
                templateVariableMap.put("verificationCode", RandomStringUtils.randomNumeric(6));
                smsEmail.setTemplateVariableMap(templateVariableMap);
            }
            //提交的参数
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(smsEmail), ContentType.APPLICATION_JSON);
            //将参数给post方法
            httpPost.setEntity(stringEntity);
            //执行post方法
            CloseableHttpResponse response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}