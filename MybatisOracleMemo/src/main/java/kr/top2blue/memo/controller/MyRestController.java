package kr.top2blue.memo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api") // 이컨트롤러에서 만드는 모든주소 앞에 /api가 붙는다.
public class MyRestController {

	@GetMapping(value = {"/","/hello"})
	public String hello(@RequestParam(defaultValue = "한사람") String name) {
		return name + "님 반갑습니다.";
	}
	
	@PostMapping(value = {"/hello2"})
	public String hello2(@RequestParam(defaultValue = "한사람") String name) {
		return name + "님 반갑습니다.";
	}
}
