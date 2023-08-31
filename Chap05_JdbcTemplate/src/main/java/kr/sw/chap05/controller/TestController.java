package kr.sw.chap05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.sw.chap05.service.TestService;
import kr.sw.chap05.vo.TestVO;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@GetMapping("/today1")
	@ResponseBody // VO를 직접 출력
	public TestVO getToday1() {
		return testService.getToday();
	}
	@GetMapping("/today2")
	public String getToday2(Model model) { // HTML을 이용하여 출력해라
		// 출력할 내용은 Model에 모두 담아서 이동
		model.addAttribute("vo", testService.getToday());
		return "index"; // /templates/index.html파일을 이용하여 출력해라
	}
}
