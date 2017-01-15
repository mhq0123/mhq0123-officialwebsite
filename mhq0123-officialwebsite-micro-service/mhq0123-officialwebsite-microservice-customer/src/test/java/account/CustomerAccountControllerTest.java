package account;

import com.alibaba.fastjson.JSONObject;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean.CustomerAccount;
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

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 */
@RunWith(SpringRunner.class)
public class CustomerAccountControllerTest {

    @Test
    public void insert() {
        try {
            //实例化httpClient
            CloseableHttpClient httpclient = HttpClients.createDefault();
            //实例化post方法
            HttpPost httpPost = new HttpPost("http://127.0.0.1:8000/account/insert");
            //处理参数
            CustomerAccount customerAccount = new CustomerAccount();
            customerAccount.setAccountName("mhq0123");
            customerAccount.setPassword("123456");
            customerAccount.setNickName("小马");
            customerAccount.setEmail("532386274@qq.com");
            //提交的参数
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(customerAccount), ContentType.APPLICATION_JSON);
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