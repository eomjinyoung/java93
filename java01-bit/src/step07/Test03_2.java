/* 초기화 블록: 인스턴스 블록
 * => 인스턴스가 생성된 후 자동으로 실행하는 블록
 * => 한 클래스 안에 여러 개의 인스턴스 블록을 넣을 수 있다.
 * => 인스턴스를 생성한 후, 생성자가 호출되기 전에 
 *    인스턴스 블록은 선언된 순서대로 실행된다.
 * => 문법
 *    {...}
 * => 용도
 *    인스턴스 변수를 초기화시키는 코드를 둔다.
 *    어떤 생성자가 호출되든 그 전에 공통으로 초기화시키고 싶은 
 *    작업이 있다면 인스턴스 블록에서 처리하면 된다. 
 */
package step07;

public class Test03_2 {
  static class Student {
    static String name = "홍길동"; // 변수를 선언할 때 값을 초기화시키는 문장을 포함할 수 있다.
    int age = 20;
    static {
      System.out.println("static {...}");
    }
    { // 인스턴스 블록
      // 인스턴스 블록은 인스턴스 주소를 보관한 this라는 변수가 내장되어 있다.
      System.out.println(age);
      System.out.println("{인스턴스 블록 실행...1}");
      this.age = 30;
    }
    
    {
      System.out.println("{인스턴스 블록 실행...2}");
    }
    
  }
  
  public static void main(String[] args) {
    new Student();
    System.out.println("-------------------------");
    new Student();
    
  }

}
