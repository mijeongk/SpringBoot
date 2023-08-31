package kr.dwacademy.chap05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.dwacademy.chap05.dao.TestDAO;
// 서비스 클래스는 비지니스 로직을 수행하는 클래스이다.
@Service("testService")
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDAO testDAO;
	@Override
	public String getToday() {
		// 날짜를 얻는데 로직 필요없다 바로 가져와보자
		return testDAO.selectToday();
	}
}
