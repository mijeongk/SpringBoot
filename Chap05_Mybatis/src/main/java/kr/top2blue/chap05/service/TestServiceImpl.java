package kr.top2blue.chap05.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.top2blue.chap05.dao.TestDAO;

@Service("testService")
public class TestServiceImpl implements TestService{
	@Autowired
	TestDAO testDAO;
	@Override
	public String getToday() {
		return testDAO.selectToday();
	}
	@Override
	public int getSum(int num1, int num2) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("num1", num1);
		map.put("num2", num2);
		return testDAO.selectSum(map);
	}
}
