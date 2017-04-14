/* 서브 쿼리
=> 쿼리문 안에 쿼리문을 실행하는 기법
=> 성능 문제를 생각하면서 사용해야 한다.
*/

/*=> 수강신청번호, 강의제목, 교실이름, 매니저이름, 매니저직급, 수강생이름, 재직여부 */
select
  la.lano,
  l.titl,
  cr.name,
  m.name,
  mr.posi,
  m2.name,
  s.work
from lect_appy la
  inner join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno
  left outer join memb m on l.mrno = m.mno
  left outer join mgr mr on m.mno = mr.mrno
  left outer join memb m2 on la.sno = m2.mno
  left outer join stud s on la.sno = s.sno;

/*
1) select 절(clause)에 서브쿼리 사용하기
*/
select
  la.lano,
  l.titl,
  (select name from croom where crmno=l.crmno) room,
  (select name from memb where mno=l.mrno) mname,
  (select posi from mgr where mrno=l.mrno) position,
  (select name from memb where mno=la.sno) sname,
  (select work from stud where sno=la.sno) working
from lect_appy la
  inner join lect l on la.lno = l.lno;







/* */
