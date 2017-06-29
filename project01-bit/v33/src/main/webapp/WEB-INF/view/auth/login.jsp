<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>로그인</title>
  <jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>회원 로그인</h1>
<form action='login.do' method='POST'>
<p>
<input type="radio" name="userType" value="student" checked> 학생
<input type="radio" name="userType" value="teacher"> 강사
<input type="radio" name="userType" value="manager"> 관리자
</p>
<p>이메일: <input type='text' name='email' value='${cookie.email.value}'></p>
<p>암호: <input type='password' name='password'></p>
<input type='checkbox' name='saveEmail'> 이메일 저장
<p><button>로그인</button></p>
</form>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
