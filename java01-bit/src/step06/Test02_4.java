/* class 문법의 용도: 관련된 메서드를 묶는 용도 IV
 * => 클래스를 별도의 파일로 분리시킨다.
 * => 소스 코드를 기능 별로 묶어 파일로 분리시키면 관리하기 편해진다.
 */
package step06;

public class Test02_4 {
  
  public static void main(String[] args) {
    // 별도 파일로 분리된 클래스의 코드를 사용한다.
    // 이 파일 안에 코드가 없고 다른 파일에 있기 때문에 소스 코드를 관리하기 쉽다. 
    Member.init("홍길동", 100, 100, 100);
    Member.compute();
    Member.print();

  }

}
