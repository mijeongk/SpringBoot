package kr.top2blue.boot3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.top2blue.boot3.service.ThousandCharactersService;
import kr.top2blue.boot3.vo.BibleNameVO;
import kr.top2blue.boot3.vo.BoxOffice;
import kr.top2blue.boot3.vo.FestivalVO;
import kr.top2blue.boot3.vo.HankyungRss;
import kr.top2blue.boot3.vo.ThousandCharacters;
import kr.top2blue.boot3.vo.ThousandCharacters2;

@RestController
@RequestMapping(value = "/api/")
public class APIController {
	
	@Autowired
	ThousandCharactersService thousandCharactersService;

	@GetMapping(value = {"/","/home","/index"})
	public String home() {
		return "Hello Thymeleaf!!!";
	}
	@GetMapping(value = {"/hanja"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ThousandCharacters> getHanja() {
		return thousandCharactersService.getHousandCharacters();
	}
	
	@GetMapping(value = {"/hanja2"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ThousandCharacters2> getHanja2() {
		return thousandCharactersService.getHousandCharacters2();
	}
	
	@GetMapping(value = {"/bible"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<BibleNameVO> getBibleNames() {
		return thousandCharactersService.getBibleNames();
	}
	
	@GetMapping(value = {"/boxOffice"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public BoxOffice getBoxOffice() {
		return thousandCharactersService.getBoxOffice();
	}
	
	@GetMapping(value = {"/rss"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public HankyungRss getHankyungRss() {
		return thousandCharactersService.getHankyungRss();
	}
	
	@GetMapping(value = {"/festival"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public FestivalVO getFestival() {
		return thousandCharactersService.getFestival();
	}
	

}
