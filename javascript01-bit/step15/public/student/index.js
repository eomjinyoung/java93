"use strict"

var tbody = $('#student-tbl > tbody')
var prevBtn = $('#prev-btn')
var nextBtn = $('#next-btn')
var currPageNo = parseInt($('#page-no').text())

if (currPageNo == 1) {
  prevBtn.prop('disabled', true)
}

$('#add-btn').click(function() {
  location.href = 'view.html'
})

$('#prev-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())
  (currPageNo - 1)
})

$('#next-btn').click(function() {
  location.href = 'list.do?pageNo=' + (currPageNo + 1)
})

$('.my-name-link').click(function(event) {
  location.href = 'view.do?no=' + $(this).attr('data-no')
  event.preventDefault()
})
