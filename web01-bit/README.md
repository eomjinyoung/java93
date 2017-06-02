# 이클립스와 웹 애플리케이션

## 이클립스에 웹 애플리케이션 서버(ex:톰캣) 실행환경 구축하기

- 1. 웹 애플리케이션 서버(ex:톰캣)가 설치된 폴더를 등록하기
  - Window 메뉴 > Preferences > Server 노드 > Runtime Environments > Add 버튼 클릭

- 2. 웹 애플리케이션 서버(ex:톰캣) 실행 환경 구축
  - Servers 뷰 > new 컨텍스트 메뉴 > Server 클릭 
  => 웹 애플리케이션 서버 실행 환경은, 이클립스에 설정된 서버에 대해서만
   실행환경을 구축할 수 있다.
   
- 3. 웹 애플리케이션 서버 실행 환경 시작하기
  - Servers 뷰 > 서버실행환경 선택 > start 클릭 

- 4. 실행환경이 구축된 폴더 확인하기
  - 워크스페이스폴더(ex: c:\workspace)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0

## 웹 애플리케이션 프로젝트 만들기
- 이클립스에서 직접 웹 프로젝트를 만드는 방법
  - File 메뉴 > New > Dynamic Web Project 클릭
  - 다른 사람과 프로젝트 폴더를 공유하기 어렵다.
  - 이유? 프로젝트 설정 파일은 개별적인 PC 환경을 반영하기 때문이다.
  
- Gradle 도구를 사용하여 이클립스 웹 프로젝트 만드는 방법
  - build.gradle 파일에 이클립스 웹 프로젝트 관련 정보를 설정한다.
  - 터미널에서 "gradle eclipse" 명령을 실행하여 이클립스 설정 파일을 만든다.
  - 이클립스에 프로젝트를 import 안했으면 import를 한다.
  - 이미 이클립스에 프로젝트가 있다면 해당 프로젝트에 대해 "Refresh" 한다.

## 웹 애플리케이션을 서버실행환경에 배치하기 
- Servers > 실행환경 > 컨텍스트 메뉴 > Add and Remove... 클릭
- 왼쪽 목록에 나열되어 있는 웹 프로젝트를 선택하여 오른쪽 목록에 추가한다. 

## 톰캣의 디렉토리 구조
- bin/ 
  - 톰캣 서버 실행과 관련된 쉘 스크립트 파일(.sh, bat 등)을 모아둔 곳
- conf/
  - 톰캣 서버를 실행할 때 참조할 설정 파일을 모아둔 곳
- lib/
  - 톰캣 서버를 구성하는 자바 클래스 라이브러리들을 모아둔 곳
- logs/
  - 톰캣 서버가 실행하는 동안 실행 또는 오류 정보를 기록한 파일을 모아둔 곳
- temp/
  - 톰캣 서버가 실행하는 동안 임시 데이터를 보관하는 디렉토리
- work/
  - 톰캣 서버가 JSP를 실행할 때 그 중간 파일을 보관하는 곳
- webapps/
  - 웹 애플리케이션을 모아둔 곳

## 개발용 웹 애플리케이션 실행 환경
- $workspace/Servers/localhost.../*.xml
  - 톰캣 서버의 설정 파일을 복사해 온다.
  
## 이클립스 웹 애플리케이션 프로젝트 폴더 구조
- 이클립스에서 웹 프로젝트를 다룰 때 폴더 구조이다.
- IntelliJ 나 NetBeans 등 다른 IDE를 사용할 때는 폴더 구조가 다를 수 있다.
 
$workspace/web01
- src : 자바 소스 파일을 두는 곳
- WebContent : HTML, CSS, JavaScript, GIF 등 정적 웹 자원을 두는 곳. JSP 파일도 둔다.
  - /WEB-INF : 웹 애플리케이션 정보 파일을 두는 곳
  - /WEB-INF/classes : 자바 클래스 파일(.class)을 두는 곳
  - /WEB-INF/lib : 자바 라이브러리 파일(.jar)을 두는 곳
  - web.xml : 웹 애플리케이션 설정 파일
      
## 웹 애플리케이션 배치 폴더 구조
- $deployment_dir/
  - HTML, CSS, JavaScript, GIF 등 정적 웹 자원 및 JSP 파일도 둔다.
  - WEB-INF/web.xml
  - WEB-INF/classes : 자바 클래스 파일을 둔다.
  - WEB-INF/lib : 자바 라이브러리 파일을 둔다.
  






