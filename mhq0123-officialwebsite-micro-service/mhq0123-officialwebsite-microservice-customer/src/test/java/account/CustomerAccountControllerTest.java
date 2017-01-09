package account;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
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
            RequestBody requestBody = new
                    .add("键", "值")// 构造请求的参数
                    .add("键", "值")// 构造请求的参数
                    .build();

            Request.Builder builder = new Request.Builder();
            builder.url("http://127.0.0.1:8000/account/insert")
                    .post()
            Request request = Request.Builder.post("").build();
//                    .param("accountName", "mhq0123")
//                    .param("password", "123456")
//                    .param("email", "532386274@qq.com")
//                    .param("nickName", "小马");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}