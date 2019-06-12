// 코드 3-5 Reader 매개변수를 추가한 ReadingListController

...
@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    ...

    @RequestMapping(method=RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
	List<Book> readingList = readingListRepository.findByReader(reader);
	if (readingList != null) {
	    model.addAttribute("books", readingList);
	    model.addAttribute("reader", reader);
	}
	return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
	book.setReader(reader);
	readingListRepository.save(book);
	return "redirect:/";
    }

}
