package kr.sw.chap05.vo;

import lombok.Data;

/*
CREATE TABLE person(
	idx NUMBER PRIMARY KEY,
	name varchar2(100) NOT NULL,
	age NUMBER DEFAULT 0
);
테이블과 1:1 맵핑 되도록 만든다.
 */
@Data
public class PersonVO {
	private int idx;
	private String name;
	private int age;
}
