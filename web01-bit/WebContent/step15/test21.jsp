<%-- JSP 구성 요소 : JSTL - c:choose
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:choose
   => 여러 조건을 비교하여 실행할 때 사용. 
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
<h1>JSTL - c:choose 태그 사용법</h1>
<c:set var="level" value="관리자2"/>

<c:choose>
  <c:when test="${level == '손님'}">손님입니다.</c:when>
  <c:when test="${level == '일반회원'}">일반회원입니다.</c:when>
  <c:when test="${level == '관리자'}">관리자입니다.</c:when>
  <c:otherwise>등급이 없습니다.</c:otherwise>
</c:choose>

</body>
</html>




