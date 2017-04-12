function bit(value) {
  var el = []

  if (value instanceof HTMLElement) { // 파라미터 값이 태그라면,
    el[0] = value // 무조건 태그를 배열로 포장한다.

  } else if (value.startsWith('<')) { // 새 태그 생성으로 간주한다.
    el[0] = document.createElement(value.substr(1, value.length - 2))

  } else { // CSS selector 문법으로 간주한다.
    var list = document.querySelectorAll(value)
    for (var e of list) {
      el.push(e)
    }
  }

  // 배열에 나만의 유용한 함수를 붙이자!

  // 1) 배열에 들어있는 태그에 대해 자식 태그를 추가하는 아주 편리한 함수
  el.append = function(children) {
    if (!(children instanceof Array)) {
      console.error('배열이 아닙니다.');
      return;
    }

    for (var e of this) {
      for (var child of children) {
        e.appendChild(child)
      }
    }

    return this
  }

  // 2) 배열 안에 있는 태그의 콘텐츠를 설정하는 함수
  el.html = function(content) {
    for (var e of this) {
      e.innerHTML = content
    }

    return this
  }

  // 3) 배열 안에 있는 태그에 클릭 이벤트 핸들러를 추가하는 함수
  el.click = function(listener) {
    for (var e of this) {
      e.addEventListener('click', listener)
    }
    return this
  }

  // 4) 배열 안에 있는 태그의 속성 값을 다루는 함수
  el.attr = function(name) {
    // 값을 꺼낼 때는 배열에서 0번 방에 들어 있는 태그의 속성 값만 꺼내자!
    return this[0].getAttribute(name)
  }

  // 5) 배열 안에 있는 태그를 부모 태그에 추가시키는 함수
  el.appendTo = function(parents) {
    for (var p of parents) {
      for (var e of this) {
        p.appendChild(e)
      }
    }
    return this;
  }


  return el
}

// bit() 함수가 리턴한 배열에 대해 작업하지 않고,
// 독자적으로 작업하는 함수는 bit() 객체에 직접 보관한다.

bit.ajax = function(url, settings) {
  if (settings == undefined) {
    settings = {
      method: 'GET',
      dataType: 'text'
    }
  } else {
    if (settings.method == undefined) settings.method = 'GET'
    if (settings.dataType == undefined) settings.dataType = 'text'
  }

  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState < 4)
      return

    var rv;
    if (settings.dataType == 'json') {
      rv = JSON.parse(xhr.responseText)
    } else {
      rv = xhr.responseText
    }

    if (settings.success) { // settings.success != undefined
      settings.success(rv) // settings 객체의 success 변수에 들어있는 함수를 호출한다.
    }
  }
  xhr.open(settings.method, url, true)
  xhr.send()
}










var $ = bit;
