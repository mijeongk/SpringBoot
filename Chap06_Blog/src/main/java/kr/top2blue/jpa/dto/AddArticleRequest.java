package kr.top2blue.jpa.dto;

import kr.top2blue.jpa.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddArticleRequest {
	private String title;
	private String content;
	
	// 위의 변수 2개를 이용하여 객체를 만들어 리턴해주는 메서드
	public Article toEntity() {
		return Article
				.builder()
				.title(title)
				.content(content)
				.build();
	}
}
