/* 주제: Electron 모듈 사용하기
- Electron 은 크로스 플랫폼을 지원하는 데스크탑 애플리케이션을
  만들 때 사용하는 NodeJS 용 자바스크립트 프레임워크이다.
- HTML, CSS, JavaScript를 사용하여 윈도우 프로그래밍을 한다.
- 오픈 소스 웹브라우저 콤포넌트인 Chromium과 NodeJS를 사용하여 실행한다.
- Chromium은 구글의 크롬(chrome) 브라우저의 오픈소스판이다.
- 사용법:
1) 노드 패키지 관리자(npm)를 사용하여 Electron 모듈을 가져온다.
   > npm install electron -g    <== 글로벌로 설치하라.
   > electron -v      <== 버전을 출력해서 설치여부를 확인하라.
2) Electron을 사용해서 윈도우 생성
  => package.json 파일 생성 - 프로그램 설정 파일
  => main.js 파일 생성 - 자바스크립트 실행 시작 파일
  => index.html 파일 생성 - 메인 윈도우 설정 파일
3) 실행
  > electron .
  => 현재 폴더에서 package.json을 읽어 들인다.
  => package.json 파일에 등록된 자바스크립트 파일을 읽어 실행한다.
 */
