// 코드 7-13 사용자 정의 아마존 헬스 인디케이터 정의

package readinglist;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AmazonHealth implements HealthIndicator {

    @Override
    public Health health() {
	try {
	    RestTemplate rest = new RestTemplate();    // 아마존에 요청 전송
	    rest.getForObject("http://www.amazon.com", String.class);
	    return Health.up().build();
	} catch (Exception e) {    // 다운 상태 보고
	    return Health.down().build();
	}
    }

}
