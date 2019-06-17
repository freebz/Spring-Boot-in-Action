// 코드 7-11 트레이스 엔트리의 최대 개수를 1000개로 늘리는 구성 클래스

package readinglist;

import org.springframework.boot.actuate.trace.InMemoryTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {

    @Bean
    public InMemoryRepository traceRepository() {
	InMemoryTraceRepository traceRepo = new InMemoryTraceRepository();
	traceRepo.setCapacity(1000);
	return traceRepo;
    }

}
