package kr.dwacademy.chap03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	@ResponseBody
	public List<Member> getAllMembers(){
		return testService.getAllMembers();
	}

	@GetMapping("/test2")
	public String getAllMembers2(Model model){
		List<Member> list = testService.getAllMembers();
		model.addAttribute("list", list);
		return "index"; // index.html로 내용을 보여줘라!!!
	}
}
