package kr.dwacademy.chap05;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.dwacademy.chap05.dao.TestDAO;

@SpringBootTest
class Chap05JdbcApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@Test
	void contextLoads() {
		// DB 객체가 연결도었는지 간단하게 테스트 진행
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
	}
	
	
}
