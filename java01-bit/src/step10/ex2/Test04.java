/* 다형성 - 다형적 변수와 instanceof 연산자 
 * => instanceof 연산자는 레퍼런스에 들어 있는 인스턴스가 
 *    해당 클래스의 인스턴스 또는 그 자손의 인스턴스가 맞는지 검사한다.
 */
package step10.ex2;

public class Test04 {

  public static void main(String[] args) {
    checkReference(new Member());
    checkReference(new Student());
    checkReference(new Manager());
    checkReference(new Teacher());
    checkReference(new FreeStudent());
  }
  
  static void checkReference(Object obj) {
    if (obj instanceof Member) System.out.println("Member의 인스턴스 이다.");
    if (obj instanceof Student) System.out.println("Student의 인스턴스 이다.");
    if (obj instanceof Manager) System.out.println("Manager의 인스턴스 이다.");
    if (obj instanceof Teacher) System.out.println("Teacher의 인스턴스 이다.");
    if (obj instanceof FreeStudent) System.out.println("FreeStudent의 인스턴스 이다.");
    System.out.println("---------------------");
  }

}
