/* Express 프레임워크 적용
*/
var express = require('express')
var bodyParser = require('body-parser')
var path = require('path')

// 통합 템플릿 엔진 관리자 모듈 로딩
var cons = require('consolidate');

// 사용할 템플릿 엔진 모듈 로딩
var handlebars = require('handlebars')

var app = express()
app.use(express.static('public'))
app.use(bodyParser.urlencoded({extended: false}))

app.engine('html', cons.handlebars) // 템플릿 엔진을 등록하기
app.set('view engine', 'html') // 등록된 템플릿 엔진 중에서 Express에서 사용할 엔진 지정
app.set('views', path.join(__dirname, '/templates')) // 템플릿 파일이 있는 경로 지정

app.get('/test.do', function(request, response) {
  response.render('test', {name: '홍길동'})
})

app.get('/test2.do', function(request, response) {
  response.render('test2', {names: ['홍길동','임꺽정','유관순']})
})

app.get('/test3.do', function(request, response) {
  response.render('d/test3', {names: ['홍길동2','임꺽정2','유관순2']})
})

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
