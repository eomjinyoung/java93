<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>강사관리</title>
  <jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>강사 목록 by JSP</h1>
<a href='form.html'>새강사</a>
<table border='1'>
<thead>
  <tr><th>번호</th><th>이름</th><th>전화</th><th>이메일</th><th>홈페이지</th></tr>
</thead>
<tbody>
<c:forEach items="${list}" var="item">
<tr>
  <td>${item.no}</td>
  <td><a href='detail.do?no=${item.no}'>${item.name}</a></td>
  <td>${item.tel}</td>
  <td>${item.email}</td>
  <td>${item.homepage}</td>
</tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
    