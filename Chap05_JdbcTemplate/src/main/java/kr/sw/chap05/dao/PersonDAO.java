package kr.sw.chap05.dao;

import java.util.List;

import kr.sw.chap05.vo.PersonVO;
// DAO는 로직이 없고 무조건 SQL명령만을 수행한다.
// 쿼리 1개당 1개의 메서드로 구성한다.
public interface PersonDAO {
	// 모든 데이터 얻어오기
	List<PersonVO> selectAll();
	// 1개 얻어오기
	PersonVO selectByIdx(int idx);
	// 저장하기
	void insert(PersonVO personVO);
	// 수정하기
	void update(PersonVO personVO);
	// 삭제하기	
	void delete(int idx);
}
