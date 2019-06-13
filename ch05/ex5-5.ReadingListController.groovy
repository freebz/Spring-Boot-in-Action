// 코드 5-5 독서 목록을 보여 주고 추가하라는 웹 요청을 처리하는 ReadingListController

@Controller
@RequestMapping("/")
class ReadingListController {

    String reader="craig"

    @Autowired
    ReadingListRepository readingListRepository    // ReadingListRepository 주입

    @RequestMapping(method=RequestMethod.GET)
    def readersBooks(Model model) {
	List<Book> readingList = readingListRepository.findByReader(reader)    // 독서 목록 조회
	if (readingList) {
	    model.addAttribute("books", readingList)    // 모델에 추가
	}
	"readingList"    // 뷰 이름 반환
    }

    @RequestMapping(method=RequestMethod.POST)
    def addToReadingList(Book book) {
	book.setReader(reader)
	readingListRepository.save(book)    // 책 저장
	"redirect:/"    // POST 후 리다이렉트
    }
    
}
