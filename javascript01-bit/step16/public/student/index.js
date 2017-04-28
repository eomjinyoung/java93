// 서버에서 학생 목록 데이터를 받아 온다.
$.getJSON('list.json', {'pageNo':1, 'pageSize': 4}, function(result) {
  console.log(result)
})
