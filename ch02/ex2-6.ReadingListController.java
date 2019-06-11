// 코드 2-6 독서 목록 애플리케이션 앞단에 위치하는 스프링 MVC 컨트롤러

package readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private static final String reader = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
	this.readingListRepository = readingListRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String readerBooks(Model model) {
	List<Book> readingList=readingListRepository.findByReader(reader);
	if (readingList != null) {
	    model.addAttribute("books", readingList);
	}
	return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addToReadingList(Book book) {
	book.setReader(reader);
	readingListRepository.save(book);
	return "redirect:/";
    }

}
