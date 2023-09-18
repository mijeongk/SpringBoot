package kr.couple.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.couple.web.dao.BucketListDAO;
import kr.couple.web.vo.BucketListPaging;
import kr.couple.web.vo.BucketListVO;
import lombok.extern.slf4j.Slf4j;

@Service("BucketListService")
@Slf4j
public class BucketListServiceImpl implements BucketListService{@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BucketListPaging<BucketListVO> selectList(int currentPage, int sizeOfPage, int sizeOfBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(BucketListVO bucketListVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BucketListVO view(int list_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BucketListVO bucketListVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BucketListVO bucketListVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BucketListVO selectByNo(int list_no) {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Autowired
//	private BucketListDAO bucketListDAO;
//
//	@Override
//	public BucketListPaging<BucketListVO> selectList(int currentPage, int sizeOfPage, int sizeOfBlock) {
//		log.info("selectList 호출 : {},{},{}", currentPage, sizeOfPage, sizeOfBlock);
//		BucketListPaging<BucketListVO> paging = null;
//		//-----------------------------------------------------------------------------
//		// 1. 페이지 계산을 위하여 전체개수를 구한다.
//		int totalCount = bucketListDAO.selectCount();
//		// 2. 페이지 계산을 한다.
//		paging = new BucketListPaging<>(totalCount, currentPage, sizeOfPage, sizeOfBlock);
//		// 3. 한페이지 분량의 글 목록을 가져온다.
//		HashMap<String, Integer> map = new HashMap<>();
//		map.put("startNo", paging.getStartNo());
//		map.put("endNo", paging.getEndNo());
//		List<BucketListVO> list = bucketListDAO.selectList(map);
//		// 4. 글목록을 페이징 객체에 넣어준다.
//		paging.setList(list);
//		//-----------------------------------------------------------------------------
//		log.info("selectList 리턴 : {}", paging);
//		return paging;
//	}
//	// 저장
//	@Override
//	public boolean insert(BucketListVO bucketListVO) {
//		log.info("insert 호출 : {}", bucketListVO);
//		boolean result = false;
//		//-----------------------------------------------------------------------------
//		// 객체가 존재하며
//		if(bucketListVO!=null) {
//			// 이름이 있다면
//			if (bucketListVO.getMember_name()!=null && bucketListVO.getMember_name().trim().length()>0) {
//				bucketListDAO.insert(bucketListVO);
//				result = true;
//			}
//		}
//		//-----------------------------------------------------------------------------
//		log.info("insert 리턴 : {}", result);
//		return result;
//	}
//	// 내용보기
//	@Override
//	public BucketListVO view(int list_no) {
//		log.info("view 호출 : {}", list_no);
//		BucketListVO bucketListVO = null;
//		//-----------------------------------------------------------------------------
//		// 1. 해당 번호의 글을 읽어온다.
//		bucketListVO = bucketListDAO.selectByNo(list_no);
//		//-----------------------------------------------------------------------------
//		log.info("view 리턴 : {}", bucketListVO);
//		return bucketListVO;
//	}
//
//	@Override
//	public boolean update(BucketListVO bucketListVO) {
//		log.info("update 호출 : {}", bucketListVO);
//		boolean result = false;
//		//-----------------------------------------------------------------------------
//		// 객체가 존재하며
//		if(bucketListVO!=null) {
//			// 비번이 같다면 수정을 한다.
//			BucketListVO dbVO = bucketListDAO.selectByNo(bucketListVO.getList_no());
//			if (dbVO!=null && dbVO.getMember_name().equals(bucketListVO.getMember_name())) {
//				bucketListDAO.update(bucketListVO);
//				result = true;
//			}
//		}
//		//-----------------------------------------------------------------------------
//		log.info("update 리턴 : {}", result);
//		return result;
//	}
//
//	@Override
//	public boolean delete(BucketListVO bucketListVO) {
//		log.info("update 호출 : {}", bucketListVO);
//		boolean result = false;
//		//-----------------------------------------------------------------------------
//		// 객체가 존재하며
//		if(bucketListVO!=null) {
//			// 이름이 같다면 삭제를 한다.
//			BucketListVO dbVO = bucketListDAO.selectByNo(bucketListVO.getList_no());
//			if (dbVO!=null && dbVO.getMember_name().equals(bucketListVO.getMember_name())) {
//				// 원본글 삭제
//				bucketListDAO.delete(bucketListVO.getList_no());
//			}
//		}
//		//-----------------------------------------------------------------------------
//		log.info("update 리턴 : {}", result);
//		return result;
//	}
//
//	// 1개얻기
//	@Override
//	public BucketListVO selectByNo(int list_no) {
//		return bucketListDAO.selectByNo(list_no);
//	}
	
	
}
