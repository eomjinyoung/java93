<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test</title>
</head>
<body>
<h1>페이지 - 3</h1>
<form action="ok4.do" method="post">
이름: ${member2.name}<br>
나이: ${member2.age}<br>
직장: <input type="radio" name="working" value="true">재직중
      <input type="radio" name="working" value="false" checked>실업자<br>
<button>다음</button>
</form>
</body>
</html>