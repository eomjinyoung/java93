<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>오류</title>
  <jsp:include page="/corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<h1>실행 오류!</h1>
<pre>
<%
Exception error = (Exception)request.getAttribute("error");
if (error != null) {
  error.printStackTrace(new PrintWriter(out));
}
%>
</pre>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
    