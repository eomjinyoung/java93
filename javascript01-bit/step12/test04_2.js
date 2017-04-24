/* 요청 정보 다루기 - Quiz 3
=> 사용자로부터 기본 회원 데이터를 입력 받아 DBMS에 저장하라!
=> 요청 예)
  http://localhost:8888/student/add.do?name=홍길동&tel=1111&email=hong@test.com&password=1111
=> 출력 예)
  입력 성공입니다!

* 입력되었는지 여부는 test04_1.js 통해 확인하라!
*/

const http = require('http')
const url = require('url')

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end();
    return;
  }
  console.log('클라이언트 요청이 들어왔네!')

  response.writeHead(200, {
    'Content-Type' : 'text/plain;charset=UTF-8'
  })

  // URL 분석기 실행
  var urlInfo = url.parse(request.url, true)

  // URL에서 '?' 앞에 나오는 경로(http://localhost:8888 은 제외)
  if (urlInfo.pathname != '/calculator') {
    response.end('잘못된 URL 입니다.')
    return
  }

  var a = parseInt(urlInfo.query.a)
  var b = parseInt(urlInfo.query.b)
  var op = urlInfo.query.op
  /* URL은 항상 ASCII 코드 값으로 표현해야 한다.
    다른 데이터는 URL 인코딩, 즉 아스키 문자화시켜 표현한다.
    그래서 '+' 문자는 '%2B' 라는 문자로 URL 인코딩하여 전달해야 한다.
    또한 '%'도 URL 인코딩하는데 특별한 기호로 사용되기 때문에,
    '+' 문자와 마찬가지로 URL 인코딩한 '%25' 문자로 바꿔 전달해야 한다.
  */

  var result = 0
  switch(op) {
    case '+': result = a + b; break
    case '-': result = a - b; break
    case '*': result = a * b; break
    case '/': result = a / b; break
    case '%': result = a % b; break
  }

  response.write(a + ' ' + op + ' ' + b + ' = ' + result)
  response.end();
})
server.listen(8888)

console.log("서버 실행 중...")
