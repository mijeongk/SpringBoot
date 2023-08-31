package kr.top2blue.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.top2blue.memo.vo.MemoVO;

@Mapper
public interface MemoDAO {
	// 1. 모두 얻기
	List<MemoVO> selectAll();
	// 2. 1개 얻기
	MemoVO selectById(int id);
	// 3. 저장하기
	void insert(MemoVO memoVO);
	// 4 수정하기
	void update(MemoVO memoVO);
	// 5. 삭제하기
	void delete(int id);
}
