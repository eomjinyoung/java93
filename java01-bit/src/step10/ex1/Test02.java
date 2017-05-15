/* 수퍼 클래스의 메서드를 재정의 하는 방법 II
 * => 서브 클래스의 조건에 따라 수퍼 클래스의 메서드를 그냥 쓸 수 없다면,
 *    서브 클래스에서 재정의해야 한다.
 */
package step10.ex1;

public class Test02 {

  public static void main(String[] args) {
    BitStudent s = new BitStudent();
    s.name = "홍길동";
    s.age = 20;
    s.school = "비트대학교";
    s.print();
    
  }

}
