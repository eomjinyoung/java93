/* 외부키 컬럼
=> 다른 테이블의 PK 컬럼을 참조하는 FK(Foreign Key) 컬럼 만들기
*/

/* 1) 부모 테이블 선언 */
create table t2 (
  no int,
  title varchar(10),
  content text
);

alter table t2
  add constraint primary key (no);

alter table t2
  modify column no int auto_increment;

/* 예제 데이터 입력 */
insert into t2(title, content) values('제목1', '내용.....');
insert into t2(title, content) values('제목2', '내용.....');
insert into t2(title, content) values('제목3', '내용.....');

/* 2) 자식 테이블 생성
=> 부모 테이블의 데이터를 참조하는 테이블을 자식 테이블이라 한다.
*/
create table t3 (
  no int,
  bno int not null,
  file varchar(100) not null
);

alter table t3
  add constraint primary key (no);
alter table t3
  modify column no int auto_increment;

/* 예제 데이터 입력
=> 이 테이블의 목표는 t2 테이블에 입력한 게시글의 첨부파일 경로를 저장하는 것이다.
=> bno 컬럼에 t2 테이블의 게시물 번호를 저장할 것이다.
=> 그러나 다음과 같이 존재하지 않는 게시물의 번호를 저장하더라도 오류가 발생하지 않는다.
   이것은 데이터 신뢰에 치명적인 타격을 준다.
=> 해결 방법?
  bno 컬럼이 t2 테이블의 PK 값을 저장할 것이라고 선언하면 된다.
*/
insert into t3(bno, file) values(10, 'aaa.gif');

/* t3 테이블에 무효한 데이터가 들어있는 상황에서는 FK 컬럼을 지정할 수 없다.
  => 기존에 등록된 데이터를 삭제해야 한다.*/
delete from t3;

/* t3의 bno 컬럼을 FK 컬럼을 만든다.*/
alter table t3
  add foreign key (bno) references t2(no);

/* 다시 무효한 게시물 번호를 가리키는 데이터를 입력해보자!
  => bno에 입력한 게시물 번호 10은 t2 테이블에 존재하지 않는 PK 값이기 때문에 오류 발생!*/
insert into t3(bno, file) values(10, 'aaa.gif');

insert into t3(bno, file) values(2, 'aaa.gif'); /* OK */



/* 다른 테이블이 참조하는 데이터 있을 경우, 부모 테이블의 데이터를 지울 수 없다.
  또한 다른 테이블이 참조하는 부모 테이블은 삭제할 수 없다.
  해결책?
  먼저 자식 테이블을 삭제하라!*/
drop table t3;
drop table t2;





/* */
