package kr.top2blue.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.top2blue.jpa.dao.EmployeeRepository;
import kr.top2blue.jpa.vo.Employee;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired // 자동으로 주입
	private EmployeeRepository repository;
	
	// 모두 얻기
	public List<Employee> selectList() {
		log.info("서비스 selectList() 호출");
		List<Employee> list = new ArrayList<>(); // 리스트 생성
		try {
			// findAll() : 모든 행을 얻어온다.
			Iterable<Employee> it = repository.findAll();
			for (Employee vo : it) list.add(vo); // 반복자로 내용을 리스트에 추가
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("서비스 selectList() 리턴 : {}", list);
		return list;
	}
	
	// 저장하기
	public boolean insertOk(Employee employee) {
		log.info("서비스 insertOk({}) 호출", employee);
		boolean isSave = false;
		try {
			// DAO를 이용하여 디비에 저장하기를 수행한다.
			if(employee!=null) {
				repository.save(employee);
				isSave = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("서비스 insertOk() 리턴 : {}", isSave);
		return isSave;
	}
	// 모두 지우기
	public boolean deleteAll() {
		log.info("서비스 deleteAll() 호출");
		boolean isSave = false;
		try {
			repository.deleteAll(); // 모두 삭제
			isSave = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("서비스 deleteAll() 리턴 : {}", isSave);
		return isSave;
	}
}
