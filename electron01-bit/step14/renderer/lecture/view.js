"use strict"
window.$ = window.jQuery = require('jquery')
var managerService = require('electron').remote.getGlobal('managerService')
var classroomService = require('electron').remote.getGlobal('classroomService')
var lectureService = require('electron').remote.getGlobal('lectureService')

managerService.listName(function(results) {
    var fiManager = $('#fi-manager')
    for (var r of results) {
      $('<option>').val(r.mrno).text(r.name).appendTo(fiManager)
    }
  }, function(error) {
    alert('매니저 이름 로딩 중 오류 발생!')
    throw error;
})

classroomService.listName(function(results) {
    var fiClassroom = $('#fi-classroom')
    for (var r of results) {
      $('<option>').val(r.crmno).text(r.name).appendTo(fiClassroom)
    }
  }, function(error) {
    alert('강의실 이름 로딩 중 오류 발생!')
    throw error;
})

var fiNo = $('#fi-no'),
    fiTitle = $('#fi-title'),
    fiContent = $('#fi-content'),
    fiStartDate = $('#fi-start-date'),
    fiEndDate = $('#fi-end-date'),
    fiQuantity = $('#fi-quantity'),
    fiHours = $('#fi-hours'),
    fiPrice = $('#fi-price'),
    fiClassroom = $('#fi-classroom'),
    fiManager = $('#fi-manager');

if (location.search == "") {
  $('.bit-view').css('display', 'none')
  $('.bit-new').css('display', '')

  $('#add-btn').click(function() {
    lectureService.insert(
      {
        title: fiTitle.val(),
        content: fiContent.val(),
        startDate: fiStartDate.val(),
        endDate: fiEndDate.val(),
        quantity: fiQuantity.val(),
        hours: fiHours.val(),
        price: fiPrice.val(),
        classroom: fiClassroom.val(),
        manager: fiManager.val()
      },
      function() {
        location.href = 'index.html'
      },
      function(error) {
        alert('강의 등록 중 오류 발생!')
        throw error;
    }) //insert()
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
