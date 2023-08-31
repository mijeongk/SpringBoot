package kr.sw.chap05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.sw.chap05.vo.PersonVO;
// RowMapper는 1줄을 읽어 객체 1개를 만들어 리턴하도록 하는 객체
public class PersonRowMapper implements RowMapper<PersonVO>{

	@Override
	public PersonVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonVO vo = new PersonVO();
		vo.setIdx(rs.getInt("idx"));
		vo.setName(rs.getString("name"));
		vo.setAge(rs.getInt("age"));
		return vo;
	}

}
