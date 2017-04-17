/* unique 옵션
=> primary key 는 아니더라도 PK 처럼 중복 데이터 입력을 막고 싶을 때 사용한다.
*/

create table t2 (
  no int,
  name varchar(10),
  email varchar(50)
);

alter table t2
  add constraint primary key (no);

/* email 컬럼을 unique 컬럼으로 지정하자!*/
alter table t2
  add constraint unique (email);

/* 예제 데이터 입력 */
insert into t2(no, name) values(1, '홍길동');

/* mysql에서는 null이 중복되는 것은 허용한다.*/
insert into t2(no, name) values(2, '임꺽정');

insert into t2(no, name, email) values(3, '유관순', 'yoo@test.com');

/* 기존에 입력된 이메일과 중복된 데이터는 입력할 수 없다. 오류발생!*/
insert into t2(no, name, email) values(4, '안중근', 'yoo@test.com');







drop table t2;





/* */
