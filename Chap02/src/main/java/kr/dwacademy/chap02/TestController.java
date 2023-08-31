package kr.dwacademy.chap02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	// Get방식으로 서버에 test라고 요청하면 보여줄 내용을 지정한다.
	@GetMapping("/test")
	public String test() {
		return "반갑다 스프링 부트!";
	}
	// @RequestParam : 넘겨준 값을 받는다.
	// required = false : 넘겨주지 않아도 에러가 발생하지 않는다.
	// defaultValue = "손" : 넘어오지 않으면 기본값을 사용해라.
	@GetMapping("/hello")
	public String hello(
			@RequestParam(required = false, defaultValue = "손") String name,
			@RequestParam(required = false, defaultValue = "0") int age
			) {
		return name + "님 " + age  +"살이네 행님이라고 불러라!!!";
	}
	@GetMapping("/test2")
	public String stringTest() {
		// 여러줄 입력 : 예전 방식
		String str1 = "하하하\n"
						+"호호호호\n히히히\n";
		System.out.println(str1);
		// 여러줄 입력 : 자바 최신 버전
		String str2 = """
				하하하하하
				호호호호호
				히히히ㅣ힣
				""";
		System.out.println(str2);
		
		String str3 = String.format("%s님 %d살이네요", "한사람", 24);
		System.out.println(str3);
		
		String str4 = """
				{
					"name" : %s,
					"age"   : %d
				}
				""".formatted("한사람", 22);
		
		return str4;
	}
}
