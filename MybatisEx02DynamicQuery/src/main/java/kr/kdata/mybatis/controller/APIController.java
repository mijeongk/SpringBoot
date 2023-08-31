package kr.kdata.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.kdata.mybatis.service.EmpService;
import kr.kdata.mybatis.vo.EmpVO;

@RestController // view 없이 직접 출력하는 컨트롤러
@RequestMapping(value = "/api") // 주소앞에 접두어 지정
public class APIController {

	@Autowired
	private EmpService empService;
	
	@GetMapping(value = "/all")
	public List<EmpVO> selectAll(@RequestParam(defaultValue = "")Integer no){
		return empService.selectAll(no);
	}
	
	@GetMapping(value = "/deptNo")
	public List<Integer> selectDeptNo(){
		return empService.selectDeptNo();
	}
}
