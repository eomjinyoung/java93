/* 유틸리티 클래스 : Object
 * => 자바의 최상위 클래스이다.
 * => 모든 자바 클래스는 Object의 서브 클래스이다.
 * => 클래스를 만들 때 특별히 다른 클래스를 상속 받지 않는다면,
 *    자동으로 Object를 상속 받는다.
 * => 왜 자바의 모든 클래스는 Object의 sub 클래스로 만들까?
 *    자바 객체(인스턴스)를 다루기 쉽게 하기 위해서이다.
 * => 하는 일?
 *    => 객체가 기본적으로 갖춰야할 변수와 메서드를 제공하는 역할!
 *    => 주요 메서드
 *       toString()    : 클래스이름과 인스턴스 ID(16진수 표현으로)를 리턴한다.
 *                       => 프로그램 실행할 때 인스턴스의 내부의 값을 간단히 살펴볼 수 있도록
 *                          서브 클래스들이 이 메서드를 재정의 하기도 한다. 
 *       equals()      : 인스턴스의 주소를 비교하여 true/false 값을 리턴한다.
 *                       => 인스턴스 내부의 값을 비교하도록 
 *                          서브 클래스에서 이 메서드를 재정의 하기도 한다. 
 *       hashCode()    : 인스턴스를 구별할 때 사용하는 4바이트 숫자로 된 ID 값을 리턴한다.
 *                       => 인스턴스 변수의 값이 같을 때 같은 ID 값을 리턴하도록
 *                          서브 클래스에서 이 메서드를 재정의 하기도 한다.
 *       getClass()    : 클래스 설계도를 리턴한다.
 *       finalize()    : 쓰레기 수집기(garbage collector)가 가비지를 메모리에서 제거하기 전에
 *                       호출하는 메서드이다.
 *                       => 쓰레기 수집기가 언제 호출되는 지 정확히 예측할 수 없기 때문에,
 *                          보통 활용하지 않는다.
 *       
 */
package step08;

// super 클래스를 지정하지 않으면 자동으로 Object가 수퍼 클래스가 된다.
public class Test03_1 /* extends Object */{
  
  // Student의 수퍼 클래스를 지정하지 않으면 자동으로 Object가 수퍼 클래스로 선언된다.
  static class Student /* extends Object */{
    String name;
  }
  
  public static void main(String[] args) {
    // Student 클래스가 정말 Object의 서브 클래스인지 확인해보자!
    // 어떻게?
    // 서브 클래스라면 수퍼 클래스의 기능을 이용할 수 있어야 할 것이다.
    Student s = new Student();
    System.out.println(s.equals(s));
    System.out.println(s.getClass());
    System.out.println(s.hashCode());
    System.out.println(s.toString());
  }

}







