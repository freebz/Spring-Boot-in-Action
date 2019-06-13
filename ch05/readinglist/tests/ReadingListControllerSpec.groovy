// 코드 5-8 Spock 명세로 ReadingListController 테스트(test/ReadingListControllerSpec.groovy)

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.mockito.Mockito.*

class ReadingListControllerSpec extends Specification {

    MockMvc mockMvc
    List<Book> expectedList

    def setup() {
	expectedList = new ArrayList<Book>()
	expectedList.add(new Book(
	    id: 1,
	    reader: "craig",
	    isbn: "9781617292545",
	    title: "Spring in Action",
	    author: "Craig Walls",
	    description: "Spring Boot in Action is ..."
	))

	def mockRepo = mock(ReadingListRepository.class)    // 목(Mock) ReadingListRepository
	when(mockRepo.findByReader("craig")).thenReturn(expectedList)
	def controller = new ReadingListController(readingListRepository: mockRepo)
	mockMvc = standaloneSetup(controller).build()
    }

    def "Should put list returned from repository into model"() {
	when:
	    def response-mockMvc.perform(get("/"))    // GET 요청 실행

	then:    // 테스트 결과
	    response.andExpect(view().name("readingList"))
	        .andExpect(model().attribute("books", expectedList))
    }

}
