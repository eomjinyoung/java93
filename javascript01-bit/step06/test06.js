/* 주제: 모듈 만들기
- 함수들이나 객체를 별도의 파일로 분리하여 관리하기
- 즉 몇 백개, 몇 천개, 몇 만개의 함수나 객체를 한 개의 파일에서 관리할 수 없다.
- 함수나 객체들을 역할이나 기능에 따라 적절히 분류하여
  여러 개의 파일에 분산해 두는 것이 유지보수에 좋다.
  이렇게 분리된 함수나 객체들의 묶음을 "모듈(module)"이라 부른다.
1) 모듈 정의

2) 모듈 사용 
*/
"use strict"

var count = 0;

{
  let timer = setInterval(function() { // 비동기 방식 호출. 1초 후에 호출될 함수를 등록 후 바로 리턴한다.
    console.log('1초 지났음!')
    if (++count == 10)
      clearInterval(timer) // 지정한 타이머를 멈춘다.
  }, 1000)
}

var timer = 'ok' // let 변수는 덮어 쓸 수 없다. 즉 중복해서 선언할 수 없다.
//timer = 'ok'
console.log(timer)





//
