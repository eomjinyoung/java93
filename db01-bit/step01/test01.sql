/* SQL(Stuctured Query Language)
=> DML(Data Manipulation Language)
  => select, insert, update, delete
  => 오라클에서는 select를 따로 DQL(Data Query Language)이라 부르기도 한다.
=> DDL(Data Definition Language)
  => 데이터베이스/테이블/뷰/함수/프로시저 등을 생성, 변경, 삭제하는 명령
*/

/* 데이터 조회 명령
select 가져올 컬럼
from 데이터가 저장된 테이블
where 조회 조건
*/

/* 테이블에 모든 데이터와 모든 컬럼 값을 가져오기 */
select * from memb;

/* 테이블의 컬럼 정보 추출 */
describe memb;
desc memb;

/*[distinct 키워드]*/
/* 사용 전
=> 수강 신청된 과목의 신청번호와 과목번호를 출력하라.
*/
select lano, lno from lect_appy;

/* 사용 후
=> 수강 신청된 과목의 번호만 출력하라. 단 중복을 제거하라
*/
select distinct lno from lect_appy;

/* => 강의 데이터 중에서 강의실과 매니저 번호를 추출하라. 중복은 제거하라.
중복? 강의실번호와 매니저번호를 묶어서 같은 데이터는 하나만 출력한다.
*/
select distinct crmno, mrno from lect;

/*[all 키워드]
=> distinct 키워드를 쓰지 않으면 기본이 all이다.
*/
select lno from lect_appy;
select all lno from lect_appy;





/* */
