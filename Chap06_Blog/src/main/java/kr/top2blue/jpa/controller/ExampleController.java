package kr.top2blue.jpa.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller // 템플릿을 통하여 출력하라.
public class ExampleController {

	// 테스트할 주소를 생성한다.
	@GetMapping(value = {"/th/ex"})
	// 메서드 타입은 public String 메서드명(필요한 매개변수들....)
	// html 파일의 이름만 리턴한다.
	public String example(Model model) {
		// html 파일에서 출력할 내용은 모두 Model에 저장해서 가져간다.
		// 컨트롤러 : 
		// 1. 요청 정보를 해석해서 
		// 2. 서비스를 호출하여 로직을 수행하고
		Person person = new Person(1L, "이인간", 23,
				        Arrays.asList("독서","낚시","등산") );
		
		model.addAttribute("person",person);
		model.addAttribute("today", LocalDate.now());
		// 3. 알맞은 곳으로 이동 또는 화면을 만들어준다.
		return "/ex/example"; // html 파일의 이름만 리턴
	}
	
	// 내장 클래스로 출력 연습을 할 VO를 만들자
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	class Person{
		private long id;
		private String name;
		private int age;
		private List<String> hobbies;
	}
}
