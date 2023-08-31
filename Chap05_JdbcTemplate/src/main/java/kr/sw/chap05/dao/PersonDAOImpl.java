package kr.sw.chap05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.sw.chap05.vo.PersonVO;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PersonVO> selectAll() {
		return jdbcTemplate.query("select * from person order by idx desc",
          		new PersonRowMapper());
	}

	@Override
	public PersonVO selectByIdx(int idx) {
		return jdbcTemplate.queryForObject("select * from person where idx=?", new PersonRowMapper(), idx);
	}

	@Override
	public void insert(PersonVO personVO) {
		// 저장하기
		jdbcTemplate.update("insert into person values (person_idx_seq.nextval,?,?)",
				             personVO.getName(), personVO.getAge());
	}

	@Override
	public void update(PersonVO personVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idx) {
		jdbcTemplate.update("delete from person where idx=?", idx);
	}

}
