/* where
=> 추출할 값의 조건을 설정할 때 사용한다.
=> 다양한 연산자를 사용하여 조건을 지정한다.
  and, or, not, in, <, <=, >, >=, != 등
=> 문법
select ~
from ~
where 조건
*/

/* 실행 순서: from -> where -> select -> order by */
select lno, titl, mrno
from lect
where mrno is null
order by titl asc;

/* 비교 연산자: =, <, >, <=, >=, !=, <> */
select lno, titl, mrno
from lect
where mrno = 32;

select lno, titl, mrno
from lect
where mrno != 32;

select lno, titl, mrno
from lect
where mrno <> 32;

select lno, titl, mrno, pric
from lect
where pric > 300000;

select lno, titl, mrno, pric
from lect
where pric < 300000;

select titl, sdt, edt
from lect
where sdt >= '2017-5-1';

select lno, titl, mrno
from lect
where mrno is null;
/*where mrno = null;*/ /* null 을 비교할 때는 =을 사용할 수 없다. 대신 is 를 사용하라 */

/* 산술 연산자: +, -, *, /
우선순위:
()
*, /
+, -
*/
select lno, titl, pric, (pric - (pric * 0.2)) pric2
from lect;

/* 날짜 더하기 */
select titl, sdt, date_add(sdt, interval 27 day) from lect;

/* 논리 연산자: and, or, not */
select lno, titl, mrno, pric
from lect
where pric > 300000 and pric < 500000;

select lno, titl, mrno, pric
from lect
where pric < 300000 or pric > 1000000;

select lno, titl, mrno
from lect
where not mrno = 32;

/* in 연산자 : in (값, 값, 값, ...)
=> 괄호 안에 지정한 값과 일치하는 경우 true 리턴 */
select lno, titl, mrno
from lect
where mrno in (31, 32);

/* like 연산자: 문자열 비교 연산자
=> 컬럼명 like 'aaa' ---> 컬럼명 = 'aaa'
=> 컬럼명 like 'a%'  ---> 문자 'a'로 시작하는 것
=> 컬럼명 like '%a'  ---> 문자 'a'로 끝나는 것
=> 컬럼명 like '%aaa%' ---> 문자열 'aaa'를 포함하는 것
=> 컬럼명 like 'aa_bb' ---> aa 다음에 한 문자는 어떤 것이라도 된다. 그리고 뒤에 bb가 온다.
*/
select lno, titl
from lect
where titl = '자바기초';

select lno, titl
from lect
where titl like '자바기초';

select lno, titl
from lect
where titl like '웹%';

select lno, titl
from lect
where titl like '%과정';

select *
from croom
where name like '강남_01';

/* between A and B 연산자 */
select lno, titl, pric
from lect
where pric between 150000 and 450000;

select lno, titl, sdt, edt
from lect
where sdt between '2017-5-1' and '2017-6-30';

/* is null : 값이 설정되지 않은 것 */
select lno, titl, crmno
from lect
where crmno is null;

/* union: 두 개의 결과를 더하는 연산자 */
select mrno, posi from mgr
union
select tno, hmpg from tcher
union
select sno, schl_nm from stud;

/* union: 중복 자동 제거
=> 결과를 합칠 때 중복 값(모든 컬럼의 값이 같으면)이 있으면 제거한다.
*/
select mrno from mgr
union
select tno from tcher;

/* union all : 중복 값을 허용한다. */
select mrno from mgr
union all
select tno from tcher;




/* */
