/* 유틸리티 클래스 : String
 * => char[] 을 이용하여 내부적으로 문자열을 처리한다.
 * => 문자열을 다루는 기능을 포함하고 있다.
 * => 문자를 저장하는 char[] 배열과
 *    그 배열을 다루는 메서드를 구비한 
 *    데이터 타입이라 볼 수 있다.
 */
package step08;

public class Test02_1 {

  public static void main(String[] args) {
    //1) 문자열의 인스턴스 주소를 저장할 변수 선언
    String s1;
    
    //2) 문자열 인스턴스를 생성
    //=> Heap 영역에 char[] 배열이 만들어지고 그 배열안에 문자열이 보관된다.
    s1 = new String("Hello!");
    
    String s2 = s1;
    
    if (s1 == s2) { // 두 변수에 저장된 주소가 같은지 비교해 보자!
      System.out.println("s1 == s2");
    }
    
  }

}
