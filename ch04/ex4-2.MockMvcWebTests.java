// 코드 4-2 새 책을 등록하는 테스트

...
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import org.springframework.http.MediaType;
...
public class MockMvcWebTests {

    ...

    @Test
    public void postBook() throws Exception {
	mockMvc.perform(post("/")    // POST 요청 수행
	    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
	    .param("title", "BOOK TITLE")
	    .param("author", "BOOK AUTHOR")
	    .param("isbn", "1234567890")
	    .param("description", "DESCRIPTION"))
	    .andExpect(status().is3xxRedirection())
	    .andExpect(header().string("Location", "/"));

	Book expectedBook = new Book();    // 생성할 책 정보 설정
	expectedBook.setId(1L);
	expectedBook.setReader("craig");
	expectedBook.setTitle("BOOK TITLE");
	expectedBook.setAuthor("BOOK AUTHOR");
	expectedBook.setIsbn("1234567890");
	expectedBook.setDescription("DESCRIPTION");

	mockMvc.perform(get("/"))    // GET 요청 실행
	    .andExpect(status().isOk())
	    .andExpect(view().name("readingList"))
	    .andExpect(model().attributeExists("books"))
	    .andExpect(model().attribute("books", hasSize(1)))
	    .andExpect(model().attribute("books", contains(samePropertyValuesAs
					 (expectedBook))));
    }

}
