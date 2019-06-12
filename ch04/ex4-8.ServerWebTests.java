// 코드 4-8 셀레늄으로 독서 목록 애플리케이션 테스트

...
import static org.junit4.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.WebElement;
...
public class ServerWebTests {

    ...

    @Test
    public void addBookToEmptyList() {
	String baseUrl = "http://localhost:" + port;

	browser.get(baseUrl);    // 메인 페이지 조회

	assertEquals("You have no books in your book list",
		     browser.findElementByTagName("div").getText());    // 빈 책 목록 검증
	browser.findElementByName("title").sendKeys("BOOK TITLE");
	browser.findElementByName("author").sendKeys("BOOK AUTHOR");
	browser.findElementByName("isbn").sendKeys("1234567890");
	browser.findElementByName("description").sendKeys("DESCRIPTION");
	browser.findElementByTagName("form").submit();    // 폼에 데이터를 추가하고 전송

	WebElement dl = browser.findElementByCssSelector("dt.bookHeadline");
	assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)", dl.getText());
	WebElement dt = browser.findElementByCssSelector("dd.bookDescription");
	assertEquals("DESCRIPTION", dt.getText());    // 목록에 새 책이 있는지 검증
    }

}
