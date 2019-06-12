// 코드 4-6 서버에서 웹 애플리케이션 테스트

package readinglist;

import static org.junit.Assert.assertEqual;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@WebIntegrationTest    // 서버에서 테스트 실행
public class SimpleWebTest {

    @Test(expected=HttpClientErrorException.class)
    public void pageNotFound() {
	try {
	    RestTemplate rest = new RestTemplate();
	    // GET 요청 수행
	    rest.getForObject("http://localhost:8080/bogusPage", String.class);
	    fail("Should result in HTTP 404");
	} catch (HttpClientErrorException e) {
	    assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());    // HTTP 404인지 검사
	    throw e;
	}
    }

}
