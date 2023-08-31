package kr.top2blue.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.top2blue.memo.dao.MemoDAO;
import kr.top2blue.memo.vo.MemoVO;
import lombok.extern.slf4j.Slf4j;

@Service("memoService")
@Slf4j // 로그를 출력하기 위하여 사용. 자동으로 log변수가 생성 됩니다.
public class MemoServiceImpl implements MemoService {

	@Autowired
	MemoDAO memoDAO;

	@Override
	public List<MemoVO> getList() {
		log.info("MemoService의 getList() 호출");
		List<MemoVO> list = null;
		try {
			list = memoDAO.selectAll();
		}catch (Exception e) {
			e.printStackTrace(); // 개발시는 에러를 추적한다.
		}
		log.info("MemoService의 getList() 리턴 : {}", list);
		return list;
	}

	@Override
	public void insert(MemoVO memoVO) {
		// 저장하기
		try {
			if(memoVO!=null) {
				// 넘어온 값의 유효성을 검증하는 코드가 들어가야 한다.
				memoDAO.insert(memoVO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemoVO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MemoVO memoVO) {
		// 수정하기
		try {
			if(memoVO!=null) {
				// 입력한 비밀번호와 저장된 비밀번호가 같을 경우만 수정을 한다.
				// 1. 해당 글번호의 글을 디비에서 가져온다.
				MemoVO dbVO = memoDAO.selectById(memoVO.getId());
				// 2. 가져온 글의 비번과 넘어온 비번이 일치하면 그때 수정을 한다. 
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())){
					memoDAO.update(memoVO);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(MemoVO memoVO) {
		// 삭제 하기
		try {
			if(memoVO!=null) {
				// 입력한 비밀번호와 저장된 비밀번호가 같을 경우만 삭제를 한다.
				// 1. 해당 글번호의 글을 디비에서 가져온다.
				MemoVO dbVO = memoDAO.selectById(memoVO.getId());
				// 2. 가져온 글의 비번과 넘어온 비번이 일치하면 그때 삭제을 한다. 
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())){
					memoDAO.delete(memoVO.getId());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
