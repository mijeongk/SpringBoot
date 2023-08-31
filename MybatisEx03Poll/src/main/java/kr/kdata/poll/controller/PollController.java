package kr.kdata.poll.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.kdata.poll.service.PollService;
import kr.kdata.poll.vo.PollVO;

@Controller
@RequestMapping(value = "/poll")
public class PollController {

	@Autowired
	private PollService pollService;
	
	// 투표 목록
	@GetMapping(value = {"/","/list"})
	public String pollHome(Model model) {
		model.addAttribute("list", pollService.getList());
		return "poll/list";
	}
	// 투표하기 폼
	@GetMapping(value = {"/poll"})
	public String poll(@RequestParam(defaultValue = "1")Integer id, Model model) {
		model.addAttribute("vo", pollService.getPoll(id));
		return "poll/pollForm";
	}
	// 투표결과 저장하기
	@GetMapping(value = {"/pollOk"}) // Get방식으로 요청시(주소표시줄에 직접 주소를 입력시)
	public String pollOkGet() {
		return "redirect:/poll/list"; // 투표하기 목록으로 이동
	}
	@PostMapping(value = {"/pollOk"}) // Post요청일 경우에만 저장 처리를 해주자
	public String pollOkPost(
			@RequestParam Integer id, 
			@RequestParam Integer poll) {
		
		pollService.pollUpdate(id, poll);
		
		return "redirect:/poll/pollResult?id="+id; 
	}
	// 투표 결과보기
	@GetMapping(value = "/pollResult")
	public String pollResult(@RequestParam(defaultValue = "1")Integer id, Model model) {
		model.addAttribute("vo", pollService.getPoll(id));
		model.addAttribute("color","red,green,blue,brown,gray,black".split(","));
		return "poll/pollResult";
	}
	// 새로운 투표 등록하기 폼
	@GetMapping(value = "/insertForm")
	public String insertForm() {
		return "poll/insertForm";
	}
	// Get요청시는 무시하고 목록으로 간다,
	@GetMapping(value = "/insertOk")
	public String insertOkGet() {
		return "redirect:/poll/list"; // 투표하기 목록으로 이동
	}
	
	@PostMapping("/insertOk")
	public String insertOkPost(
			@RequestParam String subject,
			// 폼의 name속성의 값이 같은것이 여러개라면 배열이나 List로 받는다.
			@RequestParam List<String> item
			) {
		System.out.println("투표제목 : " + subject);
		System.out.println("투표항목 : " + item);
		
		// 저장 객체를 만들어서 채우고
		PollVO pollVO = new PollVO();
		pollVO.setSubject(subject);
		pollVO.setItems(item);
		List<Integer> counts = new ArrayList<>();
		// 항목 개수만큼 0으로 리스트를 생성한다.
		for(int i=0;i<item.size();i++) counts.add(0); 
		pollVO.setCounts(counts);

		// 서비스를 호출하여 저장을 수행
		pollService.insert(pollVO);
		
		return "redirect:/poll/list"; // 투표하기 목록으로 이동
	}
}
