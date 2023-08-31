package kr.kdata.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kdata.mybatis.dao.EmpDAO;
import kr.kdata.mybatis.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpService {

	@Autowired
	private EmpDAO empDAO;
	
	public List<EmpVO> selectAll(Integer id){
		log.info("selectAll  호출!!!");
		List<EmpVO> list = null;
		//---------------------------------------------------------
		try {
			// 여기서 로직을 수행한다.
			list = empDAO.selectAll(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//---------------------------------------------------------
		log.info("selectAll  린턴 : {}", list);
		return list;
	}
	
	public List<Integer> selectDeptNo(){
		log.info("selectDeptNo  호출!!!");
		List<Integer> list = null;
		//---------------------------------------------------------
		try {
			// 여기서 로직을 수행한다.
			list = empDAO.selectDeptNo();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//---------------------------------------------------------
		log.info("selectDeptNo  린턴 : {}", list);
		return list;
	}
	
}
