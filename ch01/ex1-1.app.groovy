// 코드 1-1 그루비로 작성한 완전한 스프링 애플리케이션(app.groovy)

@RestController
class HelloController {
    @RequestMapping("/")
    def hello() {
	return "Hello World"
    }
}
