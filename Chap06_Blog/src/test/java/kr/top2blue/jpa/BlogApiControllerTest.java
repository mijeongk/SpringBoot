package kr.top2blue.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.top2blue.jpa.domain.Article;
import kr.top2blue.jpa.dto.AddArticleRequest;
import kr.top2blue.jpa.repository.BlogRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogApiControllerTest {
	// 객체를 만들지 않고도 테스트를 가능하게하는 목객체
	@Autowired
	protected MockMvc mockMvc; 
	// JSON을 만들고 읽기하는 객체(Jackson 라이브러리)
	@Autowired
	protected ObjectMapper objectMapper;
	// 웹 애플리케이션 정보를 가지고 있는 객체
	@Autowired
	private WebApplicationContext context;
	
	// DB관련 업무
	@Autowired
	BlogRepository blogRepository;
	
	@BeforeEach // 모든 테스트 메서드 시작전에 실행되는 메서드
	public void mockMvcSetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		blogRepository.deleteAll(); // 모든 행 삭제
	}
	
	// 테스트를 수행할 메서드 작성
	@DisplayName("블로그에 글이 저장되는지를 테스트한다.")
	@Test // 이 애노테이션이 붙은 메서드들은 모두 테스트 한다.
	public void addArticle() throws Exception{
		// 1. 테이스트할 데이터를 준비한다.
		// given
        final String url = "/api/articles"; // 테스트할 주소
        final String title = "title"; // 변수
        final String content = "content"; // 변수 선언
        // 두개의 변수로 객체 생성
        final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        // 객체를 POST 방식으로 전송하려면 JSON 문자열로 만들고
        final String requestBody = objectMapper.writeValueAsString(userRequest);
        System.out.println("만들어진 JSON 테이터 : " + requestBody);

        // 2. 실제 실행을한다.
        // when : 목객체를 이용하여 주소를 호출한다.
        ResultActions result = mockMvc.perform(post(url) // POST 전송
                .contentType(MediaType.APPLICATION_JSON_VALUE) // 전송되는 데이터의 형식
                .content(requestBody)); // 실제 전송 내용

        // 3. 실행된 결과를 결과가 올바른지 검증해본다. 
        // then : 결과 확인
        result.andExpect(status().isCreated());
        // 모든 글을 읽어온다.
        List<Article> articles = new ArrayList<>();
        blogRepository.findAll().forEach((vo)->{
							        articles.add(vo);
							     });
        // 실제 테스트!!!!
        assertThat(articles.size()).isEqualTo(1); // 개수가 1개인지 테스트
        // 첫번쨰 테이터의 title값이 "title" 인지 테스트
        assertThat(articles.get(0).getTitle()).isEqualTo(title); 
        // 첫번쨰 테이터의 content값이 "content" 인지 테스트
        assertThat(articles.get(0).getContent()).isEqualTo(content);
	}
	
	@DisplayName("블로그의 모든글을 읽어오는지 테스트한다.")
	@Test // 이 애노테이션이 붙은 메서드들은 모두 테스트 한다.
	public void findAllArticles() throws Exception{
		// 1. 테이스트할 데이터를 준비한다.
		// given
		final String url = "/api/articles"; // 테스트할 주소
		final String title = "title"; // 변수
		final String content = "content"; // 변수 선언
		
		// 1개 저장
		blogRepository.save(Article.builder().title(title).content(content).build());
		
		// 2. 실제 실행을한다.
		// when : 목객체를 이용하여 주소를 호출한다.
		ResultActions result = mockMvc.perform(get(url) // GET 전송
				.accept(MediaType.APPLICATION_JSON_VALUE)); // 데이터를 JSON 형식으로 읽겠다.

		
		// 3. 실행된 결과를 결과가 올바른지 검증해본다. 
		// then : 결과 확인
		result
		.andExpect(status().isOk()) // 성공했니?
		// 첫번째 테이터의 content가 "content"이냐?
		.andExpect(jsonPath("$[0].content").value(content))
		// 첫번째 테이터의 title의 값이 "title"이냐?
		.andExpect(jsonPath("$[0].title").value(title));
		
	}
	
	// 테스트를 수행할 메서드 작성
	@DisplayName("블로그에 글이 수정되는지를 테스트한다.")
	@Test // 이 애노테이션이 붙은 메서드들은 모두 테스트 한다.
	public void updateArticle() throws Exception{
		// 1. 테이스트할 데이터를 준비한다.
		// given
        final String url = "/api/articles"; // 테스트할 주소
        final long id = 1L;
        final String title = "수정제목"; // 변수
        final String content = "수정내용"; // 변수 선언
        
        // 일단 1개 저장하고
        blogRepository.save(Article.builder().title("제목").content("내용").build());
        
        // 수정할 객체 생성
        Article article = Article.builder().title(title).content(content).build();
        article.setId(id);

        // 객체를 PUT 방식으로 전송하려면 JSON 문자열로 만들고
        final String requestBody = objectMapper.writeValueAsString(article);
        System.out.println("만들어진 JSON 테이터 : " + requestBody);

        // 2. 실제 실행을한다.
        // when : 목객체를 이용하여 주소를 호출한다.
        ResultActions result = mockMvc.perform(put(url) // PUT 전송
                .contentType(MediaType.APPLICATION_JSON_VALUE) // 전송되는 데이터의 형식
                .content(requestBody)); // 실제 전송 내용

        // 3. 실행된 결과를 결과가 올바른지 검증해본다. 
        // then : 결과 확인
        result.andExpect(status().isOk());
        // id번의 글을 가져온다.
        Optional<Article> optional = blogRepository.findById(id);
        if(optional.isPresent()) {
        	Article article2 = optional.get();
	        // 바뀐 내용이 같은지 테스트 한다.
	        assertEquals(article2.getTitle(), title);
	        assertEquals(article2.getContent(), content);
        }else {
        	System.out.println("실패!!!!!!");
        }
        
	}
	
}
