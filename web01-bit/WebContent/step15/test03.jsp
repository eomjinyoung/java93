<%-- JSP 구성 요소 : 스크립트릿 엘리먼트
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
   - JSP에 자바 코드를 삽입할 때 사용한다.
     <% 자바 코드 %>
   - JSP 엔진이 생성하는 서블릿 파일에 그대로 복사된다.
   - _jspService() 메서드 안에 순서대로 그대로 복사된다.
3) 지시어(directive) 엘리먼트
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
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
<%
int i = 20;
int j = 30;
%>
  <meta charset="UTF-8">
  <title>JSP</title>
</head>
<body>
<!-- HTML 주석도 템플릿 데이터이다. -->
<h1>스크립트릿 엘리먼트</h1>
<%
out.write("=>" + i * j); 
%>
</body>
</html>