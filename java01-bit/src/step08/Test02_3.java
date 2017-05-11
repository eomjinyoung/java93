/* 유틸리티 클래스 : String III - 문자열 비교
 * => String 클래스에 구비된 equals() 메서드를 사용하여 비교한다.
 */
package step08;

public class Test02_3 {

  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    
    if (s1.equals(s2)) { // 문자열인스턴스주소1.equals(문자열인스턴스주소2) 
      //equals() 메서드는 s1에 저장된 주소로 찾아가서 그 인스턴스의 문자 배열과
      //s2에 저장된 주소라 찾아가서 그 인스턴스의 문자 배열을 한 개씩 비교하여
      //끝까지 같다면 true를 리턴한다. 다르면 false를 리턴한다.
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
  }

}
