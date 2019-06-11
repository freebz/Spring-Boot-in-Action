// 코드 2-2 스프링 애플리케이션 컨텍스트를 로드하는 @SpringApplicationConfiguration

package readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJunit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
// 스프링 부트로 컨텍스트 로드
@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@WebAppConfiguration
public class ReadingListApplicationTests {

    @Test
    public void contextLoads() { // 컨텍스트 로드 테스트
    }
    
}
