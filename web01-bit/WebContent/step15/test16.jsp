<%-- JSP 구성 요소 : JSTL - c:out
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:out
   => 출력문을 만드는 태그
8) EL(Expression Language)
9) JSP 주석
 --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL</title>
</head>
<body>
<h1>JSTL - c:out 태그 사용법</h1>
<c:out value="출력할 문자열"/><br>
<% // PageContext 보관소에 값을 저장한 후 그 값을 출력해 보자!
pageContext.setAttribute("name", "홍길동");
%>
,<c:out value="${name}"/>,<br>
,<c:out value="${name2}"/>,<br>
,<c:out value="${name}" default="오호라"/>,<br>
,<c:out value="${name2}" default="오호라"/>,<br>
,<c:out value="${name2}">오호라</c:out>,<br>
</body>
</html>






