package account;

import com.mhq0123.officialwebsite.microservice.customer.account.CustomerAccountController;
import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=MockServletContext.class)
public class CustomerAccountControllerTest extends MockMvcResultMatchers {

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CustomerAccountController()).build();
    }

    @Test
    public void insert() {
        try {
            RequestBuilder request = MockMvcRequestBuilders.post(MicroServiceCustomerDictionary.PathAccount.INSERT)
                    .param("accountName", "mhq0123")
                    .param("password", "123456")
                    .param("email", "532386274@qq.com")
                    .param("nickName", "小马");
            ResultActions resultActions = mockMvc.perform(request);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}