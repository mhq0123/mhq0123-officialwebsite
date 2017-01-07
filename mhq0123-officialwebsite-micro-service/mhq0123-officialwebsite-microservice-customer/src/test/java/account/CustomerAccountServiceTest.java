package account;

import com.mhq0123.officialwebsite.microservice.customer.MicroServiceCustomerApplication;
import com.mhq0123.officialwebsite.microservice.customer.account.CustomerAccountService;
import com.mhq0123.officialwebsite.microservice.customer.account.bean.CustomerAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=MicroServiceCustomerApplication.class)
@ActiveProfiles(value="dev")
public class CustomerAccountServiceTest {

    @Autowired
    private CustomerAccountService customerAccountService;

    @Test
    public void register() {
        try {
            CustomerAccount registerBean = new CustomerAccount();
            registerBean.setAccountName("mhq0123");
            registerBean.setPassword("123456");
            registerBean.setEmail("532386274@qq.com");
            registerBean.setNickName("小马");

            customerAccountService.register(registerBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}