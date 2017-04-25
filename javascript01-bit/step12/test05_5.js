/* Quiz - test04_1.js 에 템플릿 엔진을 적용하라!
=> 템플릿 파일: test05_5.html
*/

const fs = require('fs')
const path = require('path')
const handlebars = require('handlebars')

var data = {
  name: '홍길동'
}

var templatePath = path.join(__dirname, 'test05_3_template.txt')
fs.readFile(templatePath, 'utf8', (err, src) => {
  if(err) throw error

  var template = handlebars.compile(src)
  var result = template(data)
  console.log(result)
})
