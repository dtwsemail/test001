import com.hsjry.p2p.athena.biz.service.RequestProcessor;
import com.hsjry.p2p.athena.facade.controller.SignInController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

    /**
     * 主页
     */
    @Test
    public void testIndex() throws Exception {
        signInController.doJSON(null);
    }

}
