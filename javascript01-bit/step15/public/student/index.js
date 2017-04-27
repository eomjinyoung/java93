"use strict"

var tbody = $('#student-tbl > tbody')

$('#add-btn').click(function() {
  location.href = 'view.html'
})

$('#prev-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())
  displayList(currPageNo - 1)
})

$('#next-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())
  displayList(currPageNo + 1)
})

$('.my-name-link').click(function(event) {
  location.href = 'view.do?no=' + $(this).attr('data-no')
  event.preventDefault()
})
