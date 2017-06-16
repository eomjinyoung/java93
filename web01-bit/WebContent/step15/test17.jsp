<%-- JSP 구성 요소 : JSTL - c:set
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:set
   => 값을 보관소에 저장할 때 사용한다.
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
<h1>JSTL - c:set 태그 사용법</h1>
<c:set var="name" value="임꺽정1"/> <%-- PageContext 보관소--%>
<c:set var="name" value="임꺽정2" scope="page"/> <%-- PageContext 보관소--%>
<c:set var="name" value="임꺽정3" scope="request"/> <%-- ServletRequest 보관소 --%>
<c:set var="name" value="임꺽정4" scope="session"/> <%-- HttpSession 보관소 --%>
<c:set var="name" value="임꺽정5" scope="application"/> <%-- ServletContext 보관소 --%>
기본: <c:out value="${pageScope.name}"/><br>
PageContext:    <c:out value="${pageScope.name}"/><br>
ServletRequest: <c:out value="${requestScope.name}"/><br>
HttpSession:    <c:out value="${sessionScope.name}"/><br>
ServletContext: <c:out value="${applicationScope.name}"/><br>

<%-- 값을 설정할 때 value 속성 대신 콘텐트에 지정할 수 있다. --%>
<c:set var="name2">유관순</c:set> 
${pageScope.name2}<br>
</body>
</html>






