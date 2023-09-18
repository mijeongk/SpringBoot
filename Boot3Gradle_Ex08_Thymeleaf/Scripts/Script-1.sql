-- 버킷 리스트를 작성할 수 있는 틀을 만들자
-- 1. 버킷 리스트를 작성 할 시퀀스
CREATE SEQUENCE bucketList_seq;

-- 2. 버킷 리스트 테이블 생성
CREATE TABLE bucketList (
   shared_id varchar2(20) PRIMARY KEY, -- 키필드
   list_no NUMBER NOT NULL, -- 원본글 번호
   member_name varchar2(20) NOT NULL, -- 작성자
   category varchar2(200) NOT NULL, -- 카테고리
   content varchar2(1000) NOT NULL, -- 내용   
   regdate timestamp DEFAULT sysdate, -- 작성일
   comcheck CHAR(1) CHECK(comcheck IN('1','0')), -- 완료
   comdate timestamp DEFAULT sysdate -- 완료일
);

SELECT * FROM bucketList;

DROP TABLE bucketList;