"use strict"
window.$ = window.jQuery = require('jquery')
var teacherService = require('electron').remote.getGlobal('teacherService')


var fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiPassword = $('#fi-password'),
    fiHomepage = $('#fi-homepage'),
    fiFacebook = $('#fi-facebook'),
    fiTwitter = $('#fi-twitter');

if (location.search == "") {
  $('.bit-view').css('display', 'none')
  $('.bit-new').css('display', '')

  $('#add-btn').click(function() {
    teacherService.insert(
      {
        name: fiName.val(),
        tel: fiTel.val(),
        email: fiEmail.val(),
        password: fiPassword.val(),
        homepage: fiHomepage.val(),
        facebook: fiFacebook.val(),
        twitter: fiTwitter.val()
      },
      function() {
        location.href = 'index.html'
      },
      function(error) {
        alert('강사 등록 중 오류 발생!')
        throw error;
    }) //insertMember()
  }) // click()

} else { // 기존 사용자 정보를 가져온다.
  $('.bit-new').css('display', 'none')
  var no = location.search.substring(1).split('=')[1]

  teacherService.detail(no,
    function(result) {
      var teacher = result
      fiNo.text(teacher.mno)
      fiEmail.val(teacher.email)
      fiName.val(teacher.name)
      fiTel.val(teacher.tel)
      fiHomepage.val(teacher.hmpg)
      fiFacebook.val(teacher.fcbk)
      fiTwitter.val(teacher.twit)
    },
    function(error) {
      alert('강사 데이터 가져오는 중 오류 발생!')
      throw error
  })

  $('#upd-btn').click(function() {
    teacherService.update(
      {
        "no": no,
        "name": fiName.val(),
        "tel": fiTel.val(),
        "email": fiEmail.val(),
        "password": fiPassword.val(),
        "homepage": fiHomepage.val(),
        "facebook": fiFacebook.val(),
        "twitter": fiTwitter.val()
      },
      function(result) {
        alert('변경하였습니다.')
      },
      function(error) {
        alert('강사 기본 데이터 변경 중 오류 발생!')
        throw error;
    })//update()
  }) //click()

  $('#del-btn').click(function() {
    teacherService.delete(no,
      function(result) {
        location.href = 'index.html'
      },
      function(error) {
        alert('강사 기본 데이터 삭제 중 오류 발생!')
        throw error;
    })
  }) // click()
} // else

$('#lst-btn').click(function() {
  location.href = "index.html"
})
