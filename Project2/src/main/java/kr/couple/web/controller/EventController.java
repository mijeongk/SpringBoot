package kr.couple.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.couple.web.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	// 새로운 이벤트 저장하기
	
	// 이벤트 수정하기
	
	// 이벤트 삭제하기
}
