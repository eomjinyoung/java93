/* 주제: MySQL DBMS에 직접 접속하기 VII
=> UI 자바스크립트 파일에서 비즈니스 로직을 분리하여 xxx-service.js 파일에 담는다. 
 */
const {app, BrowserWindow} = require('electron')
const path = require('path')
const url = require('url')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, 'index.html'),
    slashes: true
  }))
  //win.webContents.openDevTools() // 웹브라우저의 개발도구창을 띄운다.

}




//
