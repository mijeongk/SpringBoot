package kr.couple.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import kr.couple.web.service.TestService;

public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping(value = { "/", "/today"})
	public Date selectToday() {
		return testService.selectToday();
	}
}
