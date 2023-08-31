package kr.kdata.mybatis.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.kdata.mybatis.service.EmpService;

@Controller
public class HomeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmpService empService;
	
	@GetMapping(value = {"/","/index","/main"})
	public String home(Model model) {
		model.addAttribute("today", new Date());
		model.addAttribute("dbTime",
				jdbcTemplate.queryForObject("select sysdate from dual", Date.class));
		return "index";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "")Integer no, Model model) {
		model.addAttribute("list", empService.selectAll(no));
		model.addAttribute("dept", empService.selectDeptNo());
		model.addAttribute("no", no);
		return "list";
	}
}
