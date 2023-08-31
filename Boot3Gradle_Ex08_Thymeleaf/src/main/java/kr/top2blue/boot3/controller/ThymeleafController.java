package kr.top2blue.boot3.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import kr.top2blue.boot3.service.ThousandCharactersService;
import kr.top2blue.boot3.vo.MyDataVO;
import kr.top2blue.boot3.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/th")
@PropertySource(value = { "classpath:/messages/message.properties" })
public class ThymeleafController {
	
	@Value("${main.title}")	   // properties에 선언한 값 
    private String mainTitle;
    @Value("${common.enter}")  // properties에 선언한 값
    private String commonEnter;
	
    
    @GetMapping(value = "/ex001")
	public String ex001(Model model) {
		log.info("Exam001.html : 텍스트 출력하기");

		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
		model.addAttribute("today", "<ins><em><strong>" + dateTime + "</strong></em></ins>");
		model.addAttribute("title", mainTitle);
		model.addAttribute("enter", commonEnter);
		return "Exam001";
	}
    @GetMapping(value = "/ex002")
    public String ex002(Model model) {
    	log.info("Exam002.html : 반복문 사용하기 1(배열)");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
		model.addAttribute("names", "한놈,두식이,석삼,너구리,오징어".split(","));
    	return "Exam002";
    }
    @GetMapping(value = "/ex003")
    public String ex003(Model model) {
    	log.info("Exam003.html : 반복문 사용하기 2(리스트)");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
		model.addAttribute("list", Arrays.asList("일식이,두식이,삼식이,간나새끼,죽을래".split(",")));
    	return "Exam003";
    }
    @GetMapping(value = "/ex004")
    public String ex004(Model model) {
    	log.info("Exam004.html : 반복문 사용하기 3(단순)");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	return "Exam004";
    }
    @GetMapping(value = "/ex005")
    public String ex005(Model model) {
    	log.info("Exam005.html : 반복문 사용하기 4(맵)");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	Map<String, Object> map = new HashMap<>();
		map.put("name", "한사람");
		map.put("age", 33);
		map.put("gender", true);
		map.put("marriage", null);
		map.put("hobby", "");
		model.addAttribute("map", map);
    	return "Exam005";
    }
    @GetMapping(value = "/ex006")
    public String ex006(Model model) {
    	log.info("Exam006.html : VO 사용하기");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("person", new PersonVO("이세상", 22, false));
    	return "Exam006";
    }
    
    @Autowired
	private ThousandCharactersService thousandCharactersService;
    
    @GetMapping(value = "/ex007")
    public String ex007(Model model) {
    	log.info("Exam007.html : VO의 리스트 사용하기 1");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("list", thousandCharactersService.getHousandCharacters());
    	return "Exam007";
    }
    @GetMapping(value = "/ex008")
    public String ex008(Model model) {
    	log.info("Exam008.html : VO의 리스트 사용하기 2");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("list", thousandCharactersService.getHousandCharacters2());
    	return "Exam008";
    }
    @GetMapping(value = "/ex009")
    public String ex009(Model model) {
    	log.info("Exam009.html : 내장 객체 사용하기");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	MyDataVO myDataVO = new MyDataVO();
		myDataVO.setArray(Arrays.asList(new Integer[]{11, 22, 33, 44}));
		myDataVO.setNumber(9999);
		myDataVO.setString("<h1>꽝!!!</h1>");
		myDataVO.setObject(new MyDataVO.InnerData("프로퍼티", new MyDataVO.InnerData2("한놈,두식이,석삼".split(","), 8888)));
		model.addAttribute("obj",myDataVO);
    	return "Exam009";
    }
    @GetMapping(value = "/ex010")
    public String ex010(Model model) {
    	log.info("Exam010.html : 내장 객체 사용하기");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("bibleNames", thousandCharactersService.getBibleNames());
    	return "Exam010";
    }
    @GetMapping(value = "/ex011")
    public String ex011(Model model) {
    	log.info("Exam011.html : 영화순위읽기");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("boxOffice", thousandCharactersService.getBoxOffice());
    	return "Exam011";
    }
    @GetMapping(value = "/ex012")
    public String ex012(Model model) {
    	log.info("Exam012.html : 뉴스 RSS 읽기");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("rss", thousandCharactersService.getHankyungRss());
    	return "Exam012";
    }
    @GetMapping(value = "/ex013")
    public String ex013(Model model) {
    	log.info("Exam013.html : JSON 읽기");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("festival", thousandCharactersService.getFestival());
    	return "Exam013";
    }
    @GetMapping(value = "/ex014")
    public String ex014(Model model, HttpServletRequest request) {
    	log.info("Exam014.html : Session/Application 영역");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	
    	model.addAttribute("msg", "나는 model 영역의 메세지 입니다.");
		request.getSession().setAttribute("msg", "나는 session 영역의 메세지 입니다.");
		request.getServletContext().setAttribute("msg", "나는 application 영역의 메세지 입니다.");
    	
		return "Exam014";
    }
    @GetMapping(value = "/ex015")
    public String ex015(Model model, HttpServletRequest request) {
    	log.info("Exam015.html : SpringEL 표현식");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	
    	PersonVO person1 = new PersonVO("이세상", 22, false);
    	PersonVO person2 = new PersonVO("저세상", 12, true);
    	PersonVO person3 = new PersonVO("내세상", 18, false);
    	PersonVO person4 = new PersonVO("니세상", 34, true);
		
		List<PersonVO> list = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));

        Map<String, PersonVO> map = new HashMap<>();
        map.put("person1", person1);
        map.put("person2", person2);
        map.put("person3", person3);
        map.put("person4", person4);

        model.addAttribute("person", person1);
        model.addAttribute("list", list);
        model.addAttribute("map", map);
    	return "Exam015";
    }
    @GetMapping(value = "/ex016")
    public String ex016(Model model, HttpServletRequest request) {
    	log.info("Exam016.html : 기본객체");
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("msg", "나는 model 영역의 메세지 입니다.");
		request.setAttribute("msg2", "나는 request 영역의 메세지 입니다.");
		request.getSession().setAttribute("msg", "나는 session 영역의 메세지 입니다.");
		request.getServletContext().setAttribute("msg", "나는 application 영역의 메세지 입니다.");
		// request를 모델에 저장
		model.addAttribute("req", request);
    	return "Exam016";
    }
    @GetMapping(value = "/ex017")
    public String ex017(Model model, HttpServletRequest request) {
    	log.info("Exam017.html : 기본객체");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
		
    	return "Exam017";
    }

    @GetMapping(value = "/ex018")
    public String ex018(Model model, HttpServletRequest request) {
    	log.info("Exam018.html : 연산");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	
    	return "Exam018";
    }
    @GetMapping(value = "/ex019")
    public String ex019(Model model, HttpServletRequest request) {
    	log.info("Exam019.html : 조건문");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	model.addAttribute("person", new PersonVO("이세상", 22, false));
    	model.addAttribute("marriage", null);
    	model.addAttribute("hobby", "");
    	
    	PersonVO person1 = new PersonVO("이세상", 22, false);
    	PersonVO person2 = new PersonVO("저세상", 12, true);
    	PersonVO person3 = new PersonVO("내세상", 18, false);
    	PersonVO person4 = new PersonVO("니세상", 34, true);
		
		List<PersonVO> persons = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));
		model.addAttribute("persons", persons);
		
    	return "Exam019";
    }
    @GetMapping(value = "/ex020")
    public String ex020(Model model, HttpServletRequest request) {
    	log.info("Exam020.html : 문서포함");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	
    	return "Exam020";
    }
    @GetMapping(value = "/ex021")
    public String ex021(Model model, HttpServletRequest request) {
    	log.info("Exam021.html : 메세지(국제화)");
    	
    	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(E) hh:mm:ss"));
    	model.addAttribute("today", dateTime);
    	
    	return "Exam021";
    }
}
