package kr.sw.chap05.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String today1() {
		return jdbcTemplate.queryForObject("select sysdate from dual", String.class);
	}

	@Override
	public Date today2() {
		return jdbcTemplate.queryForObject("select sysdate from dual", Date.class);
	}

}
