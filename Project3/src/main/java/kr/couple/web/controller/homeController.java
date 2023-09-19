package kr.couple.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class homeController {
	@GetMapping(value = "/member/calendar")
	public String viewCalendar(Model model) {
		return "/member/calendar";
	}
	@GetMapping(value = "/member/home")
	public String Home(Model model) {

		return "/member/home";
	}
//	@GetMapping(value = "/member/bucketList")
//	public String BucketList(Model model) {
//		log.info("abcdefg : {}");
//		return "/member/bucketList";
//	}
}
