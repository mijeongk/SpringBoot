package kr.top2blue.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import kr.top2blue.jpa.domain.Article;
import kr.top2blue.jpa.service.BlogService;

@Controller
public class BlogViewController {

	@Autowired
	private BlogService blogService;
	
	// 글목록보기
	@GetMapping("/articles")
	public String getArticles(Model model) {
		// 저장된 모든 글의 목록을 읽어서 모델에 담고 뷰페이지로 간다.
		// 1. 저장된 모든 글의 목록을 읽기
		List<Article> list = blogService.findAll();
		// 2. 모델에 담기
		model.addAttribute("list", list);
		// 3. 뷰페이지로 이동
		return "articleList";
	}
	
	// 저장된글 1개 얻기 ---- 내용보기
	@GetMapping("/articles/{id}")
	// @PathVariable Long id : 주소의 뒷부분에 {id}라고 쓴 값을 받겠다.
	public String getArticle(@PathVariable Long id, Model model) {
		// 경로로 넘어온 글번호를 이용하여  서비스를 호출해서 해당 글번호의 내용을 가져오고
		// 모델에 담아 뷰페이지로 이동한다.
		// 1. @PathVariable로 글번호 이미 받았다.
		// 2. 서비스를 호출해서 해당 글번호의 내용을 가져오고
		Article article = blogService.findById(id);
		// 3. 모델에 담아
		model.addAttribute("article", article);
		// 4. 뷰페이지로 이동
		return "article";
	}
	
	// 새글쓰기/수정하기 구현
	// /new-article : 새글쓰기
	// /new-article?id=글번호 : 수정하기
	@GetMapping("/new-article")
	public String newArticle(@RequestParam(required = false) Long id, Model model) {
		if(id==null) { // id가 넘어오지 않았다면 새글쓰기
			model.addAttribute("article", new Article());
		}else{ // id가 넘어 왔다면 수정하기
			Article article = blogService.findById(id); // 수정할 데이터를 DB에서 가져온다.
			model.addAttribute("article", article);
		}
		return "newArticle"; // 쓰기/수정 폼
	}
	
	
	
	
	
	
	
	
	
}
