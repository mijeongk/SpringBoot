-- 버킷 리스트를 작성할 수 있는 틀을 만들자
-- 1. 버킷 리스트를 작성 할 시퀀스
CREATE SEQUENCE bucketList_seq;

-- 2. 버킷 리스트 테이블 생성
CREATE TABLE bucketList (
	id NUMBER PRIMARY KEY, -- 키필드
	shared_id varchar2(20) NOT NULL, -- 아이디
	member_name varchar2(20) NOT NULL, -- 작성자
	content varchar2(1000) NOT NULL, -- 내용   
	regdate timestamp DEFAULT sysdate, -- 작성일
	comcheck CHAR(1) CHECK(comcheck IN('1','0')), -- 완료
	comdate timestamp DEFAULT sysdate -- 완료일
);

SELECT * FROM bucketList;

DROP TABLE bucketList;
DROP SEQUENCE bucketList_seq;

INSERT INTO bucketList(id, shared_id, member_name, category, content, comcheck)
VALUES  (1, 'id','이름','카테고리','내용', 1);

INSERT ALL
      INTO bucketList(id, shared_id, member_name, category, content, comcheck) 
      VALUES (1001, 'id1','이름1','여행','국내', 1)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (2002, 'id2','이름2','공부','자바', 0)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (3003, 'id3','이름3','식단','당류 줄이기', 1)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (4004, 'id4','이름4','여행','하와이', 0)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (5005, 'id5','이름5','독서','천사의 와인', 1)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (6006, 'id5','이름6','여행','방콕', 0)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (7007, 'id5','이름7','식단','채소 하루 1번씩 먹기', 1)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (8008, 'id5','이름8','공부','영어', 0)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (9009, 'id5','이름9','공부','자바스크립트', 1)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (1010, 'id5','이름10','공부','마이바티스', 1)
      INTO bucketList(id, shared_id, member_name, category, content, comcheck)
      VALUES (1111, 'id5','이름11','공부','JPA', 0)
SELECT *
      FROM DUAL;
       
SELECT regdate  FROM BUCKETLIST b ;


SELECT * 
  FROM nls_session_parameters
 WHERE parameter = 'NLS_DATE_FORMAT';


SELECT TO_TIMESTAMP(regdate,'yyyy-mm-dd HH24:MI:SS:FF3') FROM bucketList;

SELECT TO_CHAR(TO_TIMESTAMP(regdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') FROM bucketList;

SELECT Q.*
FROM 
    (SELECT
        rownum rnum,
        R.*
    FROM 
        (SELECT 
            b.id,
            b.shared_id,
            b.member_name,
            b.category,
            b.content,
            TO_CHAR(TO_TIMESTAMP(regdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS regdate,
            comcheck,
            TO_CHAR(TO_TIMESTAMP(comdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS comdate
        FROM bucketList B
        WHERE shared_id = 'id2'
        ORDER BY id desc) R
    ) Q;

-- 버킷리스트맵퍼
   --<!-- 3. 1페이지 얻기 : 목록보기 -->
	--<select id="selectList" parameterType="hashmap" resultType="BucketListVO"> 
   -- 여기 자리에 넣기!!!!!
SELECT Q.*
FROM 
    (SELECT
        rownum rnum,
        R.*
    FROM 
        (SELECT 
            id,
            shared_id,
            member_name,
            category,
            content,
            TO_CHAR(TO_TIMESTAMP(regdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS regdate,
            comcheck,
            TO_CHAR(TO_TIMESTAMP(comdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS comdate
        FROM bucketList 
        -- WHERE shared_id = #{shared_id} -- SHARED 아이디를 받으면 쓰기!!
        ORDER BY id desc) R
    WHERE 
        <![CDATA[
    rownum <= #{endNo} -- 뒷자리 잘라내고
    ]]>
    ) Q
WHERE 
    <![CDATA[
    rnum >= #{startNo} -- 앞자리 잘라내고
    ]]>

    
SELECT 
            B.id,
            B.shared_id,
            B.member_name,
            B.category,
            B.content,
            TO_CHAR(TO_TIMESTAMP(B.regdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS regdate,
            B.comcheck,
            TO_CHAR(TO_TIMESTAMP(B.comdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS comdate
        FROM bucketList B
        WHERE shared_id = 'id2' 
        ORDER BY id desc;
       
SELECT
        rownum rnum,
        R.*
    FROM 
        (SELECT 
            B.id,
            B.shared_id,
            B.member_name,
            B.category,
            B.content,
            TO_CHAR(TO_TIMESTAMP(B.regdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS regdate,
            B.comcheck,
            TO_CHAR(TO_TIMESTAMP(B.comdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS comdate
        FROM bucketList B
        -- WHERE shared_id = 'id2' 
        ORDER BY id desc) R;

SELECT Q.*
FROM 
    (SELECT
        rownum rnum,
        R.*
    FROM 
        (SELECT 
            B.id,
            B.shared_id,
            B.member_name,
            B.category,
            B.content,
            TO_CHAR(TO_TIMESTAMP(B.regdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS regdate,
            B.comcheck,
            TO_CHAR(TO_TIMESTAMP(B.comdate,'yyyy-mm-dd HH24:MI:SS:FF3'), 'yyyy.mm.dd') AS comdate
        FROM bucketList B
        -- WHERE shared_id = 'id2' 
        ORDER BY id desc) R
    WHERE 
        rownum <= 5 -- 뒷자리 잘라내고
    ) Q
    	WHERE rnum >=2; -- 앞자리 잘라내고

