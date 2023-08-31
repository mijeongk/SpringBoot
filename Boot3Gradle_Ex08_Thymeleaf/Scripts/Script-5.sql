SELECT sysdate FROM dual;
SELECT dbms_xdb.gethttpport AS "HTTP-Port" FROM dual;

BEGIN
	dbms_xdb.sethttpport('9999');
END;

SELECT username, account_status,lock_date FROM dba_users;

ALTER USER hr account unlock;

ALTER USER hr IDENTIFIED BY "123456";

ALTER USER bootuser account unlock;

ALTER USER bootuser IDENTIFIED BY "123456";