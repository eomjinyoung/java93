/* 클래스 로딩 절차
 * => 현재 Method Area에 해당 클래스가 로딩되어 있지 않을 때 로딩한다.
 * => 이미 로딩되어 있다면 다시 로딩하지 않는다.
 * => 절차!
 * 1) JRE 라이브러리 폴더에서 클래스를 찾는다.
 * 2) 없으면, CLASSPATH 환경 변수에 지정된 폴더에서 클래스를 찾는다.
 * 3) 찾았으면, 그 클래스 파일이 올바른 바이트코드인지 검증한다.
 * 4) 올바른 바이트코드라면, Method Area 영역으로 파일을 로딩한다.
 * 5) 클래스 변수를 만들라는 명령어가 있으면 Method Area에 그 변수를 준비한다.
 * 6) 클래스 안에 스태틱 블록들이 있으면 순서대로 그 블록을 실행한다.
 * 
 */
package step07;

public class Test01_3 {
  static class Student {
    // 클래스 변수는 기본 값으로 0을 갖는다.
    // 주소 변수: null
    // 정수 변수(byte, short, int, long, char): 0,
    // 부동소수점 변수(float, double) : 0.0
    // 논리 변수(boolean) : false
    // => 사실 null이나 false, 0.0 모두 메모리가 0으로 셋팅된다는 것을 의미한다.
    static String name; // 클래스 변수 아니다! 클래스를 로딩한 후 클래스 변수를 만들라는 명령!
    static int age;
    static boolean working;
  }
  
  public static void main(String[] args) {
    // 클래스 변수 사용법:
    // 클래스명.변수명
    System.out.println(Student.name);
    System.out.println(Student.age);
    System.out.println(Student.working);
    
    Student.name = "홍길동";
    Student.age = 20;
    Student.working = true;
    
    System.out.println(Student.name);
    System.out.println(Student.age);
    System.out.println(Student.working);
    
    int a;
    // 주의!
    // => 로컬 변수는 0 값으로 자동 초기화 되지 않는다. 
    // => 클래스 변수와 인스턴스 변수만이 0으로 자동 초기화 된다. 
    //System.out.println(a); // 초기화시키지 않고 사용하려 하면 컴파일 오류!
    
    
    
  }

}
