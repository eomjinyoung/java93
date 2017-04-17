/* 테이블에 컬럼 추가 및 삭제하기*/

create table t2 (
  no int,
  name varchar(10),
  gender char(1),
  height numeric(4,1),
  intro text,
  birthday date,
  regdate datetime
);

alter table t2
  add constraint primary key (no);

/* 테이블에 컬럼을 추가하기*/
alter table t2
  add column tel varchar(10);

/* 테이블에 여러 개의 컬럼을 추가하기 */
alter table t2
  add column fax varchar(10),
  add column email varchar(50),
  add column mobile varchar(10);

/* 테이블에 있는 컬럼 제거하기 */
alter table t2
  drop column email;

/* column 은 생략할 수 있다.*/
alter table t2
  drop fax;



drop table t2;





/* */
