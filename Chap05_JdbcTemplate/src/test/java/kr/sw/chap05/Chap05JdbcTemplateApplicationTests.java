package kr.sw.chap05;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.sw.chap05.dao.TestDAO;

@SpringBootTest
class Chap05JdbcTemplateApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	void contextLoads() {
		assertNotNull(jdbcTemplate);
	}
	// DAO작동 테스트
	@Autowired
	TestDAO testDAO;
	@Test
	public void testDAO() {
		System.out.println("오라클 날짜 : " + testDAO.today1());
		System.out.println("오라클 날짜 : " + testDAO.today2());
	}
}
