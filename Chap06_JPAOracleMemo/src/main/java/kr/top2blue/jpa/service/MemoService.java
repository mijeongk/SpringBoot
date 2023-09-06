package kr.top2blue.jpa.service;

import java.util.List;

import kr.top2blue.jpa.vo.Memo;

public interface MemoService {
	// 모두 가져오기
	List<Memo> selectList();
	// 저장하기
	boolean insert(Memo memo);
}
