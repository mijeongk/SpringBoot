package kr.sw.chap05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.sw.chap05.dao.PersonDAO;
import kr.sw.chap05.vo.PersonVO;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Override
	public List<PersonVO> selectAll() {
		return personDAO.selectAll();
	}

	@Override
	public PersonVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PersonVO personVO) {
		if(personVO!=null) personDAO.insert(personVO);		
	}

	@Override
	public void update(PersonVO personVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idx) {
		PersonVO vo = personDAO.selectByIdx(idx); // 해당글이 있는지 읽어온다.
		// 글이 있으면 삭제한다.
		if(vo!=null) {
			personDAO.delete(idx); //디비에서 지워!!!
		}
	}

}
