"use strict"

window.$ = window.jQuery = require('jquery')

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
    insertMember(
      {
        name: fiName.val(),
        tel: fiTel.val(),
        email: fiEmail.val(),
        password: '1111'
      },
      function(result) {
        insertStudent(
          {
            memberNo: result.insertId,
            working: (fiWorking.prop('checked') ? 'Y' : 'N'),
            schoolName: fiSchoolName.val()
          },
          function(result) {
            location.href = 'index.html'
          },
          function(error) {
            alert('학생 데이터 등록 중 오류 발생!')
            throw error;
        })
      },
      function(error) {
        alert('회원 기본 데이터 등록 중 오류 발생!')
        throw error;
    }) //insertMember()
  }) // click()

} else { // 기존 사용자 정보를 가져온다.
  $('.bit-new').css('display', 'none')
  var no = location.search.substring(1).split('=')[1]

  selectOneStudent(no,
    function(result) {
      var student = result
      fiNo.text(student.mno)
      fiEmail.val(student.email)
      fiName.val(student.name)
      fiTel.val(student.tel)
      fiSchoolName.val(student.schl_nm)
      fiWorking.attr('checked', (student.work == 'Y' ? true : false))
    },
    function(error) {
      alert('학생 데이터 가져오는 중 오류 발생!')
      throw error
  })

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
