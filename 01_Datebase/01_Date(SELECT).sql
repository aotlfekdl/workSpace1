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

/*
    <컬럼의 별칭 지정하기>
    산술연산을 하게되면 컬럼명이 지저분해진다. 이때 컬럼명에 별칭을 부여해서 깔끔하게 가져올 수 있다.
    [표현법]
    컬럼명 별칭 또는 컬럼명 AS 별칭 또는 컬럼명 "별칭"  또는 컬럼명 AS "별칭"
*/


SELECT EMP_NAME 사원명, SALARY AS 급여, BONUS "보너스", (SALARY * 12) AS "연봉" FROM EMPLOYEE;

/* 
    <리터럴 = 임의의 값>
    임의로 지정한 문자열(' ')
*/

--EMPLOYEE테이블의 사번, 사원명, 급여
SELECT EMP_ID, EMP_NAME, SALARY, '원' 단위 FROM EMPLOYEE;

/*
    <연결연산자: ||>
    여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있다.
*/


--사번, 이름, 급여를 하나의 컬럼으로 조회

SELECT EMP_ID || EMP_NAME || SALARY FROM EMPLOYEE;
        
--EMPYOLEE 테이블에서 모든 사원의 월급을 조회한다.
--다음과 같이 결과가 나오도록 출력해라
--XX의 월급은 XX원 입니다.

SELECT EMP_NAME || '의 월급은' || SALARY || '입니다.' FROM EMPLOYEE;

/*
    <DISTINCT>
    중복제거 - 컬럼에 표시된 값들을 한번씩만 조회하고자 할 때 사용
    DISTINCT는 한 명령어에 한번만 사용 가능
*/

SELECT DISTINCT JOB_CODE FROM EMPLOYEE;

SELECT DISTINCT JOB_CODE, DEPT_CODE FROM EMPLOYEE;
--위처럼 사용시 (JOB_CODE, DEPT_CODE)를 쌍으로 묶어서 중복을 제거한 값을 보여준다.

--==============================================================================
/*
    <WHERE 절>
    조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만 조회할 때 사용
    조건식에서도 다양한 연산자를 사용할 수 있다. ㅁ
    [표현법]
    SELECT 컬럼, 컬럼, 컬럼
    FROM 테이블명
    WHERE 조건;
    >> 비교연산자 << 
    >, <, >=, <=, |대소비교
    !=, ^=, <>. : (같지 않다.)
*/

-- EMPLOYEE테이블에서 부서코드가 D9인 사원들만 조회를 하겠다.(모든 컬럼)
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

-- EMPLOYEE에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE = 'D1';

-- EMPLOYEE에서 부서코드가 'D1'가 아닌 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE != 'D1';

-- 월급이 400만원 이상인 사원들의 사원명, 부서코드 , 급여조회
SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE SALARY >= 4000000;

