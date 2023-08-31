package kr.top2blue.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import kr.top2blue.jpa.domain.Article;

@SpringBootTest
class Chap06BlogApplicationTests {

	@Test
	void contextLoads() {
		// 일반적인 객체 생성
		Article article1 = new Article("제목", "내용");
		// 빌더 패턴에 의한 객체 생성
		Article article2 = Article.builder().title("제목").content("내용").build();
		System.out.println(article1);
		System.out.println(article2);
	}

}
