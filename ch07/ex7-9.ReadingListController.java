// 코드 7-9 주입된 게이지와 카운터 서비스 사용

package readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private REadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;
    private CounterService counterService;
    private GaugeService gaugeService;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,
	   AmazonProperties amazonProperties, CounterService counterService,
	   GaugeService gaugeService) {    // 카운터와 게이지 서비스 주입
	this.readingListRepository = readingListRepository;
	this.amazonProperties = amazonProperties;
	this.counterService = counterService;
	this.gaugeService = gaugeService;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
	List<Book> readingList = readingListRepository.findByReader(reader);
	if (readingList != null) {
	    model.addAttribute("books", readingList);
	    model.addAttribute("reader", reader);
	    model.addAttribute("amazonId", amazonProperties.getAssociateId());
	}
	return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
	book.setReader(reader);
	readingListRepository.save(book);
	counterService.increment("books.saved");    // book.saved 메트릭 증가
	// book.last.saved 기록
	gaugeService.submit("books.last.saved", System.currentTimeMillis());
	return "redirect:/";
    }

}
