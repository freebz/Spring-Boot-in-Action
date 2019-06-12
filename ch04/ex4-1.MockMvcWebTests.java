// 코드 4-1 컨트롤러를 통합 테스트하는 Mock MVC 생성

package readinglist;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@WebAppConfiguration    // 웹 컨텍스트 테스트 활성화
public class MockMvcWebTests {

    @Autowired
    private WebApplicationContext webContext;    // WebApplicationContext 주입

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
	mockMvc = MockMvcBuilders    // MockMvc 설정
	    .webAppContextSetup(webContext)
	    .build();
    }

}
