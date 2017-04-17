/* auto_increment 옵션
=> PK 컬럼에 대해 자동증가 기능을 붙이기
=> PK 컬럼이 아닌 경우 auto_increment를 붙일 수 없다.
*/

/* 1) 테이블 정의할 때 auto_increment 붙이기 */
create table t2 (
  no int primary key auto_increment,
  name varchar(10),
  email varchar(50)
);

/* 2) 테이블 정의한 후 auto_increment 붙이기*/
create table t2 (
  no int,
  name varchar(10),
  email varchar(50)
);

alter table t2
  add constraint primary key (no);

/* 기존의 PK 컬럼을 auto_increment로 만들기 */
alter table t2
  modify column no int auto_increment;

/* 예제 데이터 입력 */
insert into t2(name, email) values('홍길동', 'hong@test.com');
insert into t2(name, email) values('홍길동2', 'hong2@test.com');
insert into t2(name, email) values('홍길동3', 'hong3@test.com');

/* 번호에 구멍을 내보자!*/
delete from t2 where no=2;

/* 중간에 번호가 빠져있다고 해서 중간 번호를 채우면서 증가하지 않는다.
  항상 가능 큰 값으로 번호를 증가한다*/
insert into t2(name, email) values('홍길동4', 'hong4@test.com');



drop table t2;





/* */
