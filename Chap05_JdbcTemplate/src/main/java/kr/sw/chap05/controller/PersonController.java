package kr.sw.chap05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.sw.chap05.service.PersonService;
import kr.sw.chap05.vo.PersonVO;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/list")
	@ResponseBody
	public List<PersonVO> selectList1(){
		return personService.selectAll();
	}
	
	@GetMapping("/list2")
	public String selectList2(Model model){
		List<PersonVO> list = personService.selectAll();
		model.addAttribute("list",list);
		return "list"; // list.html을 통하여 보여라.
	}
	
	@PostMapping("/insertOk")
	// @ModelAttribute는 클라이언트에서 넘어온 데이터를 VO로 받을때 사용한다.
	public String insertOk(@ModelAttribute PersonVO personVO) {
		// 받은 내용을 서비스를 호출하여 저장하고
		personService.insert(personVO);
		// 리스트로 돌아간다.
		return "redirect:/list2"; // 이동하라. 
	}
	
	@GetMapping("/deleteOk")
	// @RequestParam은 넘어오는 값을 1개씩 받는다.
	public String deleteOk(@RequestParam int idx){
		// 서비스를 호출하여 글을 삭제하고
		personService.delete(idx);
		// 리스트로 돌아간다.
		return "redirect:/list2"; // 이동하라. 
	}
	
}
