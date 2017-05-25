"use strict"
const net = require('net')
window.$ = window.jQuery = require('jquery')
var host = $('#host'),
    port = $('#port'),
    v1 = $('#v1'),
    v2 = $('#v2'),
    op = $('#op'),
    result = $('#result');

var socket = new net.Socket()

var buffer = ''
	
socket.on('data', (data) => {
  buffer += data.toString()
  
  // 줄바꿈 코드를 찾아서 값을 추출한다.
  var value = null
  while (true) {
    var newLineIndex = buffer.indexOf('\n') 
    if ( newLineIndex < 0) // 줄바꿈 코드가 없다면,
      return; // 아직 데이터를 다 받지 못했다는 의미이다. 다음 데이터를 받을 때 계속한다.
    
    // 줄바꿈 코드 앞에 문자열과 줄바꿈 코드 뒤의 문자열을 분리한다.
    // => 줄바꿈 코드 앞의 문자열을 값으로 추출한다.
    value = buffer.substring(0, newLineIndex)
    // => 줄바꿈 코드 뒤의 문자열은 다시 버퍼에 담는다.
    buffer = buffer.substring(newLineIndex + 1)
    
    if (value.length > 0) // 값이 있으면 반복문을 멈춰서 처리한다. 
	  break;
  }
  
  result.val(value)
})
  
socket.on('error', (error) => {
  alert(error.message)
})
  
  
$('#send').click(() => {
  var obj = {
    'v1': parseInt(v1.val()),
    'v2': parseInt(v2.val()),
    'op': op.val()
  }
  socket.connect(parseInt(port.val()), host.val())
  socket.write(JSON.stringify(obj) + '\n')
  socket.end()
})














