//이 클라이언트는 java01 프로젝트의 step18.Test08_2 서버와 연결한다.
"use strict"
const net = require('net')
window.$ = window.jQuery = require('jquery')
var host = $('#host'),
    port = $('#port'),
    alias = $('#alias'),
    message = $('#message'),
    messageBox = $('#messageBox'),
    sendBtn = $('#sendBtn');

var myAlias = null

var socket = new net.Socket()

var buffer = ''
	
socket.on('data', (data) => {
  buffer += data.toString()
  
  var value = null
  while (true) {
    var newLineIndex = buffer.indexOf('\n') 
    if ( newLineIndex < 0) 
      return; 
    
    value = buffer.substring(0, newLineIndex)
    buffer = buffer.substring(newLineIndex + 1)
    
    if (value.length > 0) 
	  break;
  }
  
  $('<li>').addClass(value.startsWith(myAlias) ? "me" : "him")
           .html(value)
           .appendTo(messageBox)
  messageBox.scrollTop(messageBox.prop('scrollHeight'));
})
  
socket.on('error', (error) => {
  alert(error.message)
})
 
$('#connectBtn').click(() => {
  socket.connect(parseInt(port.val()), host.val(), () => {
    socket.write(alias.val() + '\n')
    myAlias = '[' + alias.val() // 클라이언트 별명을 보관
  })
})
  
sendBtn.click(() => {
  socket.write(message.val() + '\n')
  message.val('')
})

message.keyup((e) => {
  if (e.keyCode  == 0x0d) {
	var text = message.val().replace('\r','').replace('\n','');
	message.val(text)
    sendBtn.click() // sendBtn 버튼에 'click' 이벤트를 발생시킨다.
  }
})













