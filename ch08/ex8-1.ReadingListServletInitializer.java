// 코드 8-1 독서 목록 애플리케이션에서 사용할 SpringBootServletInitializer 확장 구현체

package readlinglist;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class ReadingListServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	// 스프링 환경 구성 클래스 지정
	return builder.sources(ReadingListApplication.class);
    }

}
