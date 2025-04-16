SELECT EMP_NAME, SALARY * 12 FROM EMPLOYEE;

--EMPLOYEE테이블의 사원명, 급여, 보너스, 사원의 보너스 포함 연봉((급여+(급여+보너스))




--데이터베이스에서 NULL은 변값을 의미한다.
--모든 연산에NULL이 포함된 경우, 결과는 NULL이다. 

-- 사원명, 입사일, 근무일수를 EMPLOYEE테이블에서 조회
-- 데이터베이스에서는 날짜를 계산할 때 덧셈 뺄셈이 가능하다.
-- 현재시간 - 입사일 = 근무한 시간
-- DATE- DATE => 결과는 무조건 일로 표시가 된다.
-- 코드 실행 시 현재 날짜를 표시하는 상수: SYSDATE
-- 코드 실행 시 현재 날짜를 표시하는 상수 
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE FROM EMPLOYEE;

SELECT SYSDATE FROM DUAL;

