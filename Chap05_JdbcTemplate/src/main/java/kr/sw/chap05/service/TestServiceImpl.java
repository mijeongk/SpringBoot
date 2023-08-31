package kr.sw.chap05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.sw.chap05.dao.TestDAO;
import kr.sw.chap05.vo.TestVO;

@Service("testService")
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDAO testDAO;
	@Override
	public TestVO getToday() {
		TestVO testVO = new TestVO();
		testVO.setToday1(testDAO.today1()); // String으로 날짜얻기
		testVO.setToday2(testDAO.today2()); // Date로 날짜얻기
		return testVO;
	}

}
