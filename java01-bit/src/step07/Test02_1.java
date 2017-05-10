/* 인스턴스 변수
 * => new 명령을 통해 생성하는 변수이다.
 * => 값을 개별적으로 구분해서 관리할 필요가 있을 때 사용한다.
 * => 클래스가 로딩될 때 생성되지 않는다.
 * => 인스턴스 주소를 통해 접근할 수 있다.
 * => 인스턴스 주소를 잃어버리면 해당 변수를 사용할 수 없다.`
 * => 변수 선언에 static을 붙이지 않는다.
 */
package step07;

public class Test02_1 {
  static class Student {
    // 인스턴스 변수는 기본 값으로 0을 갖는다.
    // 주소 변수: null
    // 정수 변수(byte, short, int, long, char): 0,
    // 부동소수점 변수(float, double) : 0.0
    // 논리 변수(boolean) : false
    // => 사실 null이나 false, 0.0 모두 메모리가 0으로 셋팅된다는 것을 의미한다.
    String name; // 인스턴스 변수가 아니다! new 명령어를 실행할 때 힙에 변수를 만들라는 명령!
    int age;
    boolean working;
  }
  
  public static void main(String[] args) {
    // 인스턴스 변수 사용법:
    // 인스턴스의주소.변수명
    Student s1 = new Student();
    Student s2 = new Student();
    
    System.out.println(s1.name); // 항상 로컬 변수는 값을 설정한 다음에 사용해야 한다.
    System.out.println(s1.age);
    System.out.println(s1.working);
    System.out.println("---------------------------");
    
    s1.name = "홍길동";
    s1.age = 20;
    s1.working = true;
    
    System.out.println(s1.name);
    System.out.println(s1.age);
    System.out.println(s1.working);
    System.out.println("---------------------------");
    
    // s1이 가리키는 인스턴스의 변수들은 s2가 가리키는 인스턴스의 변수들하고 관계가 없다.
    // 서로 독립적인 값을 갖는다.
    // 그래서 서로 독립적인 값을 갖도록 하려면,
    // 클래스 변수가 아닌 인스턴스 변수로 만들어야 한다.
    System.out.println(s2.name);
    System.out.println(s2.age);
    System.out.println(s2.working);
    
    
  }

}
