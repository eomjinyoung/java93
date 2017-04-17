/* 데이터 입력, 변경, 삭제*/

/* 1) 데이터 입력
=> insert 테이블명(컬럼명, 컬럼명, ...) values(값, 값, ...)
*/
insert memb(mno, name, tel, email, pwd)
values(40, '홍길동1', '1111-1111', 'hong1@test.com', '1111')

/*
=> mno 컬럼처럼 auto_increment PK 컬럼인 경우 값을 주지 않아도 된다.
   자동으로 가장 큰 값 보다 1이 큰 값으로 입력된다.
*/
insert memb(name, tel, email, pwd)
values('홍길동2', '1111-1111', 'hong2@test.com', '1111')

/*
=> 사용자 암호처럼 DB 관리자에게 노출되어서는 안되는 값은
  암호화시켜서 저장하라!
  보통 DBMS는 이런 경우를 대비해 암호화시키는 함수를 제공한다.
*/
insert memb(name, tel, email, pwd)
values('홍길동3', '1111-1111', 'hong3@test.com', password('1111'));

/*
=> 입력할 컬럼을 지정하지 않으면 전체 컬럼을 의미한다.
   값을 입력할 때 테이블에 선언된 컬럼 순서대로 입력해야 한다.
*/
insert memb
values(45, '홍길동4', '1111-1111', 'hong4@test.com', password('1111'));

/*
=> select 한 결과를 insert 할 수 있다.
*/
insert tcher(tno, hmpg)
select mno, 'http://www.bitcamp.co.kr'
from memb
where mno between 40 and 49;


/* 2) 데이터 변경하기
=> update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건
*/
update tcher set fcbk='okok', twit='nono' where tno=40;

/*
=> 테이블에 있는 모든 데이터에 대해 암호 변경하기
*/
update memb set pwd = password('1111');


/* 3) 데이터 삭제하기
=> delete from 테이블명 where 조건
*/
delete from tcher where tno in (40, 45);
delete from memb where mno in (40, 45);

/*
=> 자식테이블에서 참조하는 데이터인 경우,
   부모테이블에서 삭제할 수 없다.
*/
delete from memb where mno = 41; /* 오류 발생! */

/*
=> 부모 테이블의 데이터를 삭제하기 위해서는
  자식 테이블에서 그 데이터를 참조하는 것을 모두 제거해야 한다.
*/
delete from tcher where tno = 41; /* 자식 테이블 데이터 먼저 제거*/
delete from memb where mno = 41; /* 부모 테이블 데이터 제거 */








/* */
