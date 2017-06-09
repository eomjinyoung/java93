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


