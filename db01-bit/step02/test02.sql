/* 컬럼의 데이터 타입 지정
=> 문법
int
  => 정수값
numeric
  => 정수 및 부동소수점
char(x)
  => x 개의 문자를 입력할 수 있는 컬럼
  => 한 개의 문자를 입력하면 나머지 개수만큼 빈문자를 채운다.
  => 용량이 낭비되는 대신 데이터를 빨리 찾을 수 있다.
  => 최대 255자까지
varchar(x)
  => variable character라는 의미.
  => 최대 x 개의 문자를 입력할 수 있는 컬럼.
  => 입력한 문자 개수만큼만 크기를 갖는다.
  => char(x)에 비해 용량을 최적화하는 대신 데이터 찾는데 시간이 걸린다.
  => 최대 255자까지
text
  => 최대 65535자까지 입력할 수 있다.
mediumtext
  => 최대 2**24 자까지(약 1천6백만자) 입력할 수 있다.
longtext
  => 최대 2**32 자까지(약 42억자) 입력할 수 있다.
date
  => 년,월,일 날짜 입력
datetime
  => 년,월,일,시,분,초 날짜 및 시간 입력
*/

create table t2 (
  no int,
  name varchar(10),
  gender char(1),
  height numeric(4,1),
  intro text,
  bitthday date,
  regdate datetime
);

drop table t1;





/* */
