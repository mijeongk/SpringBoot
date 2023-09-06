package kr.kdata.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.kdata.mybatis.vo.EmpVO;

@Mapper
public interface EmpDAO {
	List<EmpVO> selectAll(HashMap<String, String> map);
	List<Integer> selectDeptNo();
	List<String> selectJobs();
}
