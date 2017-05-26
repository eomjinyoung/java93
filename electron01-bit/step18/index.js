"use strict"
const net = require('net')
window.$ = window.jQuery = require('jquery')
var host = $('#host'),
    port = $('#port'),
    alias = $('#alias'),
    message = $('#message'),
    messageBox = $('#messageBox');

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
  
  messageBox.val(messageBox.val() + value + '\n')
})
  
socket.on('error', (error) => {
  alert(error.message)
})
 
$('#connectBtn').click(() => {
  socket.connect(parseInt(port.val()), host.val(), () => {
    socket.write(alias.val() + '\n')
  })
})
  
$('#sendBtn').click(() => {
  socket.write(JSON.stringify(obj) + '\n')
  socket.end()
})














