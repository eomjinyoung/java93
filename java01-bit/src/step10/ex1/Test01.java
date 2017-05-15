/* 다형성: 오버라이딩(overriding) - 수퍼 클래스의 메서드를 재정의 하는 방법
 * => 왜 재정의하는데?
 *    서브 클래스의 조건에 맞춰서 기능을 바꾸기 위함이다.
 */
package step10.ex1;

public class Test01 {

  public static void main(String[] args) {
    Student s = new Student();
    s.name = "홍길동";
    s.age = 20;
    s.print();
    
  }

}
