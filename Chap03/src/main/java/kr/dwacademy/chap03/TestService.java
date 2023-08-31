package kr.dwacademy.chap03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	@Autowired
	private MemberRepository memberRepository;
	
	// 테이블에 있는 모든 데이터를 읽어오는 메서드
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}
}
