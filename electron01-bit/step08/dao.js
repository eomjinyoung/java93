// 데이터 처리를 담당하는 자바스크립트
// => DAO(Data Access Object)
"use strict"
const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
connection.connect()

function selectListStudent(pageNo, successFn, errorFn) {
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

function countAllStudent(successFn, errorFn) {
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

function selectOneStudent(no, successFn, errorFn) {
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

function insertStudent(student, successFn, errorFn) {
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

function insertMember(member, successFn, errorFn) {
  connection.query(
    'insert into memb(name,tel,email,pwd) values(?,?,?,password(?))',
    [ member.name, member.tel, member.email, member.password],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  }) //connection.query()
} //insertStudent()

function updateStudent(student, successFn, errorFn) {
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

function updateMember(member, successFn, errorFn) {
  connection.query(
    'update memb set name=?, tel=?, email=? where mno=?',
    [member.name, member.tel, member.email, member.no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  })
} // updateMember()

function deleteMember(no, successFn, errorFn) {
  connection.query(
    'delete from memb where mno=?',
    [no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  }) //connection.query()
}//deleteMember()

function deleteStudent(no, successFn, errorFn) {
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
