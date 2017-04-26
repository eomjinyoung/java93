/* Express 프레임워크 사용
*/
var express = require('express')
var bodyParser = require('body-parser')

var app = express()

app.use(express.static('public'))
app.use(bodyParser.urlencoded({extended: false}))

app.get('/', function(request, response) {
  response.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'})
  response.end('<html>\
  <head>\
    <title>main</title>\
  </head>\
  <body>\
    <h1>환영합니다!</h1>\
  </body>\
  </html>')
})

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
