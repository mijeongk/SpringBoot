package kr.top2blue.memo.service;

import java.util.List;

import kr.top2blue.memo.vo.MemoVO;

public interface MemoService {
	// 목록보기
	List<MemoVO> getList();
	// 저장하기
	void insert(MemoVO memoVO);
	// 1개얻기
	MemoVO getById(int id);
	// 수정하기
	void update(MemoVO memoVO);
	// 삭제하기
	void delete(MemoVO memoVO);
}
