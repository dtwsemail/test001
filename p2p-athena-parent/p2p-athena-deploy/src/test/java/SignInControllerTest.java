import com.hsjry.p2p.athena.common.constants.EnumBizType;
import com.hsjry.p2p.athena.common.utils.JsonUtils;
import com.hsjry.p2p.athena.dal.integration.service.SerialNoService;
import com.hsjry.p2p.athena.facade.controller.SignInController;
import com.hsjry.p2p.athena.facade.request.SignInRequest;
import com.hsjry.p2p.athena.facade.response.CommonResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wangyf14377 on 2018/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //调用Spring单元测试类
@WebAppConfiguration        //调用Java Web组件，如自动注入ServletContext Bean等
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})      //加载Spring配置文件
public class SignInControllerTest {


    private MockMvc mockMvc;
    @Autowired
    private SignInController signInController;


    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(signInController).build();
    }





    private SignInRequest getParameter() {
        SignInRequest request = new SignInRequest();
        request.setPartnerId("abc");
        request.setPartnerSerialNo(SerialNoService.generateCommonSerivce());
        request.setBizType(EnumBizType.SINGN_IN.getCode());
        return request;
    }

    @Test
    public void testHttp() throws Exception {
        this.mockMvc
                .perform(post("/signIn/doJSON")
                        .content(JsonUtils.toJSONString(getParameter()))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }


}
