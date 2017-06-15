<%-- JSP 구성 요소 : 템플릿 데이터
1) 템플릿 데이터
   - 화면에 출력할 콘텐츠
   - 아래에 지정된 문법을 제외하고 JSP 파일에 작성하는 모든 텍스트는 템플릿 데이터이다.
   - 자바 코드 
     다음과 같이 출력문을 만든다.
     out.write("템플릿데이터");
     out.print("템플릿데이터");
   - 템플릿 데이터를 가지고 만든 코드는 _jspService() 메서드에 순서대로 삽입된다. 
    
2) 스크립트릿(scriptlet) 엘리먼트
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
  <meta charset="UTF-8">
  <title>JSP</title>
</head>
<body>
<!-- HTML 주석도 템플릿 데이터이다. -->
<h1>JSP 템플릿 데이터</h1>
</body>
</html>