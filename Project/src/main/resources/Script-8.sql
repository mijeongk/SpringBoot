CREATE TABLE users (
shared_id1         varchar2(20) PRIMARY KEY,
shared_password1     varchar2(20) NOT NULL,
user_name1         varchar2(20) NOT NULL,
email1             varchar(50) NOT NULL,
birth1             DATE NOT NULL,
shared_id2          varchar2(20) NOT null,
shared_password2      varchar2(20) NOT NULL,
user_name2         varchar2(20) NOT NULL,
email2             varchar(50) NOT NULL,
birth2             DATE NOT NULL
);

DROP TABLE users ;

CREATE TABLE u1 (
shared_id  varchar2(20) NOT NULL unique,
shared_password varchar2(20) NOT NULL,
user_name varchar2(20) NOT NULL,
email varchar(50) NOT NULL,
birth DATE NOT NULL 
);

DROP TABLE u1 ;

CREATE TABLE u2 (
shared_id  varchar2(20) NOT NULL unique,
shared_password varchar2(20) NOT NULL,
user_name varchar2(20) NOT NULL,
email varchar(50) NOT NULL,
birth DATE NOT NULL 
);

DROP TABLE u2 ;

INSERT INTO u1 
VALUES ('id1', '123', '이름gd', '이메일1@naver.com',  TO_DATE('1990-01-15', 'YYYY-MM-DD') );
INSERT INTO u1 
VALUES ('id2', '1233', '이름gd', '이메일1@naver.com',  TO_DATE('1990-01-15', 'YYYY-MM-DD') );
INSERT INTO u2
VALUES ('id1', '123', '이름sdfasdf4', '이메일1@naver.com',  TO_DATE('1990-01-15', 'YYYY-MM-DD') );
INSERT INTO u2
VALUES ('id2', '1234', '이름sdfasdf4', '이메일1@naver.com',  TO_DATE('1990-01-15', 'YYYY-MM-DD') );


INSERT INTO users(shared_id1,shared_password1,user_name1,email1,birth1,shared_id2,shared_password2,user_name2,email2,birth2) 
SELECT * 
   FROM u1
      INNER JOIN u2
         ON u1.shared_id = u2.shared_id AND u1.shared_password = u2.shared_password;

         /* WHERE u1.user_id = */