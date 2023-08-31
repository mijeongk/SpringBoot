package kr.top2blue.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.top2blue.jpa.service.EmployeeService;
import kr.top2blue.jpa.vo.Employee;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("list", employeeService.selectList());
		return "index";
	}

	// @ModelAttribute : 객체로 넘어온 데이터를 받겠다.
	@PostMapping("/insertOk")
	public String insertOk(@ModelAttribute Employee employee) {
		// 서비스의 저장하기를 호출해서 저장하고
		log.debug(employeeService.insertOk(employee) ? "저장성공" : "저장실패");
		// 목록보기로 간다.
		return "redirect:/";
	}

	@GetMapping("/deleteAll")
	public String deleteAll() {
		// 서비스의 모두지우기를 호출
		log.debug(employeeService.deleteAll() ? "모두지우기 성공" : "모두지우기 실패");
		// 목록보기로 간다.
		return "redirect:/";
	}

}
