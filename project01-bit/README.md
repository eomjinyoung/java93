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










