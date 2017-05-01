/* 자바 프로그래밍 - 다른 패키지에 있는 클래스의 메서드 호출하기*/
public class Test12 {
  public static void main(String[] args) {
    //패키지 무소속 클래스 Test11의 m1() 메서드 호출!
    Test11.m1();

    //패키지 other에 속해있는 클래스 Test11의 m1() 메서드 호출
    other.Test11.m1();
  }
}

/*
다른 패키지에 있는 클래스의 메서드 호출하기
- 방법
  패키지명.패키지명.패키지명.클래스명.메서드명()

다른 패키지의 있는 클래스를 사용할 경우,
클래스를 컴파일할 때 그 클래스가 있는 경로를 JVM에게 알려줘야 한다.
- 방법
  javac -d 컴파일이_완료된_클래스_파일이_놓일_위치
        -cp 또는 -classpath 이_클래스에서_사용하는_다른_클래스가_놓인_위치
        자바_소스명
  java01> javac -d bin -cp bin src/Test12.java   

*/







//
