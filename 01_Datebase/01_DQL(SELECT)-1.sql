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


-- 1. 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉(별칭-> 연봉) 조회

-- 2. 연봉이 50000만원 이상인 사원들의 사원명, 급여, 연봉(별칭 -> 연봉), 부서코드 조회

-- 3. 직급 코드가 'J3'가 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회

-- 4. 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
-- 중간에 AND, OR 조건을 연결할 수 있다.

SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 as "연봉" FROM EMPLOYEE WHERE SALARY >= 3000000;

SELECT ROUND(123.456, -1) FROM DUAL;


SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_YN FROM EMPLOYEE WHERE JOB_CODE != 'J3';

SELECT EMP_NAME, EMP_ID, SALARY FROM EMPLOYEE WHERE SALARY >= 3500000 AND SALARY <= 6000000;


/*
    <AND, OR 연산자>
    조건을 여러개 연결할 때 사용
    [표현법]
    조건A AND 조건B -> 조건A와 조건 B가 모두 만족하는 값만 참으로 한다.
    조건A OR 조건B -> 조건A 와 조건 B중 하나만 만족해도 참으로 한다.
    
    <BETWEEN AND>
    조건식에 사용되는 구문
    몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 주로 사용하는 연산자 (이상, 이하만 가능)
    [표현법]
    비교대상 컬럼 BTWEEN 하향값 AND 상향값
    
*/

SELECT EMP_NAME, EMP_ID, SALARY FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

--NOT : 논리부정 연산자
-- 컬럼명 앞에 또는 BETWEEN앞에 선언 가능

--입사일이 '90/01/01'이상 '01/01/01'이하인 사원들을 전체 조회

SELECT * FROM EMPLOYEE
WHERE HIRE_DATE >= '01/01/01' AND HIRE_DATE <= '01/01/01';
-- HIRE_DATE BETWEEN '01/01/01' AND '01/01/01';

--NULL을 비교연산할때는 = 를 사용할 수 없다.
SELECT * FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

SELECT * FROM EMPLOYEE
WHERE BONUS IS NOT NULL;


/* 
    <LIKE>
    비교하고자 하는 컬럼값이 내가 제시한 특정 패턴에 만족할 경우 조회
    [표현법]
    비교할 대상컬럼 LIKE'특정패턴'; -> 일치하는 것만 가져온다.
    
    특정패턴을제 제시할 때 와일드카드라는 특정패턴이 정의되어 있다.
    1. '%': 포함문자 검색(0글자 이상 전부 조회)
    EX) 비교할 대상 컬럼 LIKE'문자%': 비교할 대상컬럼 값 중에서 해당 문자로 시작하는 값들을 전부 가져온다.
        비교할 대상 컬럼 LIKE'%문자': 비교할 대상 컬럼 값 중에서 해당 문자로 끝나는 값들을 전부 가져온다.
        비교할 대상 컬럼 LIKE'%문자%': 비교할 대상 컬럼 값 중에서 해당문자가 포함된 값은 전부 가져온다.
        
    2. '_' : 1글자를 대체검색할 때 사용
    EX) 비교할 대상 컬럼 LIKE'_문자' : 비교할 대상 컬럼 값 문자 앞에 아무글자나 딱 한글자가 있는 값을 조회
        비교할 대상 컬럼 LIKE'문자_' : 비교할 대상 컬럼 값 문자 뒤에 아무글자나 딱 한글자가 있는 값을 조회
        비교할 대상 컬럼 LIKE'_문자_': 비교할 대상 컬럼 값 문자 앞 뒤에 아무글자나 딱 한글자 씩 있는 값을 조회
        비교할 대상 컬럼 LIKE'__문자__': 내가 원하는 형태로 _를 통해서 


*/


SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';


--사원들 중에 이름 중간에 '하'라는 글자가 포함된 사원의 이름 전화번호 출력
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_하_';



--사원들 중에서 전화번호 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '__1%';

--이메일 중 앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '___%'; -> 와일드카드로 인식되기 때문에 정상적으로 출력할 수 없다.
-- 와일드카드와 일반문자를 구분해줘야한다.
-- 데이터값으로 취급하고 싶은 와일드카드 문자 앞에 나만의 탈출문자를 제시해서 탈출시켜준다.
--ESCAPE OPTION을 등록해서 사용
WHERE EMAIL LIKE '___/_%'  ESCAPE '/'; -- '/'를 이스케이프 문자로 지정하고 /뒤에있는 _는 다시 구분문자로 지정

/*
    <IN>
    WHERE절에 비교대상 컬럼값이 내가 제시한 목록중에 일치하는 값이 있는지를 검사하는 방법
    
    [표현법]
    비교대상 컬럼 IN ('값', '값', '값' ....)
*/

-- 부서코드가 D6이거나 D8일거나 D5인 부서원들의 이름, 부서코드 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

/*
    <연산자 우선순위>
    1. 산술연산자
    2. 연결연산자
    3. 비교연산자
    4. IS NULL/ LIKE/ IN
    5. BETWEEN A AND B
    6. NOT 
    7. AND
    8. OR

*/

--==================================실습===========================================
-- 1. 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';
-- 2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호
SELECT EMP_NAME, PHONE FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';
-- 3. 이름이 '하'가 포함되어있고 급여가 240만원 이상인 사우너들의 사원명, 급여조회
SELECT EMP_NAME, SALARY FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;
-- 4. 부서(DEPT)테이블에서 해외영업부인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT 
WHERE DEPT_TITLE LIKE '해외영업%';
-- 5. 사수(MANAGER)가 없고 부서배치도(부서코드가 없는것) 받지 않은 사원들의 사원명, 사번, 부서코드 조회
SELECT EMP_NAME, EMP_ID, DEPT_CODE FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;
-- 6. 연봉(급여 * 12)이 3천만원 이사잉고 보너스를 받지 않는 사원들의 사번 , 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS FROM EMPLOYEE 
WHERE SALARY * 12 >= 30000000 AND BONUS IS NULL;
-- 7. 입사일이 '95/01/01'이상이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일 , 부서코드 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE FROM EMPLOYEE 
WHERE HIRE_DATE >= '95/01/01' AND DEPT_CODE IS NULL;
-- 8. 급여가 200만원 이상이고 500만원 이하인 사원 중에서 입사일이 '01/01/01'이상이고 보너스를 받지 않는 
--    사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS FROM EMPLOYEE 
WHERE SALARY BETWEEN 2000000 AND 5000000 AND HIRE_DATE >= '01/01/01' AND BONUS IS NULL;
-- 9. 보너스를 포함 연봉(SALARY * (SALARY * BONUS))*12)이 NULL이 아니고 이름에 '하'가 포함된 
--    사원들의 사번, 사원명, 급여, 보너스포함 연봉 조회 
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY * (SALARY * BONUS)) * 12 FROM EMPLOYEE 
WHERE (SALARY * (SALARY * BONUS)) * 12 IS NOT NULL AND EMP_NAME LIKE '%하%';


















































