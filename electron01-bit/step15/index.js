"use strict"
const net = require('net')
window.$ = window.jQuery = require('jquery')

$('#send').click(() => {
  var host = $('#host').val(),
      port = parseInt($('#port').val()),
      message = $('#message').val();
  
  var socket = new net.Socket()
  socket.setTimeout(500)
  
  socket.connect(port, host, () => {
    socket.write(message + '\n')
  })
  
  socket.on('data', (data) => {
    $('#response').val(data.toString())
    socket.destroy()
  })
  
  socket.on('error', (error) => {
    alert(error.message)
  })
  
  socket.on('timeout', () => {
    alert('서버가 응답하지 않습니다.')
    socket.destroy()
  })
})



