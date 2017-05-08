/* 변수 선언: 변수의 범위 */
package step02;

//public int i = 100; // 클래스 밖에 명령어를 작성할 수 없다. 컴파일 오류!

public class Test18 {
  static int a = 10; // 클래스 안에서 무제한 사용! "클래스 변수(class variable)"라 부른다.
  
  public static void main(String[] args) {
    System.out.println(a);
    m1(30);
    System.out.println(a);
    
    int b = 20; // main()메서드 안에서 사용! "로컬 변수"라 부른다.
    
    // 다른 메서드의 로컬 변수를 사용할 수 없다.
    // 로컬 변수는 메서드 호출 시에 생성되고,
    // 호출이 끝나면 사라지는 변수이다.
    // d = 400; // 컴파일 오류!
  }
  
  public static void m1(int c) {
    /* 변수 c
     * => m1() 메서드 안에서 사용! 
     * => "로컬 변수"라 부른다.
     * => 로컬 변수 중에 메서드를 호출할 때 넘겨주는 값을 받는 로컬 변수를 
     *    "파라미터(parameter)"라 부른다.
     */
    
    //d = 50; // 자바는 호이스팅(hoisting)을 지원하지 않는다. 컴파일 오류!
    
    int d = 40; // 그냥 로컬 변수. m1() 메서드 안에서만 사용
    a = 200;
  }

}
