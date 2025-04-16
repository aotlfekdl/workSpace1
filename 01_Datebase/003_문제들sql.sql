-- EMPLOYEE테이블에서 부서코드가 D9인 사원들만 조회를 하겠다.(모든 컬럼)
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';
-- EMPLOYEE에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';
-- EMPLOYEE에서 부서코드가 'D1'가 아닌 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE 
FROM EMPLOYEE
WHERE DEPT_CODE != 'D1';
-- 월급이 400만원 이상인 사원들의 사원명, 부서코드 , 급여조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- 1. 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉(별칭-> 연봉) 조회
SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 AS "연봉"
FROM EMPLOYEE
WHERE SALARY >= 3000000;
-- 2. 연봉이 50000만원 이상인 사원들의 사원명, 급여, 연봉(별칭 -> 연봉), 부서코드 조회
SELECT EMP_NAME, SALARY, SALARY * 12 "연봉", DEPT_CODE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000;
-- 3. 직급 코드가 'J3'가 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_DATE
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';
-- 4. 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
-- 중간에 AND, OR 조건을 연결할 수 있다.
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

--입사일이 '90/01/01'이상 '01/01/01'이하인 사원들을 전체 조회
SELECT * FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/09/09' AND '01/01/01';
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
WHERE EMAIL LIKE '___/_%' ESCAPE '/';
-- 부서코드가 D6이거나 D8일거나 D5인 부서원들의 이름, 부서코드 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN('D6', 'D8', 'D5');

-- 1. 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

-- 2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%'; 

-- 3. 이름이 '하'가 포함되어있고 급여가 240만원 이상인 사우너들의 사원명, 급여조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;
-- 4. 부서(DEPT)테이블에서 해외영업부인 부서들의 부서코드, 부서명 조회
SELECT DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE LIKE '해외영업%';
-- 5. 사수(MANAGER)가 없고 부서배치도(부서코드가 없는것) 받지 않은 사원들의 사원명, 사번, 부서코드 조회
SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;
-- 6. 연봉(급여 * 12)이 3천만원 이사잉고 보너스를 받지 않는 사원들의 사번 , 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE SALARY * 12 >= 30000000 AND BONUS IS NULL;
-- 7. 입사일이 '95/01/01'이상이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일 , 부서코드 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01' AND DEPT_CODE IS NULL;
-- 8. 급여가 200만원 이상이고 500만원 이하인 사원 중에서 입사일이 '01/01/01'이상이고 보너스를 받지 않는 
--    사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
--WHERE SALARY >= 2000000 AND SALARY <= 5000000 AND HIRE_DATE >= '01/01/01' AND BONUS IS NULL; -- 두가지로 만들어 봄
WHERE SALARY BETWEEN 2000000 AND 5000000 AND HIRE_DATE >= '01/01/01' AND BONUS IS NULL;        -- 두가지로 만들어 봄



-- 9. 보너스를 포함 연봉(SALARY * (SALARY * BONUS))*12)이 NULL이 아니고 이름에 '하'가 포함된 
--    사원들의 사번, 사원명, 급여, 보너스포함 연봉 조회 
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY*BONUS) * 12
FROM EMPLOYEE
WHERE (SALARY*BONUS) * 12 IS NOT NULL AND EMP_NAME LIKE '%하%';

-- 전 사원의 사원명, 연봉 조회(이 때 연봉을 기준으로 내림차순으로 정렬
SELECT EMP_NAME, SALARY*12
FROM EMPLOYEE
ORDER BY SALARY * 12 DESC;

--사원들 중 여자사원들만 EMP_NAME, EMP_NO를 조회
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4';

--사원들 중 남자사원들만 EMP_NAME, EMP_NO를 조회
--함수 중첩 사용가능
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1' OR SUBSTR(EMP_NO, 8, 1) = '3';

--사원목록에서 사원명, 이메일, 아이디 조회
--이메일 아이디부분만 추출
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1)  --이메일 1부터 시작해서 INSTR를 사용해 @까지만 나타냄
FROM EMPLOYEE;

--*MONTHS_BETWEEN : 두 날짜 사이의 개월 수
-- 사원들의 사원명, 입사일, 근무 일수 , 근무 개월 수 조회
SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE-HIRE_DATE), FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS "근무 개월 수"
FROM EMPLOYEE;
--사원 테이블에서 사원명, 입사일, 수습기간 종료 일
--*ADD_MONTHS : 특정 날짜에 NUMBER 개월 수를 더해서 반환
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3)
FROM EMPLOYEE;
--사원의 사원명, 입사년도, 입사월, 입사일 조회
SELECT EMP_NAME, SUBSTR(HIRE_DATE, 1,2) AS "입사년도", SUBSTR(HIRE_DATE,4,2) AS "입사월", SUBSTR(HIRE_DATE,7,8) AS "입사일"
FROM EMPLOYEE;
--사원들의 이름, 입사날짜(0000년 00월 00일) 조회
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YY"년"MM"월"DD"일"')
FROM EMPLOYEE;
--사번 사우너명, 주민등록번호, 성별
-- *DECODE(비교하고자 하는 대상, 비교값 1, 결과값1, 비교값 2, 비교값 2)
SELECT EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8,1), '1', '남', '2','여') AS "성별"
FROM EMPLOYEE;
--직원의 성명, 기존급여, 인상된 급여 조회(각 직급별로 차등 인상)
--J7 직급은 급여를 10%인상(SALARY * 1.1)
--J6 직급은 급여를 15%인상(SALARY * 1.15)
--J5 직급은 급여를 20%인상(SALARY * 1.2)
--그 외 직급은 급여를 5%인상 (SALARY * 1.05
SELECT EMP_NAME, SALARY, DECODE(SUBSTR(JOB_CODE,1,2), 'J7', SALARY * 1.1, 'J6', SALARY * 1.15, 'J5', SALARY * 1.2, SALARY * 1.05) AS "인상급여"
FROM EMPLOYEE;


--전체 사원 수
SELECT COUNT(*)
FROM EMPLOYEE;
--보너스를 받은 사원의 수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

--보너스를 받지 않는 사원의 수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NULL;

--현재 사원들이 총 몇개의 부서에 분포되어 있는지를 구해라
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;


--각 부서별로 급여 총 합
SELECT SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
--그룹 : 부서
--각 부서별 사원수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
--각 직급별 총 사원 수, 보너스를 받은 사람 수, 급여합, 평균 급여, 최저시급 (정령 = 직급 내림차순)
SELECT JOB_CODE, COUNT(*), COUNT(BONUS), SUM(SALARY), AVG(SALARY), MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE DESC;
--각 부서별 평균 급여(부서코드, 평균 급여)
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
--각 부서별 평균 급여가 300만원 이상인 부서들만 조회(부서코드 평균급여)
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;
--직급별 직급 코드, 총급여 합( 단, 직급별 총 급여함이 1000만원 이상인 직급만 조회)
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;
--부서별 보너스를 받는 사원이 없는 부서의  부서코드
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;
--전체 사원들의 사번, 사원명, 부서코드, 부서명
SELECT EMP_ID, EMP_NAME,DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--2.  연결할 두 컬럼명이 동일한 경우
--전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);
-- 추가적인 조건제시
-- 직급이 대리인 사원의 사번, 사원명, 직급명, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

--1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '인사관리부';

--2. DEPRTMENT와 LOCATION테이블을 참고하여 전체 부서의
--부서코드, 부서명, 지역코드, 지역명, 조회
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);


--3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE BONUS IS NULL;
--4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE NOT DEPT_TITLE = '총무부';


--서브쿼리 예시1) 노옹철 사원과 같은 부서에 속한 사원들 전체 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE =(SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철');

SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

--전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 이름, 직급 코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (SALARY) > (SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE);

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

--1) 전 직원의 평균 급여보다 급여를 더 적게 받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY)
FROM EMPLOYEE);


SELECT AVG(SALARY)
FROM EMPLOYEE;
--2) 최저 급여를 받는 사원의 사번, 이름, 급여 입사일 조회

SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (
SELECT MIN(SALARY)
FROM EMPLOYEE);


SELECT MIN(SALARY)
FROM EMPLOYEE;


--3) 노옹철 사원의 급여보다 많이 받는 사원들의 사번, 이름, 부서명, 급여조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철');


SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

--4)부서별 급여합이 가장 큰 부서의 부서코드, 급여 합
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE);


--5) 전지연 사원과 같은 부서의 사람들의 사번, 사원명, 전화번호, 입사일, 부서명 조회
-- 단 전지연 사원은 제외
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = (SELECT DEPT_TITLE
                        FROM EMPLOYEE
                        JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
                        WHERE EMP_NAME = '전지연') AND EMP_NAME != '전지연';

SELECT DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE EMP_NAME = '전지연';
--1) 유재식 또는 윤은해 사원과 같은 직급인 사원들의 사번, 사원명, 직급코드, 급여조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('유재식', '윤은해'));

SELECT JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('유재식', '윤은해');

--2) 대리직금임에도 과장 직급의 급여들 중에서 최소급여보다 많이 받는 사원들의 사번, 이름 ,직급, 급여 조회

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE LEFT
JOIN JOB USING(JOB_CODE)
WHERE (SELECT  SALARY FROM EMPLOYEE
        WHERE JOB_CODE = 'J6') >(SELECT  SALARY FROM EMPLOYEE
                                        WHERE JOB_CODE = 'J5');

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리' AND SALARY >ANY (SELECT SALARY
                                        FROM EMPLOYEE
                                        JOIN JOB USING(JOB_CODE)
                                        WHERE JOB_NAME = '과장');

SELECT  SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J6';


SELECT  SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J5';

--1. 하이유 사원과 같은 부서코드, 같은 직급 코드에 해당하는 사원들 조회
--사원명, 부서코드, 직급코드 ,입사일

SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '하이유');

SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '하이유';

--박나라 사원과 같은 직급 코드, 같은 사수를 가지고 있는 사원들의 사번, 사원명, 직급코드, 사수번호 조회
--단 박나라 제외


SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME != '박나라' AND (JOB_CODE, MANAGER_ID) IN (SELECT JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '박나라');

SELECT JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '박나라';

SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME != '박나라' AND (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '박나라');

SELECT JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '박나라';


--1) 각 직급별 최소급여를 받는 사원조회(사번, 사원명, 직급코드, 급여)

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE

















SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE);

SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

--각 부서별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서명, 부서별 급여 합계 조회

SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY)*0.2 FROM EMPLOYEE);
                                    
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) *0.2 FROM EMPLOYEE);                                    


SELECT (SUM(SALARY)+ (SUM(SALARY)*0.2)) 
FROM EMPLOYEE
GROUP BY DEPT_CODE;


--각 부서별 최고급여를 받는 사원들의 사번, 사원명, 부서코드, 급여
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE);


;
SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;


SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE);


--1. JOB 테이블의 모든 정보 조회


--2 JOB 테이블의 직급 이름 조회


--3. DEPARTMENT 테이블의 모든 정보 조회


--4. EMPLOYEE테이블의 직원명, 이메일, 전화번호, 고용일 조회 


--5. EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회

--6.EMPLOYEE테이블에서 이름, 연봉, 총수령액(보너스포함), 실수령액(총수령액 - (연봉*세금 3%)) 조회


-- 7.EMPLOYEE테이블에서 SAL_LEVEL이 S1인 사원의 이름, 월급, 고용일, 연락처 조회

--8. EMPLOYEE테이블에서 실수령액(6번 참고)이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회

--9. EMPLOYEE테이블에 월급이 4000000이상이고 JOB_CODE가 J2인 사원의 전체 컬럼 조회


--10. EMPLOYEE테이블에 DEPT_CODE가 D9이거나 D5인 사원 중
--고용일이 02년 1월 1일보다 빠른 사원의 이름, 부서코드, 고용일 조회 


--11. EMPLOYEE테이블에 고용일이 90/01/01 ~ 01/01/01인 사원의 전체 내용을 조회

--12. EMPLOYEE테이블에서 이름 끝이 '연'으로 끝나는 사원의 이름 조회 


--13. EMPLOYEE테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 조회 
;

--14.  EMPLOYEE테이블에서 메일주소 '_'의 앞이 4자이면서 DEPT_CODE가 D9 또는 D6이고  
--고용일이 90/01/01 ~ 00/12/01이고, 급여가 270만 이상인 사원의 전체를 조회 


--15. EMPLOYEE테이블에서 사원명과 직원의 주민번호를 이용하여 생년, 생월, 생일 조회 
--701011-1234567

--16. EMPLOYEE테이블에서 사원명, 주민번호 조회 (단, 주민번호는 생년월일만 보이게 하고, '-'다음 값은 '*'로 바꾸기) 



--17. EMPLOYEE테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회 
--(단, 각 별칭은 근무일수1, 근무일수2가 되도록 하고 모두 정수(내림), 양수가 되도록 처리)


--18 EMPLOYEE테이블에서 사번이 홀수인 직원들의 정보 모두 조회


--19. EMPLOYEE테이블에서 근무 년수가 20년 이상인 직원 정보 조회 


-- 20. EMPLOYEE 테이블에서 사원명, 급여 조회 (단, 급여는 '9,000,000' 형식으로 표시)

-- 21. EMPLOYEE테이블에서 직원 명, 부서코드, 생년월일, 나이(만) 조회 
--(단, 생년월일은 주민번호에서 추출해서 00년 00월 00일로 출력되게 하며  
--나이는 주민번호에서 출력해서 날짜데이터로 변환한 다음 계산) 


-- 22. EMPLOYEE테이블에서 부서코드가 D5, D6, D9인 사원만 조회하되 D5면 총무부, D6면 기획부, D9면 영업부로 처리 
--(단, 부서코드 오름차순으로 정렬) 

-- 23. EMPLOYEE테이블에서 사번이 201번인 사원의 사원명, 주민번호 앞자리, 주민번호 뒷자리,  
--주민번호 앞자리와 뒷자리의 합 조회 


--24. EMPLOYEE테이블에서 부서코드가 D5인 직원의 보너스 포함 연봉 합 조회 


--25. EMPLOYEE테이블에서 직원들의 입사일로부터 년도만 가지고 각 년도별 입사 인원수 조회 
--전체 직원 수, 2001년, 2002년, 2003년, 2004년

















