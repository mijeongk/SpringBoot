package kr.top2blue.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.top2blue.jpa.domain.Article;
import kr.top2blue.jpa.dto.AddArticleRequest;
import kr.top2blue.jpa.repository.BlogRepository;
import lombok.RequiredArgsConstructor;

@Service
// 매개변수를 받아 final 멤버 변수를 초기화 해주는 생성자를 만든다.  
@RequiredArgsConstructor
public class BlogService {
	
	private final BlogRepository blogRepository;
	
	// 저장해주는 메서드
	public Article  save(AddArticleRequest request) {
		return blogRepository.save(request.toEntity());
	}
	
	// 글목록을 읽어오는 메서드
	public List<Article> findAll(){
		List<Article> list = new ArrayList<>();
		// 모두 읽어서 스트림을 이용하여 하나씩 리스트에 추가한다.
		blogRepository.findAll().forEach((vo)->{ 
			list.add(vo);
		});
		return list;
	}
	// 글 1개 읽어오는 메서드
	public Article findById(long id){
		Article article = null;
		// Optional은 Null을 안잔하게 사용가능하도록 해주는 클래스
		// findById()은 Optional을 리턴한다.
		Optional<Article> optional = blogRepository.findById(id);
		// 존재한다면
		if(optional.isPresent()) {
			// 읽는다.
			article = optional.get();
		}
		return article;
	}
	
	// 글 1개 삭제하기
	public void deleteById(long id) {
		Optional<Article> optional = blogRepository.findById(id);
		// 존재한다면
		if(optional.isPresent()) {
			// 삭제한다.
			blogRepository.deleteById(id);
		}
	}
	// 글 수정하기
	public Article update(Article article) {
		Optional<Article> optional = blogRepository.findById(article.getId());
		// 존재한다면
		if(optional.isPresent()) {
			// 같은 아이디로 다시 저장하면 수정이된다.
			blogRepository.save(article);
			return article; // 수정이 성공하면 수정된 객체를 리턴하고
		}
		return null; // 수정이 실패하면 null을 리턴한다.
	}
}
