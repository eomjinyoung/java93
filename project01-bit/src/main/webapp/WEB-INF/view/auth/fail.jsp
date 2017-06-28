<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <meta http-equiv="Refresh" content="2;url=login.do">
  <title>로그인</title>
  <jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>로그인 오류!</h1>
<p>이메일 또는 암호가 맞지 않습니다.</p>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
