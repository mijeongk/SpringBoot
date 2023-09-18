package kr.couple.web.vo;

import lombok.Data;
// 컨트롤러에서 변수값을 받을때 사용

@Data
public class BucketListCommVO {
	private int p;  // 현재페이지
	private int s;  // 페이지당 글수
	private int b;  // 하단 페이지 개수
	private int list_no; // 글번호
}
