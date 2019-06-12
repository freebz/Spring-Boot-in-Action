// 코드 4-4 사용자 인증 보안 메서드 테스트

...
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.security.test.context.support.WithUserDetails;
...
public class MockMvcWebTests {

    ...

    @Test
    @WithUserDetails("craig")    // craig를 사용자로 사용
    public void homePage_authenticatedUser() throws Exception {
	Reader expectedReader = new Reader();    // 반환할 Reader 생성
	expectedReader.setUsername("craig");
	expectedReader.setPassword("password");
	expectedReader.setFullname("Craig Walls");

	mockMvc.perform(get("/"))    // GET 요청 수행
	    .andExpect(status().isOk())
	    .andExpect(view().name("readingList"))
	    .andExpect(model().attribute("reader", samePropertyValuesAs(expectedReader)))
	    .andExpect(model().attribute("books", hasSize(0)))
	    .andExpect(model().attribute("amazonId", "habuma-20"));
    }

}
