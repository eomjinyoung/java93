/* 주제: 흐름 제어문 - 연습
- 구구단을 출력하는 프로그램을 작성하시오.
- 예)
> node test17.js
prompt: step: 5
5 * 1 = 5
5 * 2 = 10
...
5 * 9 = 45
*/
"use strict"

var prompt = require('prompt');

prompt.start();

prompt.get(['a', 'b'], function(err, result) {
  var a = parseInt(result.a); // string --> number
  var b = parseInt(result.b); // string --> number

  console.log('계산결과:');
  console.log('a + b =', a + b);
  console.log('a - b =', a - b);
  console.log('a * b =', a * b);
  console.log('a / b =', a / b);
  console.log('a % b =', a % b);
});









//
