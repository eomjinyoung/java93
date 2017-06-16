<%-- JSP 구성 요소 : JSTL - c:if
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:if
   => 조건이 참인 경우에 지정된 코드를 실행 
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
<h1>JSTL - c:if 태그 사용법</h1>
<c:set var="name" value="유관순"/>
<c:set var="age" value="20"/>
<c:set var="working" value="true"/>
<hr>
<%-- 대소문자 구분없이 test 속성 값이 true 이면, 조건이 참인 것으로 간주한다. --%>
<c:if test="true"><p>true</p></c:if>
<c:if test="TRUE"><p>TRUE</p></c:if>
<c:if test="True"><p>True</p></c:if>
<c:if test="trUe"><p>trUe</p></c:if>

<%-- 그외의 모든 문자열은 거짓으로 간주한다. --%>
<c:if test="false"><p>false</p></c:if>
<c:if test="aaaa"><p>aaaa</p></c:if>

<%-- 값을 비교할 경우 그냥 일반 문자열로 표현하면 위의 규칙에 따라 거짓으로 간주된다. --%>
<c:if test="name=='유관순'">유관순1111</c:if>

<%-- 보관소에 저장된 값이나 변수의 값을 비교할 때는 EL 문법을 사용해야 한다. --%>
<c:if test="${name=='유관순'}">유관순2222<br></c:if>
<c:if test="${age==20}">20살<br></c:if>
<c:if test="${working==true}">재직중<br></c:if>
<c:if test="${working}">재직중2<br></c:if>

<%-- if 조건의 결과를 보관소에 저장할 수 있다.  --%>
<c:if test="${working}" var="result" scope="page">재직중3<br></c:if>
####${pageScope.result}####<br>

</body>
</html>




