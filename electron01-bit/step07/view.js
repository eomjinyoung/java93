"use strict"

window.$ = window.jQuery = require('jquery')

const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
connection.connect()

var fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiSchoolName = $('#fi-school-name'),
    fiWorking = $('#fi-working');

if (location.search == "") {
  $('.bit-view').css('display', 'none')
  $('.bit-new').css('display', '')

  $('#add-btn').click(function() {
    connection.query(
      'insert into memb(name,tel,email,pwd) values(?,?,?,password(?))',
      [
        fiName.val(),
        fiTel.val(),
        fiEmail.val(),
        '1111'
      ],
      function(error, result) {
        if (error) {
          alert('회원 기본 데이터 등록 중 오류 발생!')
          throw error;
        }

        connection.query(
          'insert into stud(sno,work,schl_nm) values(?,?,?)',
          [
            result.insertId,
            (fiWorking.prop('checked') ? 'Y' : 'N'),
            fiSchoolName.val()
          ],
          function(error, result) {
            if (error) {
              alert('학생 데이터 등록 중 오류 발생!')
              throw error;
            }
            location.href = 'index.html'
        }) //connection.query()
    }) //connection.query()
  }) // click()

} else { // 기존 사용자 정보를 가져온다.
  $('.bit-new').css('display', 'none')
  var no = location.search.substring(1).split('=')[1]

  connection.query(
    'select m.mno, m.name, m.tel, m.email, s.work, s.schl_nm \
    from stud s inner join memb m on s.sno=m.mno \
    where s.sno=?',
    [no],
    function(error, results) {
      var student = results[0]
      fiNo.text(student.mno)
      fiEmail.val(student.email)
      fiName.val(student.name)
      fiTel.val(student.tel)
      fiSchoolName.val(student.schl_nm)
      fiWorking.attr('checked', (student.work == 'Y' ? true : false))
  }) // connection.query()

  $('#upd-btn').click(function() {
    connection.query(
      'update memb set name=?, tel=?, email=? where mno=?',
      [
        fiName.val(),
        fiTel.val(),
        fiEmail.val(),
        no
      ],
      function(error, result) {
        if (error) {
          alert('회원 기본 데이터 변경 중 오류 발생!')
          throw error;
        }

        connection.query(
          'update stud set work=?, schl_nm=? where sno=?',
          [
            (fiWorking.prop('checked') ? 'Y' : 'N'),
            fiSchoolName.val(),
            no
          ],
          function(error, result) {
            if (error) {
              alert('학생 데이터 변경 중 오류 발생!')
              throw error;
            }
            alert('변경하였습니다.')
        }) //connection.query()
    }) //connection.query()
  }) // click()

  $('#del-btn').click(function() {
    connection.query(
      'delete from stud where sno=?',
      [no],
      function(error, result) {
        if (error) {
          alert('학생 데이터 삭제 중 오류 발생!')
          throw error;
        }

        connection.query(
          'delete from memb where mno=?',
          [no],
          function(error, result) {
            if (error) {
              alert('기본 회원 데이터 삭제 중 오류 발생!')
              throw error;
            }
            location.href = 'index.html'
        }) //connection.query()
    }) //connection.query()
  }) // click()
} // else

$('#lst-btn').click(function() {
  location.href = "index.html"
})
