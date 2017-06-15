<%-- JSP 구성 요소 : 지시어 엘리먼트 - include
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트
   - <%@ page %> 
   - <%@ include %>
     file 속성:
       이 속성에 지정된 파일을 그대로 읽어서 JSP 파일에 이 태그가 있는 그 자리에 그대로 포함시킨다.
       그런 후 자바 서블릿 클래스를 만든다.
       참고로 <jsp:include>는 RequestDispatcher의 include()를 호출한 것과 같다.
       지정된 파일이 JSP라면 실행할 것이고, 일반 텍스트라면 그 내용을 출력할 것이다.
       
   - <%@ taglib %>
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
  <meta charset="UTF-8">
  <title>JSP</title>
</head>
<body>
<h1>지시 엘리먼트 - include</h1>
<hr>
<% String name = "홍길동"; %>
<%@ include file="a.jsp" %>
<hr> 
<%-- 
<jsp:include page="a.jsp"/>
--%>
</body>
</html>