/* nested class: anonymous class
 * => 클래스를 정의할 때 이름이 없다.
 * => 이름이 없기 때문에 클래스를 정의한 후 나중에 따라 인스턴스를 생성할 수 없다.
 * => 클래스를 정의하자 마자 바로 인스턴스를 생성해야 한다.
 * => 보통 클래스를 딱 한 번만 정의해서 사용할 경우에 적합한 문법이다.
 * => 익명클래스 만드는 문법
 *    1) 참조변수 선언 = new 수퍼클래스이름(수퍼클래스의 생성자호출 파라미터) {...}
 *    2) 참조변수 선언 = new 인터페이스이름(수퍼클래스의 생성자호출 파라미터) {...}
 *       
 */
package step13;

import java.lang.reflect.Method;

public class Test05_1 {
  public static void main(String[] args) throws Exception {
    //1) Object를 상속 받은 익명 클래스 만들기
    Object obj = new Object() {
      int value;
      
      // 익명클래스는 클래스 이름이 없기 때문에 생성자를 만들 수 없다.
      // 그러나 인스턴스 블록은 가능하다.
      // 그래서 익명 클래스의 인스턴스 변수 값을 초기화시킬 때 
      // 인스턴스 블록을 사용한다.
      {
        System.out.println("인스턴스 블록....");
        value = 100;
      }
      
      public void m1() {
        System.out.println("m1()...");
        System.out.println(value);
      }
    };
    
    // 익명 클래스는 클래스 이름이 없기 때문에
    // 수퍼 클래스의 참조 변수나 인터페이스의 참조 변수를 사용하여
    // 인스턴스 주소를 저장할 수 밖에 없다.
    // 그래서 위의 익명 클래스의 인스턴스 주소를 Object 참조 변수에 저장하였다.
    
    // 문제는 수퍼 클래스에 없는 메서드는 익명 클래스에 추가했을 때
    // 그 메서드를 호출할 방법이 없다!
    //obj.m1(); // 컴파일 오류!
              // 컴파일러는 오직 obj 변수의 타입(클래스)만 보고 메서드를 찾는다.
              // obj의 타입은 Object 클래스이고, 
              // Object 클래스는 m1()이라는 메서드가 없다.
    
    // 익명 클래스의 메서드를 호출하는 방법은 없는가?
    // 있다! Class 정보를 전문적으로 분석해주는 도구를 이용하여 메서드를 찾는다.
    // 그리고 그 메서드를 호출한다.
    Class clazz = obj.getClass();
    Method m = clazz.getMethod("m1");
    m.invoke(obj);
    
    
  }
  
}
