package kr.couple.web.service;

import kr.couple.web.vo.BucketListPaging;
import kr.couple.web.vo.BucketListVO;

public interface BucketListService {
	// 기능 1개당 메서드 1개
	
	int selectCount();
	// 1. 목록보기
	BucketListPaging<BucketListVO> selectList(int currentPage, int sizeOfPage, int sizeOfBlock);
	// 2. 새글쓰기
	boolean insert(BucketListVO bucketListVO);
	// 3. 내용 보기
	BucketListVO view(int list_no);
	// 4. 수정하기
	boolean update(BucketListVO bucketListVO);
	// 5. 삭제하기
	boolean delete(BucketListVO bucketListVO);
	// 6. 1개 얻기 
	BucketListVO selectByNo(int list_no);
	
}
