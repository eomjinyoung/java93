/* 주제: 윈도우 생성하기
 * 애플리케이션에서 'ready' 이벤트가 발생했을 때,
   즉 'ready' 상태일 때 보통 브라우저 윈도우를 생성한다.
 */

// 'electron' 모듈의 리턴 값 중에서
// 웹브라우저 창을 생성시킬 도구도 꺼낸다.
const {app, BrowserWindow} = require('electron')

// 윈도우 객체(의 주소)를 저장할 변수
let win

app.on('ready', createWindow)

// 윈도우를 생성하고 출력하는 일을 함수
function createWindow() {
  // 너비 800, 높이 600 픽셀인 웹브라우저 윈도우를 만든다.
  win = new BrowserWindow({width: 800, height: 600})
}
