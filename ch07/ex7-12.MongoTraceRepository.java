// 코드 7-12 Mongo에 트레이스 데이터 저장

package readinglist;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class MongoTraceRepository implements TraceRepository {

    private MongoOperations mogoOps;

    @Autowired
    public MongoTraceRepository(MongoOperations mongoOps) {    // MongoOperations 주입
	this.mongoOps = mongoOps;
    }

    @Override
    public List<Trace> findAll() {
	return mongoOps.findAll(Trace.class);    // 모든 트레이스 엔트리 조회
    }

    @Override
    public void add(Map<String, Object> traceInfo) {
	mongoOps.save(new Trace(new Date(), traceInfo));    // 트레이스 엔트리 저장
    }

}
