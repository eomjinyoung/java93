/* 유틸리티 클래스 : String V - 상수 문자열과 문자열 인스턴스
 */
package step08;

public class Test02_5 {

  public static void main(String[] args) {
    String s1 = "Hello"; 
    String s2 = "Hello"; 
    String s3 = new String("Hello");
    String s4 = new String("Hello");
    
    if (s1 == s2) {  
      System.out.println("s1 == s2");
    } 
    if (s1 == s3) {
      System.out.println("s1 == s3");
    }
    if (s3 == s4) {
      System.out.println("s3 == s4");
    }
  }

}
