package kr.top2blue.memo.vo;

import java.util.Date;

import lombok.Data;

/*
create table memo(
     id number primary key,
     name varchar2(60) not null,
     password varchar2(60) not null,
     content varchar2(300) not null,
     regDate timestamp default sysdate,
     ip varchar2(50) not null
   );
필드명과 타입을 동일하게 맞춰서 작성한다.    
 */
@Data
public class MemoVO {
	private int id;
	private String name;
	private String password;
	private String content;
	private Date   regDate;
	private String ip;
}
