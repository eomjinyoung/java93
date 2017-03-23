/* 주제: 객체 - 값 초기화시키기
- 문법
  var 변수명 = {프로퍼티명: 값, 프로퍼티명: 값, 프로퍼티명: 값, ...}
*/
"use strict"

// 배열 초기화
var names = ["홍길동", "임꺽정", "유관순"]
names[5] = "윤봉길"
console.log(names);
console.log('---------------------')

// 객체 초기화
var obj = {"name": "홍길동", "name2": "임꺽정", "name3": "유관순"}
obj.name4 = "안중근"
console.log(obj)

console.log(typeof names)
console.log(typeof obj)






//
