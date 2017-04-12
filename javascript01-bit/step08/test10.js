function bit(value) {
  var el = []

  if (value.startsWith('<')) { // 새 태그 생성으로 간주한다.
    el[0] = document.createElement(value.substr(1, value.length - 2))

  } else { // CSS selector 문법으로 간주한다.
    var list = document.querySelectorAll(value)
    for (var e of list) {
      el.push(e)
    }
  }

  // 배열에 나만의 유용한 함수를 붙이자!

  // 1) 배열에 들어있는 태그에 대해 자식 태그를 추가하는 아주 편리한 함수
  el.append = function(tag) {
    for (var e of el) {
      e.appendChild(tag)
    }
  }


  return el
}

var $ = bit;
