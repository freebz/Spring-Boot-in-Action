// 코드 3-12 아마존 제휴 ID를 받도록 수정한 ReadingListController

package readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
@ConfigurationProperties(prefix="amazon")    // 프로퍼티 주입
public class ReadingListController {

    private ReadingListRepository readingListRepository;
    private String associateId;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
	this.readingListRepository = readingListRepository;
    }

    public void setAssociateId(String associateId) {    // 제휴 ID의 세터 메서드
	this.associateId = associateId;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
	List<Book> readingList=readingListRepository.findByReader(reader);
	if (readingList != null) {
	    model.addAttribute("books", readingList);
	    model.addAttribute("reader", reader);
	    model.addAttribute("amazonId", associateId);    // 제휴 ID를 모델에 추가
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
