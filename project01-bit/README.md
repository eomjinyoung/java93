# 웹 프로젝트 
## 01. 프로젝트 기본 디렉토리 생성
```
project/
  src/
    main/             <-- 프로그램 소스 파일을 두는 폴더 
      java/           <-- 자바 소스 파일을 두는 폴더
                          예) .java 
      resources/      <-- 프로그램을 실행할 때 사용하는 설정 파일을 두는 폴더.
                          예) .properties, .xml, .txt 등 
      webapp/
                      <-- 웹 자원을 두는 폴더. 이클립스 웹 프로젝트의 WebContent 폴더와 같다.
                          예) .html, .css, .js, .jsp
        WEB-INF/
    test/             <-- 코드를 테스트하는 소스 파일을 두는 폴더
      java/           <-- 단위 테스트 관련 자바 소스 파일을 두는 폴더
                          예) .java 
      resources/      <-- 단위 테스트할 때 사용할 설정 파일을 두는 폴더.
                          예) .properties, .xml, .txt 등
```

## 02 gradle 설정 파일을 준비
1) gradle 빌드 도구를 실행할 때 필요한 설정 파일을 준비한다.
```
프로젝트 폴더> gradle init
build.gradle 등의 파일이 생성된다.
```
2) build.gradle 설정 파일을 편집한다.
3) .gitignore 파일을 편집한다.
4) gradle 명령을 실행하여 이클립스 설정 파일을 만든다.
```
> gradle eclipse
```

## 03 회원관리 서블릿 작성
- GenericServlet 추상 클래스를 상속 받아서 서블릿을 만든다. 

## 04 리프래시, 리다이렉트, HttpServlet 추상 클래스 적용
- 회원 등록 후 목록으로 리다이렉트
- 회원 변경이나 삭제 후 목록으로 리프래시 
- 서블릿 클래스 명을 역할에 맞게 변경

## 05 포워드, 인클루드 적용
- 서블릿 실행 중 오류가 발생하면 ErrorServlet으로 포워딩 시킨다.
- 각 서블릿의 출력 화면에 꼬리말(FooterServlet)과 
  기본 스타일을 출력하는 서블릿(StyleServlet)을 인클루딩 시킨다.
- 꼬리말을 출력할 FootServlet 추가
- 기본 스타일을 출력할 StyleServlet 추가 

## 06 ServletRequest 보관소 적용
- 서블릿에서 발생한 예외 정보를 ServletRequest 보관소에 저장하여 
  ErrorServlet에 전달한다.

## 07 SerlvetContext 보관소와 서블릿 객체 자동 생성 적용
- InitServlet 추가
  - 웹 애플리케이션에서 사용할 객체를 준비하는 서블릿
  - DAO와 DBConnectionPool 객체를 생성하여 ServletContext 보관소에 저장한다.
  - 다른 서블릿들은 이 보관소에 저장된 DAO를 꺼내 사용한다. 

## 08 클래스들을 역할에 따라 패키지로 분리시킨다.
- 소스 코드의 유지보수를 좋게 하기 위해서이다.
  - domain: Member 클래스처럼 사용자 정의 데이터 타입을 다루는 클래스를 둔다.
  - dao: DB 테이블의 데이터를 다루는 클래스를 둔다.
  - util: DBConnectionPool 처럼 기타 유틸리티 클래스를 둔다.
  - servlet: 서블릿 클래스들을 둔다.
  
## 09 ServletContextListener 리스너 적용
- InitServlet 에서 준비하던 DAO 객체를 ServletContextListener 옮긴다.
- 즉 웹 애플리케이션이 시작될 때 공통 객체들을 준비시킨다.
- 예) ContextLoaderListener

## 10 Filter 적용 
- POST 방식으로 서버에 전달되는 데이터의 문자 집합을 지정하는 작업을 
  필터에서 처리한다.
- 필터를 사용하면 각 서블릿 마다 req.setCharacterEncoding("UTF-8")을 
  호출할 필요가 없다.
- 예) CharacterEncodingFilter 

## 11 GET/POST 구분하기
- MemberListServlet, MemberDetailServlet, MemberDeleteServlet 은 GET 요청만 처리하기
- MemberAddServlet, MemberUpdateServlet 은 POST 요청만 처리하기

## 12 로그인 기능 추가하기
- 로그인 폼 추가
  - /webapp/auth/login.html
- 로그인 처리 서블릿 추가
  - servlet.LoginServlet
- 이메일과 암호로 사용자 정보를 조회하는 메서드 추가
  - MemberDao.selectOneByEmailPassword(String email, String password)

## 13 로그인 정보 출력
- 문제 
  - 사용자별로 정보를 관리하고 싶다.
- 해결
  - 로그인 기능을 도입한다.
  - 회원 목록과 상세 보기 페이지에서 로그인 한 사용자의 이름을 출력한다.
- 어떻게?
  1) 로그인에 성공하면 특별한 숫자를 만들어 
     그 숫자로 ServletContext 보관소에 회원 정보를 저장한다.
  2) 사용자에게 회원 정보를 저장할 때 사용한 숫자를 출력한다.
  3) 사용자는 화면에 출력한 숫자를 어딘가에 잘 적어 둔다.
  4) 이후부터 서버에 요청할 때 마다 그 숫자를 파라미터로 넘긴다.
      

## 14 로그인 정보 출력 I + 필터 적용
- 문제
  - 로그인 여부를 검사하는 코드가 여러 서블릿에 중복해 들어있다.
- 해결
  - 로그인 검사를 필터를 이용하여 처리한다.
  - 파라미터에 세션 아이디가 있는지 여부 검사, 세션 아이디가 유효한지 검사하는
    공통 코드를 필터에 담아서 분리한다.
    예) AuthCheckFilter 

## 15 쿠키를 도입하여 세션 ID 관리하기
- 문제
  - 로그인을 한 후 서버에서 발급한 sessionId를 사용자가 손수 관리해야 한다.
  - 사용자가 서비스를 요청할 때 마다 URL 뒤에 sessionId 파라미터를 직접 붙여야 한다.
  - MemberAddServlet, MemberUpdateServlet 과 같이 
    POST 요청을 통해 폼 값을 서버에 보내는 경우,
    사용자가 손수 sessionId를 URL에 붙일 수 없다.
- 해결
  - 웹서버가 웹브라우저에게 보내는 쿠키 바구니를 사용한다.
  - 쿠키 바구니는 사용자가 개입하지 않는다.
- 추가 기능
  - CSS 코드를 별도의 파일로 분리: /css/common.css
  - 로그아웃 기능 추가 : LogoutServlet
    
## 16 쿠키 응용
- 문제
  - 로그인 폼에 매번 이메일을 입력해야 하는 번거로움이 있다.
- 해결
  - 쿠키를 이용하여 로그인 할 때 사용한 이메일을 웹브라우저 쪽에 보관한다.
  - 그런 후 로그인 할 때 마다 쿠키를 받아 폼에 미리 출력한다.
- 방법
  - 입력폼을 출력하는 HTML이 변경될 수 있다. 따라서 정적 HTML 파일 대신
    서블릿을 이용하여 동적으로 로그인폼을 위한 HTML 을 생성해야 한다.    
    => LoginServlet에서 doGet()을 오버라이딩하여 로그인 폼을 출력하게 만든다.
  - /webapp/auth/login.html 파일을 제거한다.
  - HeaderServlet과 LogoutServlet, AuthCheckFilter 변경 
   
## 17 HttpSession 보관소 적용
- 문제 
  - 세션 관리를 개발자가 직접 해야 하기 때문에 코딩이 번거롭다.
  - 즉 세션 아이디를 발급하고 쿠키에 보관하는 코드를 작성해야 한다.
  - 세션 아디를 이용하여 저장된 값을 꺼내는 일을 직접해야 한다.
- 해결
  - Servlet 기술에서 제공하는 HttpSession을 사용하는 것이다.
  - 서블릿 컨테이너는 세션아이디가 없으면 새로운 HttpSession 객체를 생성한다.
  - 세션 아이디를 중복되지 않게 쿠키를 이용하여 발급한다.
  - 웹브라우저가 요청할 때 마다 쿠키에서 세션아이디를 찾아 
    그 아이디로 저장된 HttpSession 저장소를 리턴해준다.
- 방법
  - 단순히 로그인 한 회원 정보를 HttpSession 에 보관하라!
  - 로그인 회원의 정보를 알고 싶다면 HttpSession 보관소에서 꺼내라!
  - LoginServlet, LogoutServlet, AuthCheckFilter, HeaderServlet 변경

## 18 강사 관리 기능 추가 
- 강사 데이터를 다룰 Value Object 추가
  - Teacher.java
- 강사 데이터를 DB에 저장하거나 조회할 DAO 추가
  - TeacherDao.java
- ContextLoaderListener에서 TeacherDao 객체를 준비한다.
  - ContextLoaderListener.java 변경  
- 강사 목록조회 서블릿 추가
  - TeacherListServlet.java
- 강사 상세조회 서블릿 추가
  - TeacherDetailServlet.java
- 강사 등록 서블릿 추가
  - TeacherAddServlet.java
- 강사 변경 서블릿 추가
  - TeacherUpdateServlet.java
- 강사 삭제 서블릿 추가
  - TeacherDeleteServlet.java

## 19 서비스 컴포넌트 추가
- 업무로직과 트랜잭션을 담당할 서비스 컴포넌트 추가
  - TeacherService.java 
- TeacherXxxServlet 서블릿 클래스에서 비즈니스로직을 분리하여 서비스 컴포넌트에 둔다.
  - 비즈니스 로직을 화면처리 코드에서 분리하게 되면, 재사용성이 높아진다.
- ContextLoaderListener에서 TeacherService 객체를 준비한다.
  - ContextLoaderListener.java 변경
- TeacherXxxServlet에서 DAO 대신 Service 컴포넌트를 사용하도록 변경한다.
  - TeacherXxxServlet.java 변경

## 20 강사의 사진 파일 업로드 기능 추가 
- 파일 업로드를 처리할 때 사용할 라이브러리 추가하기
  - build.gradle 파일에 라이브러리 정보 추가
  - "gradle eclipse" 명령 실행
  - 프로젝트 리프래시
- Multipart 폼 데이터를 처리하는 유틸리티 클래스 추가하기
  - MultipartFormDataProcessor.java
- Teacher 클래스에 사진 경로를 저장할 필드를 추가한다.
  - Teacher.java 변경 
- 강사 정보 등록 폼에 사진 파일을 3개 입력 받는 항목을 추가한다.
  - /webapp/teacher/form.html 변경
- 업로드 사진 파일을 저장하고 조회, 삭제한다. 
  - /webapp/teacher/photo/ 디렉토리에 사진 파일 저장한다.
  - TeacherAddServlet, TeacherDetailServlet, TeacherUpdateServlet, TeacherDeleteServlet 변경한다.  
- 강사 정보를 등록하는 서비스 객체 변경
  - TeacherService.java 변경
- 강사 정보를 등록할 때 사진 파일명을 TCH_PHOT 테이블에 입력한다.
  - TeacherDao.java 변경 

## 21 JSP 도입
- JSP 기술과 JSTL 태그 라이브러리를 도입하여 화면 생성을 쉽게 한다.
  - JSTL 라이브러리 검색(mvnrepository.com)
  - build.gradle 파일에 라이브러리 정보 추가
  - "gradle eclipse" 실행
  - 프로젝트 리프래시
- TeacherListServlet 클래스에서 출력 부분을 JSP로 이관한다.
  - 서블릿 클래스에서는 JSP를 include 하면서 DAO에서 가져온 목록 데이터를 넘긴다.
  - /webapp/teacher/list.jsp 추가하여 서블릿에서 받은 목록 데이터로 화면을 출력한다.
- TeacherDetailServlet 클래스에서 출력 부분을 JSP로 이관한다.
  - 서블릿 클래스에서는 JSP를 include 하면서 DAO에서 가져온 목록 데이터를 넘긴다.
  - /webapp/teacher/detail.jsp 추가하여 서블릿에서 받은 목록 데이터로 화면을 출력한다.  
- TeacherUpdateServlet, TeacherDeleteServlet의 리프래시 대신 리다이렉트로 변경
- 인클루드 하는 서블릿 대신 JSP로 변경
  - StyleServlet => /webapp/corestyle.jsp
  - HeaderServlet => /webapp/header.jsp
  - FooterServlet => /webapp/footer.jsp
  - ErrorServlet => /webapp/error.jsp
- TeacherXxxServlet에서 ErrorServlet으로 포워딩 하는 코드를 /webapp/error.jsp로 포워딩 하도록 변경한다.
- 강사, 학생, 관리자를 구분하여 로그인 하도록 처리한다.
  - /webapp/auth/form.jsp 변경
  - LoginServlet.java 변경 
  - /webapp/auth/fail.jsp 추가  

## 22 컴포넌트 간의 관계에 인터페이스를 도입
DAO나 Service 컴포넌트를 대체하기 쉬운 구조로 만든다.

- DAO 인터페이스 생성
  - TeacherDao.java 인터페이스 생성
  - MemberDao.java 인터페이스 생성
- DAO 구현체 생성  
  - 기존의 TeacherDao.java는 TeacherDaoImpl 클래스로 변경한다.
  - 기존의 MemberDao.java는 MemberDaoImpl 클래스로 변경한다. 

- Service 인터페이스 생성
  - TeacherService.java 인터페이스 생성
- Service 구현체 생성
  - 기존의 TeacherService.java를 TeacherServiceImpl 클래스로 변경한다.
   
## 23 프론트 컨트롤러 도입
각각의 컨트롤러가 중복 수행하는 작업을 분리하여 별도의 컨트롤러에 둔다. 
중복 코드 작성을 최소화시킨다.

- 프론트 컨트롤러 역할을 수행할 서블릿 클래스를 정의한다.
  - DispatcherServlet.java 클래스 추가
  - 모든 요청은 이 서블릿이 받아서 위임한다.
- 기존의 서블릿에서 공통 코드를 제거한다.
  - 페이지 컨트롤러로서 작업에 집중하도록 코드를 정리한다.
  - XxxxServlet.java 변경
   
## 24 페이지 컨트롤러를 POJO로 전환
기존에는 페이지 컨트롤러가 서블릿이었다. 그래서 페이지 컨트롤러의 생성은 서블릿
컨테이너가 하였다. 이 페이지 컨트롤러를 일반 자바 클래스로 전환하면,
객체 생성을 개발자가 해야 한다. 이점은 페이지 컨트롤러가 사용하는 Service 
컴포넌트를 페이지 컨트롤러가 관리하는 대신 외부에서 주입해 주기 때문에,
대체하기 쉬운 구조가 된다.

- 프론트 컨트롤러와 페이지 컨트롤러 사이에 호출 규칙을 정의한다.
  - Controller 인터페이스 정의
- 페이지 컨트롤러를 POJO 클래스로 만든다.
  - XxxxServlet 클래스를 control.XxxxControl 클래스로 변경한다.
  - Controller 인터페이스를 구현하도록 변경한다.
- JSP 페이지의 링크 변경
  - URL 뒤에 ".do"를 붙인다.
- ContextLoaderListener에서 페이지 컨트롤러 객체를 준비한다.
  - ContextLoaderListener.java 변경
- DispatcherServlet 프론트 컨트롤러 변경
  - Controller 인터페이스를 구현한 페이지 컨트롤러를 호출하도록 코드를 변경한다. 
- AuthCheckFilter 필터 클래스의 리다이렉트 URL 변경
  - "/auth/login" 대신 "/auth/login.do"로 변경    

## 25 애노테이션을 이용한 객체 생성 및 의존 객체 주입 자동화하기
클래스를 추가할 때 마다 객체 생성하는 코드를 추가한다면 매우 번거롭다.
애노테이션이 붙은 클래스에 대해 객체 생성을 자동화시킨다.

- 애노테이션 정의
  - @Component 애노테이션 추가
- DAO, Service, 페이지 컨트롤러에 @Component 애노테이션을 붙인다.
  - 페이지 컨트롤러는 value 속성의 값으로 URL을 지정한다.
  - 다른 클래스들은 value 속성의 값을 지정하지 않는다.
- ContextLoaderListener 변경
  - @Componenet가 붙은 클래스를 모두 찾아 객체를 생성한 후 ServletContext 보관소에 저장한다.
  - /WEB-INF/classess 폴더에서 클래스 목록을 뽑아서 그 클래스 이름를 가지고
    클래스를 로딩한 후, @Component 애노테이션이 붙은 클래스만 객체를 생성하여 보관할 것이다.
   
## 26 Spring IoC 컨테이너 도입
Spring IoC 컨테이너를 이용하여 객체 생성을 자동화시킨다.

- Spring IoC 컨테이너 라이브러리 추가
  - mvnrepository.com에서 "spring-context" 검색
  - build.gradle의 의존라이브러리 항목에 추가
  - "gradle eclipse" 실행하여 이클립스 설정 파일을 갱신
  - 이클립스에서 프로젝트를 "refresh" 
- ContextLoaderListener 변경
  - 직접 DBConnectionPool, DAO, Service, 페이지 컨트롤러를 다루는 대신
    Spring IoC 컨테이너를 적용한다.
  - Spring 설정 파일 추가 : src/main/resources/bitcamp/java93/application-context.xml
- 기존의 DAO, Service, 페이지 컨트롤러 클래스에 @Component 애노테이션을 붙인다.
  - 우리가 만든 것 대신에 Spring에서 제공하는 @Component 애노테이션이다. 
- 의존 객체 주입을 위해 필드에 @Autowired를 붙인다.
  - 셋터 메서드는 더이상 필요없다. 제거한다.
- 프론트 컨트롤러 변경
  - Spring IoC 컨테이너에 보관된 페이지 컨트롤러를 사용한다.
  - DispatcherServlet 클래스 변경

## 27 Mybatis 퍼시스턴스 프레임워크 도입
개발자가 직접 JDBC 프로그래밍을 하는 대신에 Mybatis를 이용하여 DAO를 구현한다.
- Mybatis와 Mybatis 스프링 연동 라이브러리 가져오기
  - 'mybatis', 'mybatis-spring', 'mybatis-jdbc' 라이브러리 검색
  - build.gradle 에 의존 라이브러리 정보 추가
  - "gradle eclipse" 실행하여 이클립스 설정 파일 갱신
  - 프로젝트 "refresh"
- 스프링 설정 파일(application-context.xml)에 mybatis 관련 객체 추가
  - properties 파일 로딩 객체 추가
  - DataSource 추가
  - TransactionManager 추가
  - SqlSessionFactoryBean 추가
  - MapperScannerConfigurer 추가
- DAO 인터페이스 및 SQL 맵퍼 파일 준비
  - MemberDao 인터페이스 변경 + MemberDao.xml 파일 추가  
  - TeacherDao 인터페이스 변경 + TeacherDao.xml 파일 추가
- Service 구현체를 변경
  - TeacherServiceImpl 클래스 변경
- DAO 구현체 제거

## 28 Spring WebMVC 프레임워크 도입
페이지 컨트롤러를 관리해주는 프레임워크 도입.
- Spring WebMVC 라이브러리 추가 
  - mvnrepository.com에서 "spring-webmvc" 라이브러리 검색
  - build.gradle 설정파일에 의존 라이브러리 정보 추가
  - "gradle eclipse" 실행하여 이클립스 관련 파일 갱신
  - 프로젝트를 "refresh"
- Spring WebMVC에서 제공하는 프론트 컨트롤러를 사용한다.
  - 기존에 우리가 만든 DispatcherServlet 대신 스프링에서 제공하는 클래스를 사용한다.
  - web.xml에 DispatcherServlet 클래스를 등록한다.
- 페이지 컨트롤러를 Spring WebMVC에 맞춘다.
  - 기존에 우리가 만든 Controller 인터페이스를 구현하는 대신에
    스프링에서 제공하는 애노테이션을 사용하여 페이지 컨트롤러를 지정한다.
  - 각각의 페이지 컨트롤러 앞에 @Controller 애노테이션을 붙인다.
  - 요청을 처리할 메서드(예: service()) 앞에 @RequestMapping 애노테이션을 붙인다. 
  - application-context.xml 파일에 Spring WebMVC 관련 기능을 처리할 객체를 등록한다.
  
## 29 Spring WebMVC 프레임워크 - 세션 및 파일 업로드, WebBindingInitializer 적용
- ViewResolver 등록 
  - JSP를 찾아 실행시키는 객체
  - 모든 페이지 컨트롤러는 등록된 ViewResolver 설정에 맞추어 JSP URL을 변경한다.
- 파일 업로드 처리 객체 등록
  - 멀티파트 형식으로 넘어오는 요청 데이터를 처리할 객체를 등록한다.
- 페이지 컨트롤러의 Request Handler 아규먼트 정리
  - LoginControl과 LogoutControl을 합쳐서 AuthControl로 만든다.
  - Teacher CRUD를 한 개의 TeacherControl로 합친다.
  - 각각의 페이지 컨트롤러에 대해 아규먼트 및 애노테이션 정리
  
## 30 트랜잭션(transaction) 적용하기 I - <aop:config/> 와 <tx:advice/> 사용
여러 작업을 한 작업으로 묶은 것을 트랜잭션이라 한다. 트랜잭션에 묶인 작업은
모두다 성공해야만 작업이 완료된다. 한 개의 작업이라도 실패하면 기존에 했던 작업을
모두 취소한다. 
- AOP 관련 라이브러리 추가 (build.gradle)
  - 'aspectjweaver' 의존 라이브러리 추가
- Spring 설정 파일에 트랜잭션 관련 태그 추가 (application-context.xml)
  - point-cut(트랜잭션을 적용할 위치)을 지정한다.
  - 트랜잭션 관리자를 이용하여 트랜잭션을 처리할 AOP 필터를 지정한다.
  - point-cut과 advisor를 연결한다.

## 31 트랜잭션(transaction) 적용하기 II - @Transactional 애노테이션 사용
애노테이션을 사용하여 트랜잭션을 적용할 메서드를 지정할 수 있다.
- Spring 설정 파일에 @Transactional 애노테이션을 처리할 객체 등록
- 서비스 객체의 각 메서드에 대해 @Transactional을 붙인다.

### 트랜잭션 정책

Propagation | caller의 tx 존재 여부 
----------|----------------------------- 
REQUIRED |
REQUIRES_NEW |
| SUPPORTS |
| NOT_SUPPORTED |
| MANDATORY |
| NEVER |

## 32 JSON 콘텐트를 출력하는 RESTful 구축하기
페이지 컨트롤러는 HTML 페이지를 응답하는 대신에 JSON 데이터를 보낸다.
- JSON 응답 데이터를 표현할 Value Object 클래스를 만든다.
  - *.json.JsonResult 클래스 생성
- JSON 데이터를 내보내는 페이지 컨트롤러 만들기
  - 기존에 페이지 컨트롤러 클래스를 복사하여 *.json 패키지에 넣는다. 
  - 페이지 컨트롤러에 @Controller 대신에 @RestController를 붙인다.
  - 각각의 메서드는 JSP URL 대신에 객체를 리턴한다. 
- JSON 데이터를 요청할 때는 *.do 대신 *.json을 사용하도록 설정한다.
  - web.xml에 프론트 컨트롤러를 추가한다.
  - application-context.xml 을 복사하여 dispatcher-servlet.xml과 json-servlet.xml을 만든다.
  - dispatcher-servlet.xml에는 오직 *.do 요청 처리와 관련된 객체만 설정한다.
  - json-servlet.xml에는 오직 *.json 요청 처리와 관련된 객체만 설정한다.
- 프론트 컨트롤러가 공통으로 사용할 객체 준비
  - 기존의 application-context.xml에서 웹 관련 객체를 제외한다.
  - ContextLoaderListener를 web.xml에 추가한다.  

## 33 역할에 따라 컴포넌트의 애노테이션을 구분하여 붙이기
스프링은 @Component 애노테이션 외에 유지보수가 쉽도록 각 클래스의 역할을 구분하기 
쉽도록 추가 애노테이션을 제공한다. 이 애노테이션들은 @Component와 마찬가지로
IoC 컨테이너가 관리한다.

- 스프링 IoC 컨테이너가 객체를 생성하여 관리하는 애노테이션
  - @Component : 일반적인 클래스에 붙인다.
  - @Controller : 페이지 컨트롤러에 붙인다.
  - @RestController : RESTful 기능을 제공하는 페이지 컨트롤러에 붙인다.
  - @Service : 서비스 역할을 하는 클래스에 붙인다.
  - @Repository : DAO 역할을 하는 클래스에 붙인다.
- 우리의 예제는 DAO객체를 Mybatis가 자동 생성하기 때문에 Service에 대해서만 붙이면 된다. 
  
## 34 AJAX를 이용하여 back-end 와 front-end를 분리하기
 
  
  
  
  
  