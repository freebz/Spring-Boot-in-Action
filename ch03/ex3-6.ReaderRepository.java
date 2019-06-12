// 코드 3-6 Reader를 영속화하는 리포지토리 인터페이스

package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;    // JPA로 Reader 영속화

public interface ReaderRepository extends JpaRepository<Reader, String> {

}
