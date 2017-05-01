/* 자바 프로그래밍 - 소스 파일과 바이트코드 파일(클래스 파일)의 분리*/
public class Test08 {
  public static void main(String[] args) {
    System.out.print("Hello,");
    System.out.print("world!\n");
  }
}

/*
소스 파일과 바이트코드 파일이 한 폴더 안에 섞여 있으면 관리하기 불편하다.
- 왜냐하면 배포할 때는 소스 파일을 제외하고 클래스 파일(바이트코드 파일)만 배포해야 하기 때문이다.

해결책?
- 소스 파일과 클래스 파일을 다른 폴더로 분리시키면 된다.
- 방법
  1) 클래스 파일만 모아 둘 폴더(보통 binary의 약자인 bin 이름을 갖는다.)를 생성한다.
    - java01/bin 폴더 생성
  2) 컴파일 할 때 옵션을 주어 클래스 파일이 놓일 위치를 알려준다.
    - 이제부터는 프로젝트 폴더에서 컴파일을 수행한다.
    java01> javac -d bin src/Test08.java

프로젝트 폴더에서 bin 폴더에 들어 있는 클래스 파일 실행하기
- 즉 다른 폴더에 있는 클래스 파일 실행하기.
- 실행 옵션을 주어 클래스 파일이 놓인 위치를 알려준다.
  java01> java -classpath bin Test08
  java01> java -cp bin Test08
  

*/







//
