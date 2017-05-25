"use strict"
const net = require('net')
window.$ = window.jQuery = require('jquery')
var host = $('#host'),
    port = $('#port'),
    connectBtn = $('#connectBtn'),
    closeBtn = $('#closeBtn'),
    v1 = $('#v1'),
    v2 = $('#v2'),
    op = $('#op'),
    result = $('#result');

closeBtn.css('display', 'none') // 화면이 뜨면 "끊기" 버튼을 감춘다.

var socket = new net.Socket()

socket.on('connect', () => {
  connectBtn.css('display', 'none') // "연결" 버튼을 감춘다
  closeBtn.css('display', '') // "끊기" 버튼을 보인다.
})

socket.on('data', (data) => {
  //result.val(data.toString())
  console.log('=>' + data.toString())
})
  
socket.on('error', (error) => {
  alert(error.message)
})
  
socket.on('timeout', () => {
  alert('서버가 응답하지 않습니다.')
  socket.destroy()
})

socket.on('close', () => {
  alert('끊었습니다.')
  //connectBtn.css('display', '')
  //closeBtn.css('display', 'none')
})
  
connectBtn.click(() => {
  socket.connect(parseInt(port.val()), host.val())
  //socket.setTimeout(500) // 500밀리초 후에 연결 여부를 검사해서 연결되지 않았으면, timeout 이벤트 발생!
})

closeBtn.click(() => {
  socket.destroy()
  socket.end()
  connectBtn.css('display', '')
  closeBtn.css('display', 'none')
})


$('#send').click(() => {
  var obj = {
    'v1': parseInt(v1.val()),
    'v2': parseInt(v2.val()),
    'op': op.val()
  }
  socket.write(JSON.stringify(obj) + '\n')
  
})














