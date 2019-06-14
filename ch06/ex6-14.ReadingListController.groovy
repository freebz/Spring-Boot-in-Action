// 코드 6-14 ReadingListController 구현

package readinglist

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class ReadingListController {

    def index() {
	respond Book.list(params), model:[book: new Book()]    // 조회한 책을 모델에 추가
    }

    @Transactional
    def save(Book book) {
	book.reader = 'craig'
	book.save flush:true    // 책을 저장
	redirect(action: "index")
    }
    
}
