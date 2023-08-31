-- 투표하기 테이블 작성
-- 키필드
-- 투표제목
-- 항목 : 항목1|항목2|항목3|...
-- 투표 : 0|0|0|...

-- 시퀀스 만들기
CREATE SEQUENCE poll_id sqe;
CREATE TABLE poll{
   id NUMBER PRIMARY KEY, -- 키필드
   subject varchar2(300) NOT NULL, -- 투표제목
   item varchar2(1000) NOT NULL, -- 항목
   cnt varchar2(1000) NOT NULL, -- 투표 결과
};

INSERT INTO poll VALUES (poll_id_sqe.nextval,'제일 좋아하는 과목은?','HTML|CSS|JAVA|SPRING|JS','0|0|0|0|0');

SELECT * FROM poll;