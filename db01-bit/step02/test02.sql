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
  birthday date,
  regdate datetime
);

/* 테이블 목록 보기 */
> show tables;

/* 테이블 상세 정보 보기 */
> describe 테이블명;
> desc 테이블명;

/* 테이블에 값 입력 */
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(1, '홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* no:int => 3.14 입력하면 소수점 이하가 잘려서 들어간다 */
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(3.14, '홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* varchar(10) => 12345678901 입력. 크기가 초과되어 오류 발생*/
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(4, '12345678901', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* varchar(10) => 한글 10자 입력. OK! 한글, 영어, 숫자 따지지 않고 최대 10자만 가능!
=> DBMS에 따라 동작이 다를 수 있다.
*/
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(5, '가나다라마바사아자차', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

insert into t2(no, name, gender, height, intro, birthday, regdate)
values(5, '가나다라마바사아자차카', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* numeric(4,1) => 최대 4자리 숫자. 소수점 이하 한 자리만 가능
=> 소수점 이하 2자리는 반올림 처리됨.
*/
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(6, '홍길순', 'W', 60.57, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/*
=> 소수점 위의 자릿수가 초과하면 오류!
*/
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(6, '홍길순', 'W', 2060, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* date => 날짜 정보만 저장됨
=> 시간 정보를 입력해도 날짜 정보만 저장된다.
*/
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(6, '홍길순', 'W', 150, '길순이..', '1993-5-5 7:3:5', '2017-4-17 15:23:11');

/* datetime => 날짜와 시간 정보 저장
=> 시간 정보를 주지 않으면, 0시 0분 0초로 설정된다.
*/
insert into t2(no, name, gender, height, intro, birthday, regdate)
values(6, '홍길순', 'W', 150, '길순이..', '1993-5-5', '2017-4-17');


drop table t2;





/* */
