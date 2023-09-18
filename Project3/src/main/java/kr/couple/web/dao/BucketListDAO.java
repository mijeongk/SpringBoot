package kr.couple.web.dao;

import java.util.HashMap;
import java.util.List;

import kr.couple.web.vo.BucketListVO;


public interface BucketListDAO {
	// <!-- 1. 전체 개수 얻기 : 페이징 -->
	int selectCount();
	// <!-- 2. 1개 얻기 : 내용보기/수정/삭제 -->
	BucketListVO  selectById(int id);
	//<!-- 3. 1페이지 얻기 : 목록보기 -->
	List<BucketListVO> selectList(HashMap<String, Integer> map);
	// <!-- 4. 저장하기 -->
	void insert(BucketListVO bucketListVO);
	// <!-- 5. 수정하기 -->
	void update(BucketListVO bucketListVO);
	// <!-- 6. 삭제하기 -->
	void delete(int id);

}
