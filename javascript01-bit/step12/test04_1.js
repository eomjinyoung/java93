/* 요청 정보 다루기 - Quiz 2
=> 사용자로부터 페이지 번호와 개수를 입력 받아
  학생 목록을 HTML 페이지로 출력하시오.
=> 요청 예)
  http://localhost:8888/student/list.do?pageNo=2&pageSize=3
=> 출력 예)
  간단히 테이블로 출력하라!
*/

const http = require('http')
const url = require('url')
const datasource = require('./datasource')
const studentDao = require('./student-dao')

const connection = datasource.getConnection()
studentDao.setConnection(connection)

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end();
    return;
  }

  var urlInfo = url.parse(request.url, true)

  if (urlInfo.pathname != '/student/list.do') {
    response.writeHead(404, {
      'Content-Type' : 'text/plain;charset=UTF-8'
    })
    response.end('잘못된 URL 입니다.')
    return
  }

  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })

  response.write('<html> \
    <head> \
      <title>학생목록</title> \
    </head> \
    <body>')
  response.write('<h1>학생 목록</h1>')
  response.write('pageNo=' + urlInfo.query.pageNo + '<br>')
  response.write('pageSize=' + urlInfo.query.pageSize + '<br>')

  studentDao.selectList(1, function(results) {
    for (var r of results) {
      response.write(r.mno + ',' + r.email + ',' + r.tel + ',' + r.work + '<br>')
    }
    response.write('</body></html>')
    response.end();
    
  }, function(error) {
    response.write('DB 오류!')
    response.write('</body></html>')
    response.end();
  })

})

server.listen(8888)

console.log("서버 실행 중...")
