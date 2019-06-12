// 코드 3-13 빈 안에 구성 프로퍼티 포함(AmazoneProperties)

package readinglist;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon")    // "amazon" 접두어가 붙은 프로퍼티 주입
public class AmazonProperties {

    private String associateId;

    public void setAssociateId(String associateId) {    // associateId 세터 메서드
	this.associateId = associateId;
    }

    public String getAssociatedId() {
	return associateId;
    }

}
