package kr.couple.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.couple.web.dao.MemberDAO;
import kr.couple.web.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Service("memberService")
@Slf4j
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO login(MemberVO vo) {
		log.info("login({}) 호출", vo);
		MemberVO memberVO = null;
		try {
			// 1. 넘어온 아니디가 존재하는지 판단
			MemberVO mvo = memberDAO.selectByMemberId(vo.getShared_id());
			if(mvo!=null) { // 지정 아이디의 회원이 있다면
				if(mvo.getShared_password().equals(vo.getShared_password())) {
					memberVO = mvo;
				}else {
					// 아이디는 있는데 비번이 틀리다.
				}
			}else {
				// 아이디가 없다
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("login({}) 리턴", vo, memberVO);
		return memberVO;
	}


	@Override
	public MemberVO getByMemberId(String shared_id) {
		log.info("getByMemberId({}) 호출", shared_id);
		MemberVO memberVO = null;
		
		try {
			memberVO = memberDAO.selectByMemberId(shared_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("getByMemberId({}) 리턴 : {}", shared_id, memberVO);
		return memberVO;
	}

	@Override
	public List<MemberVO> getList() {
		log.info("getList() 호출");
		List<MemberVO> list = null;
		
		try {
			list = memberDAO.selectByList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("getList() 리턴 : " + list);
		return list;
	}

	@Override
	public boolean insert(MemberVO VO) {
		log.info("insert({}) 호출", VO);
		boolean result = false;
		
		try {
			if(VO!=null) {
				memberDAO.insert(VO);
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("insert({}) 리턴 : {}", VO, result);
		return result;
	}

	@Override
	public boolean update(MemberVO VO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MemberVO VO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberVO findMemberId(MemberVO VO) {
		log.info("findMemberId({}) 호출", VO);
		MemberVO memberVO = null;
		
		try {
			// 전화번호로 찾기
			MemberVO dbVO = memberDAO.selectByMember_name(VO.getMember_name1());
			if(dbVO!=null) { // 이름이 있고
				// 이메일도 같으면
				if(dbVO.getEmail1().equals(VO.getEmail1())) {
					memberVO = dbVO; 
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("findMemberId({}) 리턴 : {}", VO, memberVO);
		return memberVO;
	}
	
	@Override
	public MemberVO findPassword(MemberVO VO) {
		log.info("findPassword({}) 호출", VO);
		MemberVO memberVO = null;
		
		try {
			// 아이디로 찾기
			MemberVO dbVO = memberDAO.selectByMemberId(VO.getShared_id());
			if(dbVO!=null) { // 아이디가 있고
				// 이메일도 같으면
				if(dbVO.getEmail1().equals(VO.getEmail1())||dbVO.getEmail2().equals(VO.getEmail2())) {
					
					// 임시 비밀번호를 만들고
					String newPassword = MakePassword.makePassword(10) ;
					HashMap<String, String> map = new HashMap<>() ;
					map.put("shared_id", dbVO.getShared_id()) ;
					map.put("shared_password", newPassword) ;
					memberDAO.updatePassword(map);
					
					dbVO.setShared_password(newPassword);
					
					memberVO = dbVO; 
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("findPassword({}) 리턴 : {}", VO, memberVO);
		return memberVO;
	}


	@Override
	public int getByMemberIdCount(String shared_id) {
		// TODO Auto-generated method stub
		return 0;
	}







	
	
}
