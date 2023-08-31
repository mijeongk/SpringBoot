package kr.top2blue.jpa.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article")
@Data
@NoArgsConstructor
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "content", nullable = false)
	private String content;
	
	// 작성일 : 저장될때 자동으로 입력되게한다.
	@CreatedDate
	@Column(name="created_at", updatable = false)
	private LocalDateTime createdAt;
	
	// 수정일 : 수정될때 자동으로 입력된다.
	@LastModifiedDate
	@Column(name="updated_at", updatable = false)
	private LocalDateTime updatedAt;
	
	@Builder // 객체를 빌더 패턴으로 생성하게 만들어 준다.
	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
}
