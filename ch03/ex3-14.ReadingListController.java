// 코드 3-14 AmazonProperties가 주입된 ReadingListController

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
    private AmazonProperties amazonProperties;
    
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,
				 Amazonproperties amazonProperties) {
	this.readingListRepository = readingListRepository;
	this.amazonProperties = amazonProperties;
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
	    // 제휴 ID를 모델에 추가
	    model.addAttribute("amazonId", amazonProperties.getAssociatedId());
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
