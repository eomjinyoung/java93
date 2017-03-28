/* 주제: 생성된 윈도우에 HTML 파일을 로딩하기
- 웹브라우저 윈도우를 생성한 후 지정된 HTML 파일을 로딩한다.
 */
const {app, BrowserWindow} = require('electron')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  //win.loadURL('http://www.naver.com')
  win.loadURL('file:///Users/eomjinyoung/git/java93/electron01-bit/step03/index.html')
}
