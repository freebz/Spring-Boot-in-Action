// 코드 4-7 스프링 부투를 이용한 셀레늄 테스트 템플릿

package readinglist;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WEbIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@WebIntegrationTest(randomPort=true)    // 임의의 포트에서 실행
public class ServerWebTests {

    private static FirefoxDriver browser;

    @Value("${local.server.port}")    // 포트 주입
    private int port;

    @BeforeClass
    public static void openBrowser() {
	browser = new FirefoxDriver();
	// FirefoxDriver 설정
	browser.manage().timeouts().implicityWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBlowser() {
	browser.quit();    // 웹 브라우저 종료
    }

}
