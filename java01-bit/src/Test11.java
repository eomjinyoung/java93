/* 자바 프로그래밍 - 패키지 무소속 클래스*/
public class Test11 {
  public static void main(String[] args) {
    System.out.println("Test11...");
  }

  public static void m1() {
    System.out.println("src/Test11.m1()...");
  }
}

/*
1) 패키지 무소속 클래스
- 패키지에 소속되지 않은 클래스 파일을 만들 때는 아무런 옵션 없이 클래스를 정의하면 된다.
- 컴파일
  java01> javac -d bin src/Test11.java
  => bin/Test11.class

2) 패키지 소속 클래스
- 패키지에 소속시킬 클래스는 소스 파일 첫 부분에 패키지를 선언한다.
- 문법
    package 패키지명;
  예) package other;
- 컴파일
  java01> javac -d bin src/other/Test11.java
  => bin/other/Test11.class
  

*/







//
