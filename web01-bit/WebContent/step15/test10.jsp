<%-- JSP 구성 요소 : JSP 액션 태그 - jsp:useBean II
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트      
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
   => JSP에서 기본으로 제공하는 태그이다.
   => 이 태그를 사용하기 위해 따로 라이브러리를 가져오는 taglib 를 선언할 필요가 없다.
   jsp:useBean
   => ServletContext(application), HttpSession(session), ServletRequest(request),
      PageContext(page) 보관소에서 객체를 찾을 때 사용한다.
      또는 객체를 생성하여 보관소에 저장할 때 사용한다.
   id 속성: 
     값을 보관소에 저장할 때 사용할 이름. 변수명으로도 사용.
   class 속성: 
     변수의 타입. 보관소에 객체가 없으면 이 클래스의 인스턴스를 생성함.
     import를 했는지 여부와 상관없이 반드시 전체 클래스 이름을 적어야 한다.
   scope 속성: 
     객체를 꺼내는 보관소 가리킴. 기본이 PageContext이다.
     만약 보관소에 객체가 없다면 생성한다.
   type 속성: 
     변수의 타입을 지정할 때 사용한다.  
     type 속성이 없으면 class 속성의 값이 변수의 타입이 될 것이다.
     객체를 생성하지 않는다.
     그래서 인터페이스를 지정할 수 있다.
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
<h1>JSP 액션 태그 - jsp:useBean II</h1>
<jsp:useBean id="list" 
   type="java.util.ArrayList" 
   scope="page"></jsp:useBean>
<%-- 
위의 태그는 다음과 비슷한 자바 코드를 생성한다.
java.util.ArrayList list = (java.util.ArrayList)pageContext.getAttribute("list");
if (list == null) {
  throw new .... // 보관소에 객체가 없으면, 예외를 던진다. 
} 
--%>
<%--
list.add("홍길동");
list.add("임꺽정");

for (Object value : list) {
  out.println(value + "<br>");
}
--%>

</body>
</html>






