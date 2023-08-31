package kr.top2blue.jpa.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 이 클래스를 엔티티 객체로 사용하겠다.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String dept;
	
	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
}
