// 코드 3-5 Reader 매개변수를 추가한 ReadingListController

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

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
	this.readingListRepository = readingListRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
	List<Book> readingList=readingListRepository.findByReader(reader);
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
