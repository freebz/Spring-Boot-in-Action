// 코드 3-7 Reader 타입으로 검색하도록 수정한 ReadingListRepository

package readinglist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(Reader reader);
}
