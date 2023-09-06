package kr.kdata.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/hello")
	public String home(){
		return "Hello Boot Application!!! 하하하하 한글은?";
	}

}
