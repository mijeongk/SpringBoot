package kr.top2blue.memo.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import kr.top2blue.memo.service.MemoService;
import kr.top2blue.memo.vo.MemoVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	@GetMapping("/")
	public String home(Model model) {
		log.info("MemoController의 home 호출!!!");
		List<MemoVO> list = memoService.getList();
		// HTML에서 출력할 내용은 모두 model에 담아서 간다.
		model.addAttribute("list", list);
		return "index";
	}
	
	@PostMapping("/updateOk")
	public String updateok(
			@ModelAttribute MemoVO memoVO, 
			@RequestParam(defaultValue = "") String mode,
			HttpServletRequest request) {
		log.info("MemoController의 updateok 호출 : {}, {}", memoVO, mode);
		// IP주소를 구해서 넣어보자
		if(memoVO!=null) {
			memoVO.setIp(request.getRemoteAddr()); // 아이피 주소를 얻어서 넣어준다.
		}
		switch (mode) {
		case "insert":
			memoService.insert(memoVO);
			break;
		case "update":
			memoService.update(memoVO);
			break;
		case "delete": 
			memoService.delete(memoVO);
			break;
		}
		return "redirect:/"; // "/"의 주소로 이동해라
	}
}
