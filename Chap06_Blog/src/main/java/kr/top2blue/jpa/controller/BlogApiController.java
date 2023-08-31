package kr.top2blue.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.top2blue.jpa.domain.Article;
import kr.top2blue.jpa.dto.AddArticleRequest;
import kr.top2blue.jpa.service.BlogService;
import lombok.RequiredArgsConstructor;

@RestController // 템플릿을 통과하지 않고 직접 출력해라.
@RequiredArgsConstructor
@RequestMapping("/api")
public class BlogApiController {
	
	private final BlogService blogService;
	
	// POST 요청시 처리한다. : POST는 저장할때 사용
	@PostMapping("/articles")
	// ResponseEntity<Article>은 상태코드를 리턴한다.
	// @RequestBody : ajax호출에 특화된 받기
	public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
		Article saveArticle = blogService.save(request); // 저장
		return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle); // 저장 상태를 리턴
	}
	
	// GET 요청시 처리한다. : GET은 읽어올때 사용
	@GetMapping("/articles")
	public ResponseEntity<List<Article>> findAllArticles(){
		return ResponseEntity.ok().body(blogService.findAll());
	}
	
	// @PathVariable 은 URL을 해석해서 읽으라는 것이다.
	// /articles/1 : 1번글을 읽어라
	// /articles/5 : 5번글을 읽어라
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> findArticle(@PathVariable long id){
		Article article = blogService.findById(id);
		return ResponseEntity.ok().body(article);
	}
	// @PathVariable 은 URL을 해석해서 읽으라는 것이다.
	// /articles/1 : 1번글을 지워라
	// /articles/5 : 5번글을 지워라
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable long id){
		blogService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	// 글 수정
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody Article article){
		Article updateArticle = blogService.update(article);
		return ResponseEntity.ok().body(updateArticle); // 수정 상태를 리턴
	}

}
