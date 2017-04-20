// stud 테이블 데이터 처리
"use strict"

const studentDao = {}

studentDao.selectList = function(pageNo, successFn, errorFn) {
  connection.query(
    'select m.mno, m.name, m.tel, m.email, s.work \
    from stud s inner join memb m on s.sno=m.mno  \
    order by m.name asc \
    limit ?, ?',
    [(pageNo - 1) * 3, 3],
    function(error, results) {
      if (error) {
        errorFn(error)
      } else {
        successFn(results)
      }
  }) // connection.query()
}

studentDao.countAll = function(successFn, errorFn) {
  connection.query(
    'select count(*) cnt from stud',
    function(error, results) {
      if (error) {
        errorFn(error)
      } else {
        successFn(results)
      }
  }) //connection.query()
}

studentDao.selectOne = function(no, successFn, errorFn) {
  connection.query(
    'select m.mno, m.name, m.tel, m.email, s.work, s.schl_nm \
    from stud s inner join memb m on s.sno=m.mno \
    where s.sno=?',
    [no],
    function(error, results) {
      if (error) {
        errorFn(error)
      } else {
        successFn(results[0])
      }
  }) // connection.query()
} //selectOneStudent()

studentDao.insert = function(student, successFn, errorFn) {
  connection.query(
    'insert into stud(sno,work,schl_nm) values(?,?,?)',
    [ student.no, student.working, student.schoolName],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  }) //connection.query()
} //insertStudent()

studentDao.update = function(student, successFn, errorFn) {
  connection.query(
    'update stud set work=?, schl_nm=? where sno=?',
    [student.working, student.schoolName, student.no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  }) //connection.query()
} //updateStudent()

studentDao.delete = function(no, successFn, errorFn) {
  connection.query(
    'delete from stud where sno=?',
    [no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  })
}//deleteStudent()
