package kr.top2blue.chap05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.top2blue.chap05.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return testService.getToday();
	}
	// sum?n1=234&n2=345
	@GetMapping("/sum")
	@ResponseBody
	public int getSum(@RequestParam(defaultValue = "0") int n1,
			          @RequestParam(defaultValue = "0") int n2) {
		return testService.getSum(n1, n2);
	}
}
