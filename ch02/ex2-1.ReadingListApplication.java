// 코드 2-1 부트스트랩 클래스이자 구성 클래스인 ReadingListApplication

package readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication		// 컴포넌트 검색과 자동 구성 활성화
public class ReadingListApplication {

    public static void main(String[] args) {
	// 애플리케이션 부트스트랩
	SpringApplication.run(ReadingListApplication.class, args);
    }
}
