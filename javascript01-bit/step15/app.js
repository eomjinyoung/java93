/* Express 프레임워크 적용
*/
var express = require('express')
var bodyParser = require('body-parser')
var path = require('path')
var cons = require('consolidate');

var app = express()
app.use(express.static('public'))
app.use(bodyParser.urlencoded({extended: false}))

app.engine('html', cons.handlebars)
app.set('view engine', 'html')
app.set('views', path.join(__dirname, '/views'))

// 서비스 라우터를 등록한다.
app.use('/student', require('./control/student-control'))

app.get('/', function(request, response) {
  response.render('index')
})

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
