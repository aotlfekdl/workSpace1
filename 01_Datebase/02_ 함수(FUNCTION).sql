--조건처리 하기전에 FROM을 먼저 써 줌으로써 어디정보에서 조건처리를 할지 결정한다.
SELECT EMP_ID, EMP_NAME, SALARY  --3
FROM EMPLOYEE                    --1
WHERE DEPT_CODE = 'D2';          --2

/*
    <OREDER BY절>
    SELECT문 가장 마지막 줄에 작성, 상행순서또한 가장 마지막에 실행한다.
    [표현법]
    SELECT 조회할 컬럼....
    FROM 조회할 데이블
    WHERE 조건식
    ORDER BY 정렬기준이 될 컬럼명 컬럼명| 별칭 | 컬럼 순번 [ASC | DESC]  [NULLS FIRST | NULLS LAST]
    
    ASC  : 오름차순(작은값부터 큰값으로 커지는 것 -> 기본값
    DESC : 내림차순 
    NULL은 기본적으로 가장 큰 값으로 분류해서 정렬한다.
    NULLS FIRST : 정렬하고자 하는 컬럼값에 NULL이 있는 경우 해당데이터 맨 앞에 배치(DESC일 때 기본값)
    NULLS LAST : 정렬하고자 하는 컬럼값에 NULL이 있는 경우 해당데이터 맨 뒤에 배치(ASC일 때 기본값)
    정렬기준에 컬럼값이 동일할 경우 그 다음차순을 위해서 여러개를 제시할 수 있다.
*/

SELECT BONUS, SALARY FROM EMPLOYEE
--ORDER BY BONUS;
--ORDER BY BONUS ASC;
--ORDER BY BONUS ASC NULLS LAST;
--ORDER BY BONUS DESC NULLS LAST;
ORDER BY BONUS DESC NULLS LAST, SALARY ASC ;

-- 전 사원의 사원명, 연봉 조회(이 때 연봉을 기준으로 내림차순으로 정렬

SELECT EMP_NAME, SALARY * 12 AS "연봉"
FROM EMPLOYEE
--ORDER BY SALARY * 12 DESC;
--ORDER BY 연봉 DESC;
ORDER BY 2 DESC;

--==================================================================
/*
    <함수 FUNCTION>
    전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환
    
    -단일행 함수 : N개의 값을 읽어들여서 N개의 결과값을 리턴(매행마다 함수실행결과를 반환)
    -그룹 함수 : N개의 값을 읽어들여서 1개의 결과값을 리턴(그룹을 지어 그룹별로 함수 실행결과를 반환)
    - SELECT 절에 단일행 함수와 그룹함수는 같이 사용 못함
    왜? 결과 행으 ㅣ갯수가 서로 다르기 때문에 
    
    >> 함수식을 사용할 수 있는 위치: SELECT절, WHERE절 ORDER BY절, GROUP BY절, HAVING절
    

*/
--=======================================================================

/*
    <문자 처리 함수>
    *LENGTH(컬럼 | '문자열') : 해당 문자열의 글자수를 반환
    *LENGTHB(컬럼 | '문자열') : 해당 문자열의 바이트 수를 반환

    '최' '나' 'ㄱ' 한글은 글자당 3BYTE
    영문자, 숫자, 특수만자 글자당 1BYTE
    
*/

SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME),
    EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;

/*
    *INSTR
    문자열로부터 특정 문자의 시작위치를 찾아서 반환
    
    INSTR(컬럼 | '문자열', '찾고자하는 문자', ['찾을 위치의 시작값', 순번]) -> 결과는 NUMBER로 나옴

*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
--찾을 위치의 시작값 : 1, 순번 : 1 -> 기본값
--찾을 위치의 시작값 : -1 순번 : 10 -> 뒤에서부터 찾는 순서 읽을때는 원래대로 읽어준다.

SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'B', 1, 3) FROM DUAL; 

SELECT EMAIL, INSTR(EMAIL, '_') AS "LOCATION", INSTR(EMAIL, '@') AS "@위치"
FROM EMPLOYEE;


/*
    *SUBSTR / 자주사용
    [표현법]
    SUBSTR(컬럼 | '문자열', 추출할 시작 위치, 추출문자 갯수)
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL; -- 7번째 위치부터 끝까지 가져온다.

SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;

SELECT SUBSTR('SHOWMETHEMONEY', 1,6) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) FROM EMPLOYEE;

--사원들 중 여자사원들만 EMP_NAME, EMP_NO를 조회

--사원들 중 남자사원들만 EMP_NAME, EMP_NO를 조회

SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR (EMP_NO, 8 , 1) =2 OR SUBSTR (EMP_NO, 8, 1) = 4;

SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4';

SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR (EMP_NO, 8 , 1) =1 OR SUBSTR (EMP_NO, 8, 1) = 3;

--함수 중첩 사용가능
--이메일 아이디부분만 추출
--사원목록에서 사원명, 이메일, 아이디 조회

SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') -1)
FROM EMPLOYEE;



--=====================================================================
/*
    *LPAD / RPAD
    문자열을 조회할 때 통일감 있게 조회하고자 할 때 사용함
    
    [표현법]
    LPAD / RPAD(STRING, 최종적으로 반환할 문자열의 길이, [덧붙이고자 하는 문자])

*/

--30만큼의 길이 중 EMAIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다.

SELECT EMP_NAME, LPAD(EMAIL, 30, '#  ')
FROM EMPLOYEE;
 
--사원들의 사원명, 주민번호("123456 -1XXXXXX")
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8) || 'XXXXXX'
FROM EMPLOYEE;

--===============================================================================

/*
    *LTRIM/RTRIM
    문자열에서 특정 문자를 제거한 나머지를 반환   
    LTRIM/RTRIM(컬럼| '문자열', [제거하고자 하는 문자들])
    
    문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 나머지 문자열을 반환
    
*/
SELECT LTRIM('   K     H   ') FROM DUAL; -- 앞에서부터 다른 문작가 나올 떄까지 공백 제거
SELECT LTRIM('123123KH123', '123') FROM DUAL; -- 앞에서부터 다른 문자가 나올 때까지 1, 2, 3 제거하므로 123123은 제거
                                              -- KH가 나온 후 부터 제거를 그만 하므로 뒤 123은 나오는게 정상

SELECT LTRIM('ACABACCAKH', 'ABC') FROM DUAL; -- 제거하고자 하는 문자는 문자열이 아닌 문자 들이다.

/* 
     *TRIM
     문자열의 앞/뒤/양쪽에 있는 저장한 문자들을 제거한 나머지 문자열을 반환
     TRIM([LEADING | TRAILING | BOTH] 제거하고자 하는 문자열 FROM 문자열)

*/
SELECT TRIM('      K     H   ') FROM DUAL;

SELECT TRIM('Z' FROM 'ZZZZZZZKHZZZZZZZ') FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZZZZZKHZZZZZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZZZZZKHZZZZZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZZZKHZZZZZZZ') FROM DUAL;

/*
    *LOWER / UPPER / INITCAP
    
    LOWER : 다 소문자로 변경한 문자열을 반환
    UPPER : 다 대문자로 변경한 문자열을 반환
    INITCAP : 띄어쓰기 기준 첫 글자마다 대문자로 변경한 문자열 반환
*/

SELECT LOWER('Welcome To My KH') from dual;
SELECT upper('Welcome To My KH') from dual;
SELECT initcap('welcome to my kh') from dual;



/*
    *CONCAT
    문자열 두개 전달받아서 하나로 합친 후 반환
    CONCAT(STRING, STRING2)
*/

SELECT CONCAT('가나다', 'ABC') FROM DUAL;

SELECT '가나다' || 'ABC' FROM DUAL;

/*
    *REPLACE
    문자열에서 특정부분을 다른 부분으로 교체
    REPALACE(문자열, 찾을 문자열, 변경할 문자열)

*/

SELECT EMAIL, REPLACE(EMAIL, 'C##SERVER', 'kh')
FROM EMPLOYEE;

--=====================================================================
/*
    <숫자처리함수>
    *ABS
    숫자의 절대값을 구하는 함수
*/

SELECT ABS(-10), ABS(-5.4) FROM DUAL;

/*
    *MOD
    두 수를 나눈 나머지값을 반환
    MOD(NUMBER, NUMBER)
*/

SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(11, 3) FROM DUAL;
--========================================================================

/*
    *ROUND 
    반올림한 결과를 반환
    ROUND(NUMBER, [위치])
*/
SELECT ROUND(123.456) FROM DUAL;    --기본자수는 소수점 첫번 째 자리에서 반올림
SELECT ROUND(123.456, 1) FROM DUAL; -- 양수로 증가할 수록 소수점 뒤로 한칸씩 이동
SELECT ROUND(123.456,-1) FROM DUAL; -- 음수로 감소할 수록 소수점 앞으로 한칸씩 이동

/*
    *CEIL
    올림처리를 위한 함수
    CEIL(NUMBER)
*/

SELECT CEIL(123.456) FROM DUAL;

/*
    *TRUNNC, FLOOR
    버림처리 함수
    TRUNC(NUMBER, [위치])
    FLOOR(NUMBER)
*/

SELECT TRUNC(123.952) FROM DUAL;
SELECT TRUNC(123.952, 1) FROM DUAL;
SELECT TRUNC(123.952, -1) FROM DUAL;

--==========================================================================================================
--==========================================================================================================
--2024-12-18-수요일
/*
    <날짜 처리 함수>
    
*/
--*SYSDATE: 시스템의 현재 날짜 및 시간을 반환

SELECT SYSDATE
FROM DUAL;

--*MONTHS_BETWEEN : 두 날짜 사이의 개월 수
-- 사원들의 사원명, 입사일, 근무 일수 , 근무 개월 수 조회

SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE- HIRE_DATE) , CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

--*ADD_MONTHS : 특정 날짜에 NUMBER 개월 수를 더해서 반환

SELECT ADD_MONTHS(SYSDATE, 7) FROM DUAL;

--사원 테이블에서 사원명, 입사일, 수습기간 종료 일
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3) FROM EMPLOYEE;

--*NEXT_DAY(DATE, 요일(문자 | 숫자) : 특정 날짜 이후 가장 가까운 요일의 날짜 확인
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, '일') FROM DUAL;
--1: 일 2:월 3:화 4:수 5:목 6:금 7:토

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;

--*LAST_DAY(DATE) : 해당 월의 마지막 날짜 구해서 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

/*
    *EXTRACT : 특정 날짜로부터 년 1월 1일 값을 추출해서 반환하는 함수
        [표현법]
        EXTRACT(YEAR FROM DATE) : 연도만 추출
        EXTRACT(MONTH FROM DATE) : 월만 추출
        EXTRACT(DAY FROM DATE) : 일만 추출

*/
--사원의 사원명, 입사년도, 입사월, 입사일 조회
SELECT EMP_NAME, 
EXTRACT(YEAR FROM HIRE_DATE) AS "입사년도" ,EXTRACT(MONTH FROM HIRE_DATE) AS "입사월",EXTRACT(DAY FROM HIRE_DATE) AS "입사일"
FROM EMPLOYEE;
--===============================================================================================================================

/*
    <형 변환 함수>
    *TO_CHAR : 숫자타입 또는 날짜 타임의 값을 문자타입으로 변환시켜주는 함수
    [표현법]
    TO_CHAR(숫자 | 문자, [포멧])
    
*/
--숫자 -->  문자
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(12, '99999') FROM DUAL; --9의 자리수만큼 공간 확보
SELECT TO_CHAR(12, '00000') FROM DUAL; --0의 자리수만큼 공간 확보하고 빈칸을 0으로 채움
SELECT TO_CHAR(12, '55555') FROM DUAL; --5는 사용못함
SELECT TO_CHAR(2000000, 'L9999999') FROM DUAL; --현재 설정된 나라의 로컬 화폐단위를 나타냄
SELECT TO_CHAR(2000000, '9,999,999') FROM DUAL;

--날짜타임 -> 문자타입
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL; --AM, PM 어떤것을 사용하건 형식을 정해주는 것
SELECT TO_CHAR(SYSDATE, 'AM HH/MI/SS') FROM DUAL;

--만약 현재시간에서 시간을 추가하고 싶다면 INTERVAL 사용
/*
    <INTERVAL>
    시간을 더하는 법
    [표현법]
SELECT TO_CHAR(SYSDATE + INTERVAL '6' HOUR, 'AM HH/MI/SS') FROM DUAL;
*/
SELECT TO_CHAR(SYSDATE + INTERVAL '12' HOUR, 'AM HH/MI/SS') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY DY')FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY DY')FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY DY AM HH/MI/SS')FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" DAY DY AM HH"시"MI"분"SS"초"')FROM DUAL; --한글을 추가할 때에는 "문자"를 넣도록 하자

--사원들의 이름, 입사날짜(0000년 00월 00일) 조회
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') FROM EMPLOYEE;
SELECT EMP_NAME, TO_CHAR(SUBSTR(SYSDATE, 'YY"년" MM"월" DD"일"')) FROM EMPLOYEE;

--년도와 관련된 포멧
SELECT TO_CHAR(SYSDATE, 'YYYY'), 
    TO_CHAR(SYSDATE, 'YY'),
    TO_CHAR(SYSDATE, 'YYY'),
    TO_CHAR(SYSDATE, 'YEAR'),
    TO_CHAR(SYSDATE, 'RRRR') --RR룰이 따로 존재한다. -> 50년 이사잉면 다음 세기, 50년 이하면 현재 세기
    FROM DUAL;

SELECT TO_CHAR(TO_DATE('24', 'RRRR'),'YYYY'),  --현재세기(2000)으로 해석
       TO_CHAR(TO_DATE('60', 'RRRR'), 'YYYY'),  --50년 이상이므로 과거로 해석
       TO_CHAR(TO_DATE('2024', 'YYYY'), 'YYYY'),
       TO_CHAR(TO_DATE('1960', 'YYYY'), 'YYYY')
       FROM DUAL;
       
--월과 관련된 포멧
SELECT TO_CHAR(SYSDATE, 'MM'),
        TO_CHAR(SYSDATE, 'MON'),
        TO_CHAR(SYSDATE, 'MONTH')
        FROM DUAL;

--월과 관련된 포멧
SELECT TO_CHAR(SYSDATE, 'DDD'), --오늘이 이번년도에 몇번째 일수
        TO_CHAR(SYSDATE, 'DD'), --오늘일자
        TO_CHAR(SYSDATE, 'D')   --요일
FROM DUAL;

--요일을 나타내는 포멧
SELECT TO_CHAR(SYSDATE, 'DAY'), TO_CHAR(SYSDATE, 'DY') FROM DUAL;

--================================================================================
/*
    *TO_DATE : 숫자타입 또는 문자 타입을 날짜 타입으로 변경하는 함수
    
    *TO_DATE(숫자 | 문자, [포멧]) --> DATE
*/
SELECT TO_DATE(20100101) FROM DUAL; --이것은 기본적으로 연도를 2자리만 입력시 RR룰을 사용
SELECT TO_DATE(241218) FROM DUAL;

SELECT TO_DATE(051218) FROM DUAL;  --숫자는 0으로 시작하는 숫자는 없다.
SELECT TO_DATE('051010') FROM DUAL;

SELECT TO_DATE('020505 120500') FROM DUAL;   --포멧을 정해주게 되어있음
SELECT TO_DATE('020505 120500', 'YYDDMM HHMISS') FROM DUAL;  

SELECT TO_DATE('020505 230500', 'YYDDMM HH24MISS') FROM DUAL;  

/*
    *TO_NUMBER : 문자타입의 데이터를 숫자타입으로 변환시켜주는 함수
    [표현법]
    TO_NUMBER(문자, [포멧])
*/
SELECT TO_NUMBER('0065431642511') FROM DUAL;
SELECT '1000' + '3000' FROM DUAL; --기본적으로 문자열 -> 숫자로 자동변환이 진해오딘다.
SELECT '100,000' + '30,000' FROM DUAL;  --이것은 숫자 사이에 , 이 들어가있어서 ,는 숫자로 변환이 안되기 때문에 오류
SELECT TO_NUMBER('100,000', '999,999') TO_NUMBER('30,000', '999,999') FROM DUAL;

/*
    <NULL처리 함수>
*/
--NUL(컬럼, 해당컬럼이 NULL일 경우 보여줄 값)
SELECT EMP_NAME, BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

SELECT EMP_NAME, (SALARY + (SALARY * NVL(BONUS, 0))) * 12 FROM EMPLOYEE;
--*NVL2(컬럼, 반환값1, 반환값 2)
--반환값 1 : 해당컬럼이 존재하면 보여줄 값
--반환값 2 : 해당컬럼이 존재하지 않으면 보여줄 값

SELECT EMP_NAME, BONUS, NVL2(BONUS, 'O', 'X') FROM EMPLOYEE;

--*NULLIF(비교대상, 비교대상2)
--두 값이 일치하면 NULL, 일치하지 않으면 비교대상1 반환
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;
--================================================================================
/*
    [선택함수]
    *DECODE(비교하고자 하는 대상, 비교값 1, 결과값1, 비교값 2, 비교값 2)
*/

--사번 사우너명, 주민등록번호, 성별
SELECT EMP_ID, EMP_NAME, EMP_NO, 
    DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여', '3', '남', '4', '여') AS "성별"
    FROM EMPLOYEE;
    

--직원의 성명, 기존급여, 인상된 급여 조회(각 직급별로 차등 인상)
--J7 직급은 급여를 10%인상(SALARY * 1.1)
--J6 직급은 급여를 15%인상(SALARY * 1.15)
--J5 직급은 급여를 20%인상(SALARY * 1.2)
--그 외 직급은 급여를 5%인상 (SALARY * 1.05


SELECT EMP_ID, EMP_NAME, SALARY AS "인상전",
    DECODE(SUBSTR(JOB_CODE, 2, 1), '7', SALARY * 1.1, '6', SALARY * 1.15, '5', SALARY * 1.2, '4', SALARY * 1.05, '3',SALARY * 1.05, '2', SALARY * 1.05, '1',SALARY * 1.05) AS "연봉"
    FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY AS "인상전",
    DECODE(SUBSTR(JOB_CODE, 2, 1), '7', SALARY * 1.1,
    '6', SALARY * 1.15,
    '5', SALARY * 1.2,
     SALARY * 1.05) AS "인상 후"  -- 그 외에는 생략한다면 마지막으로 처리
    FROM EMPLOYEE;

/*
    *CASE WHEN THEN
    CASE
        WHEN 조건식1 THEN 결과값1
        WHEN 조건식2 THEN 결과값2
        ...
        ELSE 결과값
    END
*/
SELECT EMP_ID, EMP_NAME, SALARY,
    CASE
        WHEN SALARY >= 5000000 THEN '고급'
        WHEN SALARY >= 3500000 THEN '중급'
        ELSE '초급'
    END
FROM EMPLOYEE;

--==============================================================================
-- 1. SUM(숫자타입 컬럼) : 해당컬럼 값들의 총 합계를 구해서 반환해주는 함수
-- 직원들의 모든 급여의 합을 구해라
SELECT SUM(SALARY) FROM EMPLOYEE;

SELECT SUM(SALARY), EMP_NAME FROM EMPLOYEE; --이것은 사용할 수 없다. 단일 함수와 그룹 함수가 같이 들어가 있기 때문에 출려갛ㄹ 때문제가 있다.

--남자사원들의 총 급여
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

--부서코드가 'D5'인 사원들의 총 연봉 (SALARY * 12)
SELECT SUM(SALARY *12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- 2. AVG(NUMVER) : 해당 컬럼 값들의 평군을 구해서 반환
SELECT CEIL(AVG(SALARY))
FROM EMPLOYEE;

-- 3. MIN(모든 타입 가능) : 해당 컬럼값 중 가장 작은 값을 구해서 반환
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;
-- 4. MAX(모든 타입 가능) : 해당 컬럼값 중 가장 큰 값을 구해서 반환
SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

-- 5. COUNT(* | 컬럼 | DISTINCT 컬럼) : 해당 조건에 맞는 행으 ㅣ갯수를 세서 반환
--COUNT(*) : 조회된 결과에 모든 행의 갯수를 세서 반환
--COUNT(컬럼) : 제시한 해당 컬럼값이 NULL이 아닌것만 행의 수를 세서 반환
--COUNT(DISTINCT 컬럼) : 해당 컬럼값 중복을 제거한 후 행의 갯수를 세서 반환
--DISTINCT   
--    중복제거  - 컬럼에 표식된 값들을 한번씩만 조회하고자 할 때 사용

--전체 사원 수
SELECT COUNT(*) FROM EMPLOYEE;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');

--보너스를 받은 사원의 수
SELECT COUNT(BONUS)
FROM EMPLOYEE;

--보너스를 받지 않는 사원의 수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

--현재 사원들이 총 몇개의 부서에 분포되어 있는지를 구해라

SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;
