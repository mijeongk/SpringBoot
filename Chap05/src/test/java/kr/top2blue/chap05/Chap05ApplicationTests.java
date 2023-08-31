package kr.top2blue.chap05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Chap05ApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	void contextLoads() {
		// jdbcTemplate.queryForObject(SQL명령, 리턴받을 타입)
		System.out.println("오라클에서 가져온 날짜 : " + jdbcTemplate
				           .queryForObject("select sysdate from dual", String.class));
		int a = 100, b =123;
		System.out.println("합계 : " + jdbcTemplate
				.queryForObject("select " + a + " + " + b + " from dual", Integer.class));
		System.out.println("곱셈 : " + jdbcTemplate
				.queryForObject("select " + a + " * " + b + " from dual", Integer.class));
	}

}
