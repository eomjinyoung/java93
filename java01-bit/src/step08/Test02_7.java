/* 유틸리티 클래스 : String VII - replace() 메서드와 Mutable 객체
 * => mutable(변할 수 있는) 객체
 *    StringBuffer 클래스는 mutable 객체이다.
 *    원본을 변경할 수 있다. 
 */
package step08;

public class Test02_7 {

  public static void main(String[] args) {
    // StringBuffer 인스턴스는 상수 문자열로 인스턴스를 만들 수 없다.
    // 반드시 new 명령을 사용해야 한다.
    StringBuffer s1 = new StringBuffer("Hello"); 
    
    s1.replace(2, 4, "xx");
    
    System.out.println(s1);
  }

}
