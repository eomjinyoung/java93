<%-- JSP 구성 요소 : JSP 액션 태그 - jsp:forward
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
   => JSP에서 기본으로 제공하는 태그이다.
   => 이 태그를 사용하기 위해 따로 라이브러리를 가져오는 taglib 를 선언할 필요가 없다.
   jsp:forward
   => 다른 서블릿/JSP로 실행을 위임할 때 사용하는 태그이다.
   => forward는 RequestDispatcher.forward()와 같다.
   page 속성: 
     forward 할 서블릿 또는 JSP URL
7) JSP 확장 태그(JSTL)
8) EL(Expression Language)
9) JSP 주석
 --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSP</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:forward</h1>
<jsp:forward page="test11.jsp"/>
</body>
</html>






