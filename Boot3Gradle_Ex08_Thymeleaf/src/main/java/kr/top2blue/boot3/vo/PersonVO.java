package kr.top2blue.boot3.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonVO {
	private String name;
	private int age;
	private boolean gender;
}
