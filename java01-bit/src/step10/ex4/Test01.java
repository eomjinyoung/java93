/* super 키워드의 사용
 * => 재정의하기 전의 메서드를 호출할 때 사용한다.
 * => super가 수퍼 클래스를 가리키는 것이라고 착각을 많이 한다.
 * => 정의!
 *    자신을 뺀 조상 클래스로 따라 올라가면서 첫 번째로 만난 메서드를 호출한다.
 *    없으면, 컴파일 오류!
 * => super가 안붙고, this가 붙으면 현재 클래스부터 찾어 올라간다.
 */
package step10.ex4;

public class Test01 {

  public static void main(String[] args) {
    C obj = new C();
    obj.test1();
    System.out.println("----------------------");
    
    obj.test2();
    System.out.println("----------------------");

  }

}
