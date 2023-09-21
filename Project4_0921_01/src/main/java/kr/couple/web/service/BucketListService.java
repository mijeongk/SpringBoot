package kr.couple.web.service;

import kr.couple.web.vo.BucketListVO;
import kr.couple.web.vo.Paging;

public interface BucketListService {
	// 기능 1개당 메서드 1개
	
	// 1. 목록보기
	Paging<BucketListVO> selectList(int currentPage, int sizeOfPage, int sizeOfBlock);
	// 2. 새글쓰기
	boolean insert(BucketListVO bucketListVO);
	// 3. 내용 보기
	BucketListVO view(int id);
	// 4. 수정하기
	boolean update(BucketListVO bucketListVO);
	// 5. 삭제하기
	boolean delete(BucketListVO bucketListVO);
	// 6. 1개 얻기 
	BucketListVO selectById(int id);
	
}
