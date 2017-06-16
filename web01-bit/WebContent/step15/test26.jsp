<%-- JSP 구성 요소 : JSTL - c:import
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:import
   => 지정된 URL로 요청을 하고, 그 결과를 출력하거나 저장한다. 
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
<h1>JSTL - c:import 태그 사용법</h1>
<c:url var="url2" value="http://localhost:8080/project01-bit/teacher/list">
  <c:param name="pageNo" value="2"/>
  <c:param name="pageSize" value="3"/>
</c:url>

<%-- var 속성을 이용하여 변수를 지정하지 않으면 c:import 태그의 자리에 그대로 출력된다. --%>
<textarea cols="80" rows="10"><c:import url="${pageScope.url2}"/></textarea>

<%-- var 속성을 이용하여 변수명을 지정하면 응답 결과를 보관소에 저장한다. --%>
<c:import var="result" url="${pageScope.url2}"/>
<textarea cols="80" rows="10">${pageScope.result}</textarea>

</body>
</html>








