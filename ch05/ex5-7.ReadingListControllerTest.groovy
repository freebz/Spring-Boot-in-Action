// 코드 5-7 ReadingListController의 그루비 테스트

import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.mockito.Mockito.*

class ReadingListControllerTest {

    @Test
    void shouldReturnReadingListFromRepository() {
	List<Book> expectedList = new ArrayList<Book>()
	expectedList.add(new Book(
	    id: 1,
	    reader: "craig",
	    isbn: "9781617292545",
	    title: "Spring Boot in Action",
	    author: "Craig Walls",
	    description: "Spring Boot in Action is ..."
	))

	def mockRepo = mock(ReadingListRepository.class)     // 목(Mock) ReadingListRepository
	when(mockRepo.findByReader("craig")).thenReturn(expectedList)
	def controller = new ReadingListController(readeringListRepository: mockRepo)

	MockMvc mvc = standaloneSetup(controller).build()
	mvc.perform(get("/"))    // GET 요청 실행 및 테스트
	    .andExpect(view().name("readingList"))
	    .andExpect(model().attribute("books", expectedList))
    }

}
