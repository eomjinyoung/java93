<%-- JSP 구성 요소 : EL - 산술 연산자
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
8) EL(Expression Language)
   => 보관소에서 값을 꺼낼 때 사용하는 문법
   => OGNL(Object Graph Navigation Language) 형식을 값이 들어있는 객체의 경로를 지정한다.
      예) pageScope.member.name
   => EL에서 사용할 수 있는 기본 객체
      pageContext : PageContext 객체
      servletContext : ServletContext 객체. ex) ${pageContext.servletContext.프로퍼티명}
      session: HttpSession 객체. ex) ${pageContext.session.프로퍼티명}
      request: ServletRequest 객체. ex) ${pageContext.request.프로퍼티명}
      response: ServletResponse 객체.
      param: 요청 파라미터 값 조회. ex) ${param.파라미터명}
      paramValues: 요청 파라미터 값의 배열 조회. ex) ${paramValues.파라미터명}
      header: HTTP 헤더 값 조회. ex) ${header.헤더명}
      headerValues: HTTP 헤더 값의 배열을 조회. ex) ${headerValues.헤더명}
      cookie: 쿠키 값 조회. ex) ${cookie.쿠키명}
      pageScope: PageContext 보관소. ex) ${pageScope.프로퍼티명}
        => ${pageScope.name} ====> pageContext.getAttribute("name");
      requestScope: ServletRequest 보관소. ex) ${requestScope.프로퍼티명}
        => ${request.servletContext} ===> request.getServletContext();
        => ${requestScope.servletContext} ===> request.getAttribute("servletContext");
      sessionScope: HttpSession 보관소. ex) ${sessionScope.프로퍼티명} 
        => ${session.creationTime} ===> session.getCreationTime();
        => ${sessionScope.creationTime} ===> session.getAttribute("creationTime");
      applicationScope: ServletContext 보관소. ex) ${applicationScope.프로퍼티명}
        => ${applicationScope.memberDao} ====> application.getAttribute("memberDao");
9) JSP 주석
 --%>
<%@page import="java.util.HashMap"%>
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
<h1>EL - 산술 연산자 사용법</h1>
\${10 + 20}: ${10 + 20}<br>
\${10 - 20}: ${10 - 20}<br>
\${10 * 20}: ${10 * 20}<br>
\${10 / 20}: ${10 / 20}<br>
\${10 % 20}: ${10 % 20}<br>
\${10 div 20}: ${10 div 20}<br>
\${10 mod 20}: ${10 mod 20}<br>
</body>
</html>












