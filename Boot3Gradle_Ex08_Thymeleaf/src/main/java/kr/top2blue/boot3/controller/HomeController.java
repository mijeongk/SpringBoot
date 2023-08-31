package kr.top2blue.boot3.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@GetMapping(value = "/")
	public String home(Model model) {
		String serverTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(EEE) HH:mm:ss"));
		log.info("서버시간 : {}", serverTime);
		model.addAttribute("serverTime", serverTime);
		return "index";
	}
}
