<%-- JSP 구성 요소 : 지시어 엘리먼트 - page
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트
   - <%@ page %> 
     language 속성: 
       스크립트릿 등에서 사용하는 프로그래밍 언어가 무엇인지 지정.
       현재 java 밖에 안된다. 
       원래 의도는 다른 프로그래밍 언어를 사용할 경우도 고려했다.
     contentType 속성: 
       response.setContentType() 코드를 생성
     pageEncoding 속성: 
       JSP 파일이 어떤 인코딩으로 저장되었는지 지정한다.
       JSP 엔진이 JSP 파일을 읽을 때 사용한다.
     trimDirectiveWhitespaces 속성: 
       JSP 태그를 사용한 후 줄 바꿈 코드가 있을 때 제거여부. 
     buffer 속성:
       출력 스트림의 기본 버퍼 크기를 지정한다. 기본 8KB.
     autoFlush 속성: 
       버퍼가 찼을 때 자동으로 출력할 지 여부. 기본 true.
     import 속성:
       import 문을 추가할 때 사용.
       콤마(,)로 여러 개의 패키지를 지정할 수 있다.
       또는 여러 개의 <%@ page import="..."%> 태그를 작성할 수 있다.
   - <%@ include %>
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
    trimDirectiveWhitespaces="true"
    buffer="8kb"
    autoFlush="true"
    import="java.util.ArrayList,java.net.Socket"%>
<%@ page import="java.io.File" %>
<%@ page import="java.io.Serializable" import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSP</title>
</head>
<body>
<!-- HTML 주석도 템플릿 데이터이다. -->
<h1>지시 엘리먼트 - page</h1>
</body>
</html>