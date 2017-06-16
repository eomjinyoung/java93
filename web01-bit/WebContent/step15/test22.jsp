<%-- JSP 구성 요소 : JSTL - c:forEach
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:forEach
   => 조건이 참인 동안 반복한다. 
8) EL(Expression Language)
9) JSP 주석
 --%>
<%@page import="java.util.ArrayList"%>
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
<h1>JSTL - c:forEach 태그 사용법</h1>
<%
pageContext.setAttribute("names", new String[]{"홍길동","임꺽정","유관순"});

ArrayList<String> names2 = new ArrayList<>();
names2.add("홍길동2");
names2.add("임꺽정2");
names2.add("유관순2");
pageContext.setAttribute("names2", names2);

pageContext.setAttribute("names3", "홍길동3,임꺽정3,유관순3");
%>

<%--
items: 배열, java.util.Collection 구현체, java.util.Iterator 구현체, 
       java.util.Enumeration 구현체, java.util.Map 구현체, 
       콤마(,)로 구분된 문자열
var: 목록에 꺼낸 값을 가리키는 변수
 --%>
<c:forEach var="name" items="${pageScope.names}">
${name}<br>
</c:forEach>
<hr>
<c:forEach var="name" items="${pageScope.names2}">
${name}<br>
</c:forEach>
<hr>
<c:forEach var="name" items="${pageScope.names3}">
${name}<br>
</c:forEach>
<hr>
<c:forEach var="name" items="홍길동4,임꺽정4,유관순4">
${name}<br>
</c:forEach>

</body>
</html>


