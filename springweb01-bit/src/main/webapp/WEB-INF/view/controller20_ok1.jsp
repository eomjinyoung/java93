<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test</title>
</head>
<body>
<h1>HttpSession에 보관된 member 객체 꺼내기</h1>
이름: ${member.name}<br>
나이: ${member.age}<br>
재직중: ${member.working}<br>

<h1>HttpSession에 보관된 member2 객체 꺼내기</h1>
이름: ${member2.name}<br>
나이: ${member2.age}<br>
재직중: ${member2.working}<br>
</body>
</html>