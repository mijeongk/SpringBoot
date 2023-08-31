package kr.dwacademy.chap05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.dwacademy.chap05.service.TestService;

@Controller // 사용자의 요청을 받아 응답을 담당한다.
public class TestController {
	// 만들어 놓은 서비스 객체를 자동으로 주입 받겠다.
	@Autowired
	private TestService testService;
	
	// 웹브라우저에 /today1이라 입력하면 문자열로 날짜를 출력하게 한다.
	@GetMapping("/today1") // 인터넷상의 주소 생성 : Get요청시 응답
	@ResponseBody // 직접 출력해라.
	public String getToday1() {
		return testService.getToday();
	}
	// 템플릿을 통한 출력
	@GetMapping("/today2") // 인터넷상의 주소 생성 : Get요청시 응답
	public String getToday2(Model model) {
		// html파일에서 출력할 내용은 모두 model에 담아서 넘겨줘야 한다.
		String today = testService.getToday();
		model.addAttribute("today", today);
		return "index"; // /templates/index.html 파일을 이용해서 보여줘라
	}
}
