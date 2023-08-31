package kr.top2blue.chap05.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

// 이것을 적어야 내부적으로 DAOImpl이 생기면서 testDAO를 만들어 등록해 준다.
@Mapper 
public interface TestDAO {
	// 맵퍼파일을 참조하여 인터페이스를 만든다.
	// id가 메서드명이고 resultType이 리턴 타입이고
	// parameterType이 매개변수가 된다.
	String selectToday();
	int selectSum(HashMap<String, Integer> map);
}
