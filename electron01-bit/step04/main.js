/* 주제: HTML 파일의 URL 경로를 쉽게 만들기
 */
const {app, BrowserWindow} = require('electron')
const path = require('path')

// URL 경로를 보다 쉽게 다루기 위한 모듈이다.
const url = require('url')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  // HTML 경로를 제대된 URL로 바꾸기 위해 'url' 모듈을 사용한다.
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, 'index.html'),
    slashes: true
  }))
}




//
