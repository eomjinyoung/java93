/* 주제: HTML 파일의 URL 경로를 쉽게 만들기
 */
const {app, BrowserWindow} = require('electron')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL('file://' + __dirname + '/index.html')
}

// index.html 파일의 경로를 '+' 연산자를 사용하여 문자열을 연결하는 방식으로 지정했다.
