/* 주제: HTML 파일의 URL 경로를 쉽게 만들기
 */
const {app, BrowserWindow} = require('electron')

// 'path' 모듈은 현재 실행 중인 프로그램 경로를 기준으로
// 파일 경로를 다룰 때 사용할 도구를 리턴한다.
const path = require('path')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL(path.join('file://', __dirname, '/index.html'))
}

console.log(path.join('file://', __dirname, '/index.html'))

// index.html 경로를 path 객체의 join() 기능을 이용하여 처리했다.
// 문제점 : URL의 표기 형식을 준수하고 있지 않다.

// URL의 표기 형식
// => 프로토콜 명 다음에 '://'가 와야 한다.
// => URL은 항상 슬래시(/)로 표현해야 한다.

/* URI(Uniform Resource Identifier)
- 인터넷의 자원(파일 또는 컴퓨터) 위치를 표현하는 공통 표기법
1) URN (Uniform Resource Name)
   예) urn:isbn:0451450523
   예) urn:isan:0000-0000-9E59-0000-O-0000-0000-2
2) URL (Uniform Resource Locator)
   => scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]
   => scheme(= protocol)의 예: http, file, ftp, https 등
   예) http://example.com/%E5%BC%95%E3%81%8D%E5%89%B2%E3%82%8A.html
   예) ttp://www.example.com/index.html

*/


//
