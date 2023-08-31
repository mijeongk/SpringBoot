-- 관리자로 로그인
conn /as sysdba;
-- 계정 정보 출력
select username,account_status,lock_date from dba_users;
-- hr 계정 락 해제
alter user hr account unlock;
-- hr 계정 암호 변경
alter user hr identified by "123456";
-- hr 계정으로 로그인
conn hr/1234
