

--일반 사용자 계정을 생성하는 구문(오직 관리자 계정에서만 사용할 수 있음)
CREATE USER c##SERVER IDENTIFIED BY SERVER;
--[표현법] CREATE USER C##계정명 IDENTIDIED BY 비밀번호;
--SQL은 대소문자를 구분하지 않지만 비밀번호는 대소문자를 구분함.
--위에서 생성된 일반 사용자계정에 최소한의 권환(접속, 데이터관리) 부여
--[표현법] GRANT 권한1, 권한2 //// to 계정;


GRANT CONNECT, RESOURCE TO c##SERVER;

CREATE USER c##SERVERT IDENTIFIED BY SERVER;
GRANT CONNECT, RESOURCE TO c##SERVERT;

ALTER USER C##SERVERT DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;


--================================================================================
--KH계정으로 전환
CREATE USER C##KH IDENTIFIED BY KH;
GRANT CONNECT, RESOURCE TO C##KH;
ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
--==========================================================================

CREATE USER C##DH IDENTIFIED BY DH;
GRANT CONNECT, RESOURCE TO C##DH;
ALTER USER C##DH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;


--==============================================================================
CREATE USER C##TEST IDENTIFIED BY TEST;
GRANT CONNECT, RESOURCE TO C##TEST;
ALTER USER C##TEST DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

--==============================================================================
CREATE USER C##INDEXTEST IDENTIFIED BY INDEXTEST;
GRANT CONNECT, RESOURCE TO C##INDEXTEST;
ALTER USER C##INDEXTEST DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

--==============================================================================

CREATE USER C##JDBC IDENTIFIED BY JDBC;
GRANT CONNECT, RESOURCE TO C##JDBC;
ALTER USER C##JDBC DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

--==============================================================================

CREATE USER C##JDBC1 IDENTIFIED BY JDBC1;
GRANT CONNECT, RESOURCE TO C##JDBC1;
ALTER USER C##JDBC1 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

--================================================================================


DROP USER C##JDBCPROJECT;
CREATE USER C##JDBCPROJECT IDENTIFIED BY JDBCPROJECT;
GRANT CONNECT, RESOURCE TO C##JDBCPROJECT;
ALTER USER C##JDBCPROJECT DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
--==============================================================================

DROP USER C##JSP;
CREATE USER C##JSP IDENTIFIED BY JSP;
GRANT CONNECT, RESOURCE TO C##JSP;
ALTER USER C##JSP DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

--==============================================================================
CREATE USER C##spring IDENTIFIED BY spring;
GRANT CONNECT, RESOURCE TO C##spring;
ALTER USER C##spring DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
















