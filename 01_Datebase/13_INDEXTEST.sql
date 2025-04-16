/*
    <INDEX>
    *인덱스 : 데이터를 빠르게 검색하기 위한 데이터의 정렬과, 탐색같은 DBMS의 성능향상을
             목적으로 생성하는 객체
    -검색속도가 향상된다.(SELECT문에서 WHERE조건으로 데이터를 빠르게 검색)
    단, 모든 경우에 향상된느 것은 아니다.(INSERT, UPDATE, DELETE작업시, 인덱스도 함께 
                                        업데이트되어 성능저하될 수 있음)
*/

SELECT * FROM USER_MOCK_DATA;

--USER_INDEX_DATA와 동일한 USER_MOCK_DATA 생성
CREATE TABLE USER_INDEX_DATA
AS (SELECT * FROM USER_MOCK_DATA);

SELECT COUNT(*) FROM USER_INDEX_DATA;

--제약조건 PRIMARY KEY 추가 -> 인덱스  생성
ALTER TABLE USER_INDEX_DATA
ADD CONSTRAINT PK_USER_INDEX_ID PRIMARY KEY(ID);

--제약조건 UQ추가
ALTER TABLE USER_INDEX_DATA
ADD CONSTRAINT UQ_USER_INDEX_EMAIL UNIQUE(EMAIL);

SELECT * FROM USER_INDEXES;

--인덱스 설정 안된 테이블(USER_MOCK_DATA)
EXPLAIN PLAN FOR
SELECT * FROM USER_MOCK_DATA WHERE ID = 30000;
SELECT *FROM TABLE(DBMS_XPLAN.DISPLAY);

/*
------------------------------------------------------------------------------------
| Id  | Operation         | Name           | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |                |     5 |   665 |   137   (1)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| USER_MOCK_DATA |     5 |   665 |   137   (1)| 00:00:01 |
------------------------------------------------------------------------------------
COST : 실행예상 비용(자원을 얼마나 소비하는가) -> 값이 낮을 수록 적은 비용으로 검색을 수행할 수 있음.
ROWS : 싱행계획에서 ACCESS된 ROW 수
BYTES : 실행계획에서 ACCESS된 BYTES 수 

TABLE ACCESS FULL(FULL 스캔) : 전체 테이블을 탐색하여 결과를 도출하게 될 것이다.
*/


--인덱스 설정된 테이블(SERT_INDEX_DATA)
EXPLAIN PLAN FOR SELECT* FROM USER_INDEX_DATA WHERE ID = 30000;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

/*
 
------------------------------------------------------------------------------------------------
| Id  | Operation                   | Name             | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |                  |     1 |    63 |     2   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| USER_INDEX_DATA  |     1 |    63 |     2   (0)| 00:00:01 |
|*  2 |   INDEX UNIQUE SCAN         | PK_USER_INDEX_ID |     1 |       |     1   (0)| 00:00:01 |
------------------------------------------------------------------------------------------------
 INDEX (UNIQUE) SCAN : 인덱스 객체를 참조하여 탐색 후 결과를 도출하게 될 것을 예상한다.
 TABLE ACCESS (BY INDEX ROWID) : 인덱스 객체로 참조한 INDEX ROWID로 탐색하여 결과를 도출하게 될 것을 예상한다.
 
*/

CREATE INDEX USER_INDEX_FIRST_NAME ON USER_INDEX_DATA(FIRST_NAME);

--두 컬럼으로 조회
EXPLAIN PLAN FOR
SELECT * FROM USER_MOCK_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

EXPLAIN PLAN FOR
SELECT * FROM USER_MOCK_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

--두가지 이상으로 조건조회를 자주 할 때
--결합 인덱스 생성
CREATE INDEX USER_INDEX_FIRSTNAME_ID ON USER_INDEX_DATA(ID, FIRST_NAME);

EXPLAIN PLAN FOR
SELECT * FROM USER_MOCK_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);














