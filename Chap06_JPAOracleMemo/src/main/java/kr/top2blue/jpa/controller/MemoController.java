package kr.top2blue.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import kr.top2blue.jpa.service.MemoService;
import kr.top2blue.jpa.vo.Memo;

@Controller
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("list", memoService.selectList());
		return "index";
	}
	@PostMapping("/updateOk")
	public String updateOk(@ModelAttribute Memo memo, 
			@RequestParam(defaultValue = "") String mode,
			HttpServletRequest request) {
		memo.setIp(request.getRemoteAddr());
		switch (mode) {
		case "insert":
			memoService.insert(memo);
			break;
		}
		return "redirect:/";
	}
}
