create sequence event_id_seq;
CREATE TABLE events (
	id number primary key,
	username VARCHAR2 (200) NOT NULL,   
	title varchar2(200) NOT NULL,		
	startDate DATE NOT NULL,		
	endDate DATE NOT NULL,		
	category varchar2(200) NOT NULL,
	allDay CHAR(1) CHECK(allDay IN('1','0'))			
);
